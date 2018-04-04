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
				
				date = f.parse(fixallocatetime);//format�ǽ�����ת��Ϊ�ַ���
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
		
		int totalRows=0;//�ܵ�������
		int pageSize=5;//ÿҳ��������
		int pages =0;//��ҳ��
		int currentPage=1;//��ǰҳ
		int startPosition = 0;//ÿҳ����ʼλ��
		
		FixRecordDao2 fixrecord2dao = new FixRecordDao2();
		
		totalRows = fixrecord2dao.queryFixTotalRows(fix);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<FixRecord> result = fixrecord2dao.queryFix(fix,startPosition,pageSize);
		
		request.setAttribute("data", result);
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//������ת����queryResult.jspչʾ��ѯ���
		RequestDispatcher dis = request.getRequestDispatcher("/fix/query_fix.jsp");
		dis.forward(request, response);
	}

}
