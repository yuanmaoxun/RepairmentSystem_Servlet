package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.EquipmentInfoDao;
import cn.edu.repairmentsystem.dao.StorageInfoDao;
import cn.edu.repairmentsystem.javabean.EquipmentInfo;
import cn.edu.repairmentsystem.javabean.StorageInfo;

public class OutofStorage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EquipmentInfoDao dao = new EquipmentInfoDao();
		ArrayList<EquipmentInfo> result = dao.queryEquname();
		
		request.setAttribute("equname", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/storage/outofstorage.jsp");
		dis.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean result = false;
		
		String equname = request.getParameter("equname"); //设备名称
		String equmodel = request.getParameter("equmodel");  //设备型号
		String stochangenum = request.getParameter("stochangenum"); //出入库数量
		String stotime = request.getParameter("stotime"); //出入库时间
		String stotype = "出库";  //类型
		
		EquipmentInfoDao equdao = new EquipmentInfoDao();
		
		int equid = equdao.queryEquid(equname, equmodel);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		
		try {
			date = f.parse(stotime);
		} catch (ParseException e) {
			e.printStackTrace();
		}//format是将日期转换为字符串
		
		StorageInfo storageInfo = new StorageInfo(0,Integer.parseInt(stochangenum),date,stotype,equid);
		
		StorageInfoDao stodao = new StorageInfoDao();
		
		result = stodao.addStorageInfo(storageInfo);
		
		String message = null;
		if(result) {
			equdao.updateEqunum(-Integer.parseInt(stochangenum), equid);
			message = "备件出库信息添加成功！";
		}
		else {
			message = "备件信息错误，无法添加出库信息！";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/outofstorage'");
		out.println("</script>");
		out.flush();
	}

}
