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

import cn.edu.repairmentsystem.dao.FixRecordDao2;
import cn.edu.repairmentsystem.javabean.FixRecord;

public class QueryFix extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fixstaffno = request.getParameter("fixstaffno");
		String fixallocatetime = request.getParameter("fixallocatetime");
		String fixcondition = request.getParameter("fixcondition");
		String page = request.getParameter("page");
		
		FixRecord fix = new FixRecord();
		
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		
		if(!fixallocatetime.equals("")){
			try {
				
				date = f.parse(fixallocatetime);//format是将日期转换为字符串
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		int no = -1;
		if(!fixstaffno.equals("")) {
			no = Integer.parseInt(fixstaffno);
		}
		
		fix.setFix_staffno(no);
		fix.setFix_condition(fixcondition);
		fix.setFix_allocatetime(date);
		
		int totalRows=0;//总的数据量
		int pageSize=5;//每页的数据量
		int pages =0;//总页数
		int currentPage=1;//当前页
		int startPosition = 0;//每页的起始位置
		
		FixRecordDao2 fixrecord2dao = new FixRecordDao2();
		
		totalRows = fixrecord2dao.queryFixTotalRows(fix);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<FixRecord> result = fixrecord2dao.queryFix(fix,startPosition,pageSize);
		
		request.setAttribute("data", result);
		//将分页信息放到request共享
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//将请求转发给queryResult.jsp展示查询结果
		RequestDispatcher dis = request.getRequestDispatcher("/fix/query_fix.jsp");
		dis.forward(request, response);
	}

}
