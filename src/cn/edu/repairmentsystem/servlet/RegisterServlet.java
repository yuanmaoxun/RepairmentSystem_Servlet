package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import cn.edu.repairmentsystem.dao.CustomerInfoDao;
import cn.edu.repairmentsystem.javabean.CustomerInfo;


public class RegisterServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		String cus_no=request.getParameter("cus_no");
		String cus_id=request.getParameter("cus_id");
		String cus_pro=request.getParameter("cus_pro");
		String cus_unit=request.getParameter("cus_unit");
		String cus_mobile=request.getParameter("cus_mobile");
		String cus_phone=request.getParameter("cus_phone");
		String cus_addr=request.getParameter("cus_addr");
		String cus_code=request.getParameter("cus_code");
		String cus_contact=request.getParameter("cus_contact");
		String cus_email=request.getParameter("cus_email");
		
		CustomerInfo u
		=new CustomerInfo(Integer.parseInt(cus_no),cus_id,cus_pro,cus_unit,cus_mobile,cus_phone,cus_addr,cus_code,cus_contact,cus_email);
	
		CustomerInfoDao dao=new CustomerInfoDao();
		
		boolean result=dao.addCustomerInfo(u);
		

		String url=null;
		if (result)
		{
			url="/customer/sign.jsp";
		    request.setAttribute("data", u);
		}
		else
			url="/customer/register.html";
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);	
	
	}

}
