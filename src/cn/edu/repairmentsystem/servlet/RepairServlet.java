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
		//获取查询数据
		String rep_no=request.getParameter("rep_no");
		String page=request.getParameter("page");
		//System.out.println(cus_contact);
		
		RepairInfo rep=new RepairInfo();
		if(!rep_no.equals(""))
			rep.setRep_no(Integer.parseInt(rep_no));
		else rep.setRep_no(-1);
		
		//定义分页显示的所以数据
		int totalRows=0;//总的数据量
		int pageSize=10;//每页数据量
		int pages=0;//总页数
		int currentPage=1;//当前页
		int startPosition=0;//每页起始位置，与当前页相关
		
		//创建DAO方法完成查询逻辑
		RepairInfoDao dao=new RepairInfoDao();
		totalRows=dao.queryrepTotalRows(rep);
		pages=(int)Math.ceil((double)totalRows/(double)pageSize);
		if(page!=null){
			currentPage=Integer.parseInt(page);
			
		}
		startPosition=(currentPage-1)*pageSize;
		
		ArrayList<RepairInfo> result=dao.queryrep(rep,startPosition,pageSize);
		//将查询的数据放入request中共享
		request.setAttribute("dataf", result);
		
		//  将分页信息放入共享中
		request.setAttribute("pages", pages);
		request.setAttribute("currentPage", currentPage);
		//将请求转发给queryresult.jsp展示查询结果
		RequestDispatcher dis=request.getRequestDispatcher("/fix/fixinfo/queryResult.jsp");
		dis.forward(request,response);
	}

}
