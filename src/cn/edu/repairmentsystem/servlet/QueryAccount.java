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
				
				date = f.parse(fixtime);//format�ǽ�����ת��Ϊ�ַ���
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
		
		int totalRows=0;//�ܵ�������
		int pageSize=5;//ÿҳ��������
		int pages =0;//��ҳ��
		int currentPage=1;//��ǰҳ
		int startPosition = 0;//ÿҳ����ʼλ��
		
		TablesInfoDao tablesdao = new TablesInfoDao();
		
		totalRows = tablesdao.queryUserTotalRows(tables);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<TablesInfo> result = tablesdao.queryUser(tables,startPosition,pageSize);
		
		//����ѯ�����ݷŵ�request�� ����
		request.setAttribute("data", result);
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//������ת����queryResult.jspչʾ��ѯ���
		RequestDispatcher dis = request.getRequestDispatcher("/account/query_account.jsp");
		dis.forward(request, response);
		
	}

}
