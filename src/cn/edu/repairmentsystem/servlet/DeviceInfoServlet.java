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
		//��ȡ��ѯ����
		String dev_seriesque=request.getParameter("dev_seriesque");
		
		String cus_no=request.getParameter("cus_no");
		CustomerInfo info=new CustomerInfo();
		info.setCus_no(Integer.parseInt(cus_no));
		request.setAttribute("data2", info);
		
		
		if(!dev_seriesque.equals("")){
			DeviceInfo dev=new DeviceInfo();
			dev.setDev_series(dev_seriesque);
			
			//����DAO������ɲ�ѯ�߼�
			DeviceInfoDao dao=new DeviceInfoDao();
			
			DeviceInfo result=dao.querydev(dev);
			
			//����ҵ������к�
			if(result.getDev_series()!=null){
				//����ѯ�����ݷ���request�й���
				request.setAttribute("data1", result);

				//������ת����queryresult.jspչʾ��ѯ���
				RequestDispatcher dis=request.getRequestDispatcher("/repair/repairinfo/repairadd.jsp");
				dis.forward(request,response);
			}
			else{
				//δ�ҵ���Ϣ��ʾ
				String str="δ�ҵ�";
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
