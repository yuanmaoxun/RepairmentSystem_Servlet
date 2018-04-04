package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.EquipmentInfoDao;
import cn.edu.repairmentsystem.dao.TablesInfoDao;
import cn.edu.repairmentsystem.javabean.TablesInfo;

public class QueryAccount extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		String fixno = request.getParameter("fixno");
		String admname = request.getParameter("fixname");
		String fixtime = request.getParameter("fixtime");
		String page = request.getParameter("page");
		
		TablesInfo tables = new TablesInfo();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		if(!fixtime.equals("")){
			try {
				
				date = f.parse(fixtime);//format是将日期转换为字符串
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		
		int no = -1;
		if(!fixno.equals("")) {
			no = Integer.parseInt(fixno);
		}
		
		tables.setFix_no(no);
		tables.setAdm_name(admname);
		tables.setFix_allocatetime(date);
		
		int totalRows=0;//总的数据量
		int pageSize=5;//每页的数据量
		int pages =0;//总页数
		int currentPage=1;//当前页
		int startPosition = 0;//每页的起始位置
		
		TablesInfoDao tablesdao = new TablesInfoDao();
		
		totalRows = tablesdao.queryUserTotalRows(tables);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<TablesInfo> result = tablesdao.queryUser(tables,startPosition,pageSize);
		
		//将查询的数据放到request中 共享
		request.setAttribute("data", result);
		//将分页信息放到request共享
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//将请求转发给queryResult.jsp展示查询结果
		RequestDispatcher dis = request.getRequestDispatcher("/account/query_account.jsp");
		dis.forward(request, response);
		
	}

}
