package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.FixRecordDao2;
import cn.edu.repairmentsystem.dao.StorageInfoDao;
import cn.edu.repairmentsystem.javabean.FixRecord;

public class AddFixRecord extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fixno = request.getParameter("fix_no");
		String fixstaffno = request.getParameter("fix_staffno");
		String repno = request.getParameter("rep_no");
		String fixallocatetime = request.getParameter("fix_alocatetime");
		String fix_check = request.getParameter("fix_check");
		String fix_fix = request.getParameter("fix_fix");
		String fixchecktime = request.getParameter("fix_checktime");
		String fix_quantity = request.getParameter("fix_quantity");
		String fixmoney = request.getParameter("fix_money");
		String fixmaterial = request.getParameter("fix_material");
		String fix_attention = request.getParameter("fix_attention");
		String fix_condition = request.getParameter("fix_condition");
		String fix_level = request.getParameter("fix_level");
		
		int fix_no = Integer.parseInt(fixno);
		int rep_no = Integer.parseInt(repno);
		int fix_staffno = Integer.parseInt(fixstaffno);
		Double fix_money = Double.parseDouble(fixmoney);
		Double fix_material = Double.parseDouble(fixmaterial);
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		
		Date fix_allocatetime  = null;
		Date fix_checktime = null;
		
		try {
			fix_checktime = f.parse(fixchecktime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		FixRecord fix = new FixRecord(fix_no,fix_staffno,fix_allocatetime,fix_check,fix_fix,fix_checktime,fix_quantity,fix_money,fix_material,fix_attention,fix_condition,fix_level,rep_no,null);
		FixRecordDao2 fixdao = new FixRecordDao2();
		
		boolean result1 = fixdao.addFixRecord(fix);
		
		String message = null;
		if(result1) {
			message = "维修信息添加成功！";
		}
		else {
			message = "维修信息添加失败！";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/fix/sparetable.jsp'");
		out.println("</script>");
		out.flush();
		
	}

}
