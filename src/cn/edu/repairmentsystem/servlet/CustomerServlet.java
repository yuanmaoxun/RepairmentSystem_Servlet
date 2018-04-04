package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.CustomerInfoDao;
import cn.edu.repairmentsystem.javabean.CustomerInfo;


@SuppressWarnings("serial")
public class CustomerServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��ѯ����
		String cus_contact=request.getParameter("cus_contact");
		String page=request.getParameter("page");
		//System.out.println(cus_contact);
		
		CustomerInfo cus=new CustomerInfo();
		cus.setCus_contact(cus_contact);
		
		//�����ҳ��ʾ����������
		int totalRows=0;//�ܵ�������
		int pageSize=10;//ÿҳ������
		int pages=0;//��ҳ��
		int currentPage=1;//��ǰҳ
		int startPosition=0;//ÿҳ��ʼλ�ã��뵱ǰҳ���
		
		//����DAO������ɲ�ѯ�߼�
		CustomerInfoDao dao=new CustomerInfoDao();
		totalRows=dao.querycusTotalRows(cus);
		pages=(int)Math.ceil((double)totalRows/(double)pageSize);
		if(page!=null){
			currentPage=Integer.parseInt(page);
			
		}
		startPosition=(currentPage-1)*pageSize;
		
		ArrayList<CustomerInfo> result=dao.querycus(cus,startPosition,pageSize);
		//����ѯ�����ݷ���request�й���
		request.setAttribute("data", result);
		
		//  ����ҳ��Ϣ���빲����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		//������ת����queryresult.jspչʾ��ѯ���
		RequestDispatcher dis=request.getRequestDispatcher("/repair/customerinfo/queryResult.jsp");
		dis.forward(request,response);
	}

}
