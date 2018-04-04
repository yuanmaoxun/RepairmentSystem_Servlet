package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.FixnoDao;
import cn.edu.repairmentsystem.javabean.TransferInfo;

@SuppressWarnings("serial")
public class FixnoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��ȡ��ѯ����
		String fix_no = request.getParameter("query_fixno");
		String page = request.getParameter("page");
		
		//System.out.println(fix_no);
		int fixno1=-1;
		if(!fix_no.equals("")){
			fixno1 = Integer.parseInt(fix_no);
		}
		
		int totalRows = 0;// �ܵ�������
		int pageSize = 10;// ÿҳ������
		int pages = 0;// ��ҳ��
		int currentPage = 1;// ��ǰҳ
		int startPosition = 0;// ÿҳ��ʼλ�ã��뵱ǰҳ���

		// ������Щ�Զ����ɵ���Ϣ
		FixnoDao dao = new FixnoDao();
		// boolean result = dao.insertfixno(repno);

		
		// ����ѯ�����ݷ���request�й���

		totalRows = dao.querytraTotalRows(fixno1);
		pages = (int) Math.ceil(totalRows / (double) pageSize);
		//System.out.println(pages);
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}
		startPosition = (currentPage - 1) * pageSize;
		
		// ��������
		ArrayList<TransferInfo> tra = null;
		tra = dao.querytra(fixno1,startPosition, pageSize);

		//System.out.println(totalRows);
		// ����ҳ��Ϣ���빲����
		request.setAttribute("datatransfer", tra);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);


		RequestDispatcher dis = request
				.getRequestDispatcher("/fix/transferinfo/transfertable.jsp");
		dis.forward(request, response);
	}
}
