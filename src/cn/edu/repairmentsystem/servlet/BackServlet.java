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

		int totalRows = 0;// 总的数据量
		int pageSize = 10;// 每页数据量
		int pages = 0;// 总页数
		int currentPage = 1;// 当前页
		int startPosition = 0;// 每页起始位置，与当前页相关

		// 生成那些自动生成的信息
		FixnoDao dao = new FixnoDao();
		// boolean result = dao.insertfixno(repno);

		// 生成数据

		// 将查询的数据放入request中共享

		totalRows = dao.querytraTotalRows(0);
		pages = (int) Math.ceil((double) totalRows / (double) pageSize);
		//System.out.println(pages);
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}
		startPosition = (currentPage - 1) * pageSize;
		
		ArrayList<TransferInfo> tra = null;
		tra = dao.querytra(0,startPosition, pageSize);

		// 将分页信息放入共享中
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);

		request.setAttribute("datatransfer", tra);
		RequestDispatcher dis = request
				.getRequestDispatcher("/fix/transferinfo/query.html");
		dis.forward(request, response);
	}
}
