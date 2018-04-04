package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.AccountInfoDao;
import cn.edu.repairmentsystem.javabean.AccountInfo;


public class AddAccount extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accno = request.getParameter("accno");
		String fixno = request.getParameter("fixno");
		String acccal = request.getParameter("cost");
		
		int acc_no = Integer.parseInt(accno);
		int fix_no = Integer.parseInt(fixno);
		double acc_cal = Double.parseDouble(acccal);
		String acc_condition = "未交费";
		
		AccountInfo  account = new AccountInfo();
		account.setAcc_no(acc_no);
		account.setFix_no(fix_no);
		account.setAcc_cal(acc_cal);
		account.setAcc_condition(acc_condition);
		
		AccountInfoDao accountdao = new AccountInfoDao();
		
		boolean result = accountdao.queryFixno(fix_no);
		
		if(result){
			result = accountdao.addAccount(account);
		}
		
		
		String message=null;
		if(result)
			message="添加结算信息成功";
		else
			message="结算信息无法重复添加！";
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/account/query.html'");
		out.println("</script>");
		out.flush();
		
	}

}
