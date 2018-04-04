package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.RepairInfoDao;
import cn.edu.repairmentsystem.javabean.RepairInfo;

@SuppressWarnings("serial")
public class RepairServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��ȡ��ѯ����
		String rep_no=request.getParameter("rep_no");
		String page=request.getParameter("page");
		//System.out.println(cus_contact);
		
		RepairInfo rep=new RepairInfo();
		if(!rep_no.equals(""))
			rep.setRep_no(Integer.parseInt(rep_no));
		else rep.setRep_no(-1);
		
		//�����ҳ��ʾ����������
		int totalRows=0;//�ܵ�������
		int pageSize=10;//ÿҳ������
		int pages=0;//��ҳ��
		int currentPage=1;//��ǰҳ
		int startPosition=0;//ÿҳ��ʼλ�ã��뵱ǰҳ���
		
		//����DAO������ɲ�ѯ�߼�
		RepairInfoDao dao=new RepairInfoDao();
		totalRows=dao.queryrepTotalRows(rep);
		pages=(int)Math.ceil((double)totalRows/(double)pageSize);
		if(page!=null){
			currentPage=Integer.parseInt(page);
			
		}
		startPosition=(currentPage-1)*pageSize;
		
		ArrayList<RepairInfo> result=dao.queryrep(rep,startPosition,pageSize);
		//����ѯ�����ݷ���request�й���
		request.setAttribute("dataf", result);
		
		//  ����ҳ��Ϣ���빲����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		//������ת����queryresult.jspչʾ��ѯ���
		RequestDispatcher dis=request.getRequestDispatcher("/fix/fixinfo/queryResult.jsp");
		dis.forward(request,response);
	}

}
