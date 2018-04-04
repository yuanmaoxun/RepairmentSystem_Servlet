package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.EquipmentInfoDao;
import cn.edu.repairmentsystem.javabean.EquipmentInfo;

public class AddStorage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String equname = request.getParameter("equname");
		String equmodel = request.getParameter("equmodel");
		String equcost = request.getParameter("equcost");
		String equalternum = request.getParameter("equalternum");
		String equnum = request.getParameter("equnum");
		String equcondition = null;
		
		int cost = Integer.parseInt(equcost);
		int alternum = Integer.parseInt(equalternum);
		int num = Integer.parseInt(equnum);
		
		if(num > alternum) {
			equcondition = "正常";
		}
		else
			if(num == alternum) {
				equcondition = "临界";
			}
		else
			if(num < alternum && num > 0) {
				equcondition = "警示";
			}
		else
			if(num == 0) {
				equcondition = "缺货";
			}
		EquipmentInfo einfo = new EquipmentInfo(0,equname,equmodel,cost,alternum,num,equcondition);
		
		EquipmentInfoDao dao = new EquipmentInfoDao();
		boolean result = dao.addEquipmentInfo(einfo);
		
		String message=null;
		if(result)
			message="添加备件信息成功";
		else
			message="添加备件信息失败";
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/storage/intostorage.jsp'");
		out.println("</script>");
		out.flush();
	}
}
