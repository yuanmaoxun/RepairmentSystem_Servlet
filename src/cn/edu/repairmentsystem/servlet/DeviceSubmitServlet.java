package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.DeviceInfoDao;
import cn.edu.repairmentsystem.dao.FixnoDao;
import cn.edu.repairmentsystem.javabean.DeviceInfo;
import cn.edu.repairmentsystem.javabean.RepairInfo;

@SuppressWarnings("serial")
public class DeviceSubmitServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String message=null;
		
		//获取设备数据
		String dev_id=request.getParameter("dev_id");
		String dev_ptype=request.getParameter("dev_ptype");
		String dev_brand=request.getParameter("dev_brand");
		String dev_model=request.getParameter("dev_model");
		String dev_series=request.getParameter("dev_series");
		String dev_command=request.getParameter("dev_command");
		String dev_hdd=request.getParameter("dev_hdd");
		String dev_rom=request.getParameter("dev_rom");
		String dev_pc=request.getParameter("dev_pc");
		String dev_adapt=request.getParameter("dev_adapt");
		String dev_battery=request.getParameter("dev_battery");
		String dev_drive=request.getParameter("dev_drive");
		
		//获取repair的数据
		//String rep_no=request.getParameter("rep_no");
		//String rep_start=request.getParameter("rep_start");
		String rep_estimate=request.getParameter("rep_estimate");
		String rep_end=request.getParameter("rep_end");
		String rep_condition=request.getParameter("rep_condition");
		String rep_spare=request.getParameter("rep_spare");
		String rep_app=request.getParameter("rep_app");
		String rep_fault=request.getParameter("rep_fault");
		String cus_no=request.getParameter("cus_no");
		String rep_check=request.getParameter("rep_check");
		String rep_others=request.getParameter("rep_others");
		String rep_data=request.getParameter("rep_data");
		
		SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
		
		Date d_rep_end=null;
		Date d_rep_start=null;
		try {
			d_rep_end=f.parse(rep_end);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(cus_no.equals("")){
			
		}
		if(dev_id.equals("")){
			DeviceInfo dev=new DeviceInfo(0,dev_ptype,dev_brand,dev_model,dev_series,dev_command,dev_hdd,dev_rom,dev_pc,dev_adapt,dev_battery,dev_drive);
			
			//System.out.println("sos");
			//创建DAO方法完成查询逻辑
			DeviceInfoDao dao=new DeviceInfoDao();
			
			boolean result1=dao.insertdev(dev);
			
			DeviceInfo devid=dao.querydevid(dev);
			
			RepairInfo rep=new RepairInfo(0,d_rep_start,Double.parseDouble(rep_estimate),d_rep_end,rep_condition,rep_spare,rep_app,rep_fault,Integer.parseInt(cus_no),devid.getDev_id(),rep_check,rep_others,rep_data);			

			boolean result2=dao.insertrep(rep);
			
			//System.out.println("result1"+result1);
			//System.out.println("result2"+result2);
			
			RepairInfo r=new RepairInfo();
			r=dao.queryrepno();
			
			//int r=Integer.parseInt(rr.getRep_no());
			
			//生成fixno和。。。

			// 生成那些自动生成的信息
			FixnoDao dao1 = new FixnoDao();
			@SuppressWarnings("unused")
			boolean result = dao1.insertfixno(r.getRep_no());
			
			//结束生成fixno和。。。
			
			request.setAttribute("data4", r);
			
			if(result1&&result2){
				message="保存成功！";
				RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairconfirm.jsp");
				dis.forward(request,response);
			}
			else{
				message="保存失败！";
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('"+message+"');window.location.href='/RepairmentSystem/repair/repairinfo/repairadd.jsp';");
				out.println("</script>");
			}
		}
		else{
			RepairInfo rep=new RepairInfo(0,d_rep_start,Double.parseDouble(rep_estimate),d_rep_end,rep_condition,rep_spare,rep_app,rep_fault,Integer.parseInt(cus_no),Integer.parseInt(dev_id),rep_check,rep_others,rep_data);
			
			//创建DAO方法完成查询逻辑
			DeviceInfoDao dao=new DeviceInfoDao();
			
			boolean result3=dao.insertrep(rep);
			
			//RepairInfo r=new RepairInfo();
			//r=dao.queryrepno();
			
			
			//System.out.println("result3"+result3);
			//RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairadd.jsp");
			//dis.forward(request,response);
			
			RepairInfo r1=new RepairInfo();
			r1=dao.queryrepno();
			
			FixnoDao dao1 = new FixnoDao();
			@SuppressWarnings("unused")
			boolean result1 = dao1.insertfixno(r1.getRep_no());
			
			request.setAttribute("data4", r1);
			
			if(result3){
				message="保存成功！";
				RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairconfirm.jsp");
				dis.forward(request,response);
			}
			else{
				message="保存失败！";
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('"+message+"');window.location.href='/RepairmentSystem/repair/repairinfo/repairadd.jsp';");
				out.println("</script>");
			}
		}
	}
}
