package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.EquipmentInfoDao;
import cn.edu.repairmentsystem.javabean.EquipmentInfo;

public class UpdateStorage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String equid = request.getParameter("equid");
		String equname = request.getParameter("equname");
		String equmodel = request.getParameter("equmodel");
		String equcost = request.getParameter("equcost");
		String equnum = request.getParameter("equnum");
		String equalternum = request.getParameter("equalternum");
		
		EquipmentInfo equip = new EquipmentInfo(Integer.parseInt(equid),equname,equmodel,Integer.parseInt(equnum),Integer.parseInt(equcost),Integer.parseInt(equalternum),null);
		
		EquipmentInfoDao equipdao = new EquipmentInfoDao();
		
		boolean result = equipdao.updateStorage(equip);
		
		String message = null;
		if(result) {
			message = "备件信息修改成功！";
		}
		else {
			message = "备件信息修改失败！";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/storage/query.html'");
		out.println("</script>");
		out.flush();
		
	}

}
