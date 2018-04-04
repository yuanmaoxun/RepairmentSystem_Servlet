package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.FixRecordDao2;
import cn.edu.repairmentsystem.javabean.FixRecord;

public class MessageInFix extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String no = request.getParameter("no");
		int fixno = Integer.parseInt(no);
		
		FixRecordDao2 fixdao = new FixRecordDao2();
		
		
		FixRecord result = fixdao.queryMessage(fixno);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/fix/fixtable.jsp");
		dis.forward(request, response);
	}

}
