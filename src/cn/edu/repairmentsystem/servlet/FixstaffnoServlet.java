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

		// 将查询的数据放入request中共享
		// request.setAttribute("datar", rep_no);

		RepInfoDao dao = new RepInfoDao();

		DeviceInfo dev = new DeviceInfo();
		dev = dao.queryfix(fixno);
		request.setAttribute("datar", dev.getDev_ptype());
		
		// 定义分页显示的所以数据
		String page=request.getParameter("page");
		int totalRows = 0;// 总的数据量
		int pageSize = 10;// 每页数据量
		int pages = 0;// 总页数
		int currentPage = 1;// 当前页
		int startPosition = 0;// 每页起始位置，与当前页相关

		totalRows = dao.queryfixTotalRows();
		pages = (int) Math.ceil((double) totalRows / (double) pageSize);
		if (page != null) {
			currentPage = Integer.parseInt(page);

		}
		startPosition = (currentPage - 1) * pageSize;

		ArrayList<AdminInfo> result = dao.queryfix( startPosition,
				pageSize);
		// 将查询的数据放入request中共享
		request.setAttribute("datafix", result);

		// 将分页信息放入共享中
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);

		// 将请求转发给queryresult.jsp展示查询结果
		RequestDispatcher dis = request
				.getRequestDispatcher("/fix/transferinfo/transfer.jsp");
		dis.forward(request, response);
	}

}
