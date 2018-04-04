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
		
		int totalRows=0;//�ܵ�������
		int pageSize=5;//ÿҳ��������
		int pages =0;//��ҳ��
		int currentPage=1;//��ǰҳ
		int startPosition = 0;//ÿҳ����ʼλ��
		
		EquipmentInfoDao dao = new EquipmentInfoDao();
		totalRows = dao.queryUserTotalRows(equip);
		pages = (int) Math.ceil(totalRows/(double)pageSize);
		if(page != null ) {
			currentPage = Integer.parseInt(page);
		}
		startPosition = (currentPage-1)*pageSize;
		ArrayList<EquipmentInfo> result = dao.queryUser(equip,startPosition,pageSize);
		
		//����ѯ�����ݷŵ�request�� ����
		request.setAttribute("data", result);
		//����ҳ��Ϣ�ŵ�request����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		
		//������ת����queryResult.jspչʾ��ѯ���
		RequestDispatcher dis = request.getRequestDispatcher("/storage/applystorage.jsp");
		dis.forward(request, response);
	}

}
