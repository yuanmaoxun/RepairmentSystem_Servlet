package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.TablesInfoDao;
import cn.edu.repairmentsystem.javabean.TablesInfo;

public class MessageInAccount extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("no");
		int fixno = Integer.parseInt(no);
		
		TablesInfoDao tablesdao = new TablesInfoDao();
		
		
		TablesInfo result = tablesdao.queryMessage(fixno);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/account/message_account.jsp");
		dis.forward(request, response);
		
	}

}
