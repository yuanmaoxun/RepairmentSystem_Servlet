package cn.edu.repairmentsystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.DeviceInfoDao;
import cn.edu.repairmentsystem.javabean.CustomerInfo;
import cn.edu.repairmentsystem.javabean.DeviceInfo;

@SuppressWarnings("serial")
public class DeviceInfoServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取查询数据
		String dev_seriesque=request.getParameter("dev_seriesque");
		
		String cus_no=request.getParameter("cus_no");
		CustomerInfo info=new CustomerInfo();
		info.setCus_no(Integer.parseInt(cus_no));
		request.setAttribute("data2", info);
		
		
		if(!dev_seriesque.equals("")){
			DeviceInfo dev=new DeviceInfo();
			dev.setDev_series(dev_seriesque);
			
			//创建DAO方法完成查询逻辑
			DeviceInfoDao dao=new DeviceInfoDao();
			
			DeviceInfo result=dao.querydev(dev);
			
			//如果找到了序列号
			if(result.getDev_series()!=null){
				//将查询的数据放入request中共享
				request.setAttribute("data1", result);

				//将请求转发给queryresult.jsp展示查询结果
				RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairadd.jsp");
				dis.forward(request,response);
			}
			else{
				//未找到信息提示
				String str="未找到";
				request.setAttribute("data3", str);
				
				RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairadd.jsp");
				dis.forward(request,response);
			}
		}
		else{
			RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairadd.jsp");
			dis.forward(request,response);
		}
	}
}
