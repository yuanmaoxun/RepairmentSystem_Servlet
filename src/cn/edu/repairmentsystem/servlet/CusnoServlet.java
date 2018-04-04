package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cn.edu.repairmentsystem.javabean.CustomerInfo;

@SuppressWarnings("serial")
public class CusnoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cus_no=request.getParameter("cus_no1");
		
		//int cusno=Integer.parseInt(cus_no);
		
		CustomerInfo cus=new CustomerInfo();
		
		cus.setCus_no(Integer.parseInt(cus_no));
		
		//将查询的数据放入request中共享
		request.setAttribute("data2", cus);

		//将请求转发给queryresult.jsp展示查询结果
		RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairadd.jsp");
		dis.forward(request,response);
	}

}
