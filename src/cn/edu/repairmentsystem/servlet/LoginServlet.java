package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.repairmentsystem.dao.AdminInfoDao;
import cn.edu.repairmentsystem.javabean.AdminInfo;

public class LoginServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		
		AdminInfo u=new AdminInfo();
		u.setAdm_name(name);
		u.setAdm_pwd(pwd);
		
		AdminInfoDao dao=new AdminInfoDao();
		boolean result =dao.login(u);
		String type = dao.selecttype(u);
		//System.out.println(result);
		String url=null;
		if (result)
			{
				url="/main/main.html";
				HttpSession session = request.getSession();
				session.setAttribute("loginInfo", name);
				session.setAttribute("power", type);
			}
		else 
			url="/login.html";
		
		RequestDispatcher dis=request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
