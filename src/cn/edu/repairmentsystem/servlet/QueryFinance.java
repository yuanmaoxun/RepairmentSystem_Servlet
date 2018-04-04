package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.TablesInfoDao;
import cn.edu.repairmentsystem.javabean.TablesInfo;

public class QueryFinance extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String accno = request.getParameter("accno");
		String fixallocatetime = request.getParameter("fixallocatetime");
		String acccondition = request.getParameter("acccondition");
		String page = request.getParameter("page");
		
		TablesInfo tables = new TablesInfo();
		
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
		if(!accno.equals("")) {
			no = Integer.parseInt(accno);
		}
		
		tables.setAcc_no(no);
		tables.setAcc_condition(acccondition);
		tables.setFix_allocatetime(date);
		
		int totalRows=0;//�ܵ�������
		int pageSize=5;//ÿҳ��������
		int pages =0;//��ҳ��
		int currentPage=1;//��ǰҳ
		int startPosition = 0;//ÿҳ����ʼλ��
		
		TablesInfoDao tablesdao = new TablesInfoDao();
		
		totalRows = tablesdao.queryAccountTotalRows(tables);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<TablesInfo> result = tablesdao.queryAccount(tables,startPosition,pageSize);
		
		request.setAttribute("data", result);
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//������ת����queryResult.jspչʾ��ѯ���
		RequestDispatcher dis = request.getRequestDispatcher("/account/query1_account.jsp");
		dis.forward(request, response);
	}

}
