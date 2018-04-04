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
		
		String equname = request.getParameter("equname"); //�豸����
		String equmodel = request.getParameter("equmodel");  //�豸�ͺ�
		String stochangenum = request.getParameter("stochangenum"); //���������
		String stotime = request.getParameter("stotime"); //�����ʱ��
		String stotype = "����";  //����
		
		EquipmentInfoDao equdao = new EquipmentInfoDao();
		
		int equid = equdao.queryEquid(equname, equmodel);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		
		try {
			date = f.parse(stotime);
		} catch (ParseException e) {
			e.printStackTrace();
		}//format�ǽ�����ת��Ϊ�ַ���
		
		StorageInfo storageInfo = new StorageInfo(0,Integer.parseInt(stochangenum),date,stotype,equid);
		
		StorageInfoDao stodao = new StorageInfoDao();
		
		result = stodao.addStorageInfo(storageInfo);
		
		String message = null;
		if(result) {
			equdao.updateEqunum(-Integer.parseInt(stochangenum), equid);
			message = "����������Ϣ��ӳɹ���";
		}
		else {
			message = "������Ϣ�����޷���ӳ�����Ϣ��";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/outofstorage'");
		out.println("</script>");
		out.flush();
	}

}
