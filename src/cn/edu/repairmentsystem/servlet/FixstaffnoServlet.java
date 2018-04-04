package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.RepInfoDao;
import cn.edu.repairmentsystem.javabean.AdminInfo;
import cn.edu.repairmentsystem.javabean.DeviceInfo;

@SuppressWarnings("serial")
public class FixstaffnoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fix_no = request.getParameter("fix_no");

		int fixno = Integer.parseInt(fix_no);

		// ����ѯ�����ݷ���request�й���
		// request.setAttribute("datar", rep_no);

		RepInfoDao dao = new RepInfoDao();

		DeviceInfo dev = new DeviceInfo();
		dev = dao.queryfix(fixno);
		request.setAttribute("datar", dev.getDev_ptype());
		
		// �����ҳ��ʾ����������
		String page=request.getParameter("page");
		int totalRows = 0;// �ܵ�������
		int pageSize = 10;// ÿҳ������
		int pages = 0;// ��ҳ��
		int currentPage = 1;// ��ǰҳ
		int startPosition = 0;// ÿҳ��ʼλ�ã��뵱ǰҳ���

		totalRows = dao.queryfixTotalRows();
		pages = (int) Math.ceil((double) totalRows / (double) pageSize);
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}
		startPosition = (currentPage - 1) * pageSize;

		ArrayList<AdminInfo> result = dao.queryfix( startPosition,
				pageSize);
		// ����ѯ�����ݷ���request�й���
		request.setAttribute("datafix", result);

		// ����ҳ��Ϣ���빲����
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);

		// ������ת����queryresult.jspչʾ��ѯ���
		RequestDispatcher dis = request
				.getRequestDispatcher("/fix/transferinfo/transfer.jsp");
		dis.forward(request, response);
	}

}
