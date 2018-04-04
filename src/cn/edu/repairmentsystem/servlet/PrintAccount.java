package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.AccountInfoDao;
import cn.edu.repairmentsystem.dao.TablesInfoDao;
import cn.edu.repairmentsystem.javabean.AccountInfo;
import cn.edu.repairmentsystem.javabean.TablesInfo;

public class PrintAccount extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("no");
		int fixno = Integer.parseInt(no);
		
		TablesInfoDao tablesdao = new TablesInfoDao();
		TablesInfo result = tablesdao.queryPrint(fixno);
		
		AccountInfoDao accountdao = new AccountInfoDao();
		int res = accountdao.queryAccid();
		
		request.setAttribute("data", result);
		request.setAttribute("result", res);
		
		RequestDispatcher dis = request.getRequestDispatcher("/account/print_account.jsp");
		dis.forward(request, response);
	}

}
