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

public class QueryStorage extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String equname = request.getParameter("equname");
		String equmodel = request.getParameter("equmodel");
		String equcondition = request.getParameter("equcondition");
		String page = request.getParameter("page");
		
		EquipmentInfo equip = new EquipmentInfo();
		
		equip.setEqu_name(equname);
		equip.setEqu_model(equmodel);
		equip.setEqu_condition(equcondition);
		
		int totalRows=0;//总的数据量
		int pageSize=5;//每页的数据量
		int pages =0;//总页数
		int currentPage=1;//当前页
		int startPosition = 0;//每页的起始位置
		
		EquipmentInfoDao dao = new EquipmentInfoDao();
		totalRows = dao.queryUserTotalRows(equip);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<EquipmentInfo> result = dao.queryUser(equip,startPosition,pageSize);
		
		//将查询的数据放到request中 共享
		request.setAttribute("data", result);
		//将分页信息放到request共享
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//将请求转发给queryResult.jsp展示查询结果
		RequestDispatcher dis = request.getRequestDispatcher("/storage/applystorage.jsp");
		dis.forward(request, response);
	}

}
