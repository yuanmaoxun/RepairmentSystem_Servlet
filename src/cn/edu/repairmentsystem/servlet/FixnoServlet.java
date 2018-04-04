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
		// 获取查询数据
		String fix_no = request.getParameter("query_fixno");
		String page = request.getParameter("page");
		
		//System.out.println(fix_no);
		int fixno1=-1;
		if(!fix_no.equals("")){
			fixno1 = Integer.parseInt(fix_no);
		}
		
		int totalRows = 0;// 总的数据量
		int pageSize = 10;// 每页数据量
		int pages = 0;// 总页数
		int currentPage = 1;// 当前页
		int startPosition = 0;// 每页起始位置，与当前页相关

		// 生成那些自动生成的信息
		FixnoDao dao = new FixnoDao();
		// boolean result = dao.insertfixno(repno);

		
		// 将查询的数据放入request中共享

		totalRows = dao.querytraTotalRows(fixno1);
		pages = (int) Math.ceil(totalRows / (double) pageSize);
		//System.out.println(pages);
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}
		startPosition = (currentPage - 1) * pageSize;
		
		// 生成数据
		ArrayList<TransferInfo> tra = null;
		tra = dao.querytra(fixno1,startPosition, pageSize);

		//System.out.println(totalRows);
		// 将分页信息放入共享中
		request.setAttribute("datatransfer", tra);
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);


		RequestDispatcher dis = request
				.getRequestDispatcher("/fix/transferinfo/transfertable.jsp");
		dis.forward(request, response);
	}
}
