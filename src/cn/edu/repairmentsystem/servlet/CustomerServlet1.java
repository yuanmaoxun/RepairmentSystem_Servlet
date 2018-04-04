package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.CustomerInfoDao;
import cn.edu.repairmentsystem.javabean.CustomerInfo;

public class CustomerServlet1 extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

				String cus_id =request.getParameter("cus_id");
			
				CustomerInfo cus=new CustomerInfo();
				
				cus.setCus_id(cus_id);
		

				CustomerInfoDao dao=new CustomerInfoDao();
		
				ArrayList<CustomerInfo> result =dao.queryUser(cus);

				request.setAttribute("data", result);


				RequestDispatcher dis=request.getRequestDispatcher("/customer/queryResult.jsp");
				dis.forward(request,response);

		
	}

}
