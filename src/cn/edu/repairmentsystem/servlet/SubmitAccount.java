package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.AccountInfoDao;

public class SubmitAccount extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("no");
		
		int accno = Integer.parseInt(no);
		AccountInfoDao accountdao = new AccountInfoDao();
		boolean result = accountdao.updateCondition(accno);
		
		String message=null;
		if(result)
			message="缴费成功";
		else
			message="缴费失败！";
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/account/query1_account.jsp'");
		out.println("</script>");
		out.flush();
	}

}
