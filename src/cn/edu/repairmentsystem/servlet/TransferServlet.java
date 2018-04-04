package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.FixAllocationDao;

@SuppressWarnings("serial")
public class TransferServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fix_no = request.getParameter("fix_no");
		String adm_no = request.getParameter("adm_no");
		//String adm_no = request.getParameter("adm_no");
		
		int fixno=Integer.parseInt(fix_no);
		int admno=Integer.parseInt(adm_no);
		
		FixAllocationDao dao=new FixAllocationDao();
		
		boolean result=dao.updatefixallocate(fixno,admno);
		
		String message=null;
		if(result){
			message="����ɹ���";
		}
		else{
			message="����ʧ�ܣ�";
		}
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('"+"ά�޵���"+fixno+message+"');window.location.href='/RepairmentSystem/BackServlet'");
		out.println("</script>");
	}

}
