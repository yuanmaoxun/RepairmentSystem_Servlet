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
public class BackServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");

		int totalRows = 0;// �ܵ�������
		int pageSize = 10;// ÿҳ������
		int pages = 0;// ��ҳ��
		int currentPage = 1;// ��ǰҳ
		int startPosition = 0;// ÿҳ��ʼλ�ã��뵱ǰҳ���

		// ������Щ�Զ����ɵ���Ϣ
		FixnoDao dao = new FixnoDao();
		// boolean result = dao.insertfixno(repno);

		// ��������

		// ����ѯ�����ݷ���request�й���

		totalRows = dao.querytraTotalRows(0);
		pages = (int) Math.ceil((double) totalRows / (double) pageSize);
		//System.out.println(pages);
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}
		startPosition = (currentPage - 1) * pageSize;
		
		ArrayList<TransferInfo> tra = null;
		tra = dao.querytra(0,startPosition, pageSize);

		// ����ҳ��Ϣ���빲����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);

		request.setAttribute("datatransfer", tra);
		RequestDispatcher dis = request
				.getRequestDispatcher("/fix/transferinfo/query.html");
		dis.forward(request, response);
	}
}
