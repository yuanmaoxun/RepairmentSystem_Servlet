package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.EquipmentInfoDao;
import cn.edu.repairmentsystem.javabean.EquipmentInfo;

public class FillStorage extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		//System.out.println(equid);
		int equid=Integer.parseInt(id);
		EquipmentInfo equip = new EquipmentInfo();
		equip.setEqu_id(equid);
		
		EquipmentInfoDao equipdao = new EquipmentInfoDao();
		
	  EquipmentInfo result = equipdao.queryStorage(equip);
		
		request.setAttribute("result", result);
		
		RequestDispatcher dis = request.getRequestDispatcher("/storage/updatestorage.jsp");
		dis.forward(request, response);
	}

}
