package cn.edu.repairmentsystem.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.repairmentsystem.dao.EquipmentInfoDao;
import cn.edu.repairmentsystem.dao.SpareInfoDao;
import cn.edu.repairmentsystem.javabean.SpareInfo;

public class AddSpareInfo extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fixno = request.getParameter("fix_no");
		String equid = request.getParameter("equ_id");
		String sparenum = request.getParameter("spa_num");
		
		int fix_no = Integer.parseInt(fixno);
		int equ_id = Integer.parseInt(equid);
		int spare_num = Integer.parseInt(sparenum);
		
		SpareInfo spare = new SpareInfo();
		
		spare.setEqu_id(equ_id);
		spare.setFix_no(fix_no);
		spare.setSpa_num(spare_num);
		
		SpareInfoDao sparedao = new SpareInfoDao();
		boolean result = sparedao.addSpareInfo(spare);
		EquipmentInfoDao equipdao = new EquipmentInfoDao();
		equipdao.updateEqunum(-spare_num, equ_id);
		
		String message = null;
		if(result) {
			message = "备件出库信息添加成功！";
		}
		else {
			message = "备件出库信息添加失败！";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('"+message+"'); window.location.href='/RepairmentSystem/fix/query.html'");
		out.println("</script>");
		out.flush();
	}

}
