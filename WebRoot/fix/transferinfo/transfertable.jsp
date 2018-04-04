<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="cn.edu.repairmentsystem.javabean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>queryCondition.jsp</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
  </head>
  <body style="background-color:#d5e2e1">
    	<table align="center">
    		<tr>
    			<td align="center" style="font-size: 18px; font-weight: bold;">维修分配表</td>
    		</tr>	
    	</table>

	<table border="0" width="49%" align="center">
		<tr>
			<td height='4'></td>
		</tr>
	</table>

	<table border="0" width="49%" align="center">
		<tr>
			<td height='4'></td>
		</tr>
	</table>
	<table style='BORDER-COLLAPSE: collapse' borderColor=#808080
		align=center cellPadding=1 width=98% border=1>
		<TR>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>接机日期</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>维修单号</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>产品类型</td>
            <td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>机器品牌</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>机器型号</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>分配对象</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>维修状态</td>
		</TR>
		<c:forEach items="${datatransfer}" var="f">
			<tr>
				<td bgcolor=#F2F2F2 align='center' height='20'>${f.fix_allocatetime}</td>
				<td bgcolor=#F2F2F2 align='center' height='20'>${f.fix_no}</td>
				<td bgcolor=#F2F2F2 align='center' height='20'>${f.dev_ptype}</td>
                <td bgcolor=#F2F2F2 align='center' height='20'>${f.dev_brand}</td>
                <td bgcolor=#F2F2F2 align='center' height='20'>${f.dev_model}</td>
                <td bgcolor=#F2F2F2 align='center' height='20'><a 
    	 			href="/RepairmentSystem/FixstaffnoServlet?fix_no=${f.fix_no}"
					target="_parent"> 分配人员</a></td>
				<td bgcolor=#F2F2F2 align='center' height='20'>${f.fix_condition}</td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		总共${pages}页,当前是${currentPage}页&nbsp;&nbsp;&nbsp;
		<c:forEach begin="1" end="${pages}" var="p">
			<a href="javascript:goPage('${p}')">${p}</a>&nbsp;
  	</c:forEach>
	</p>
	<form action="/RepairmentSystem/FixnoServlet"
		method="post">
		<!--  param取的是原先参数的值 -->
		<input type="hidden" name="query_fixno" value="${param.query_fixno}" />
		<input type="hidden" id="page" name="page" value="" />

	</form>
</body>
<script type="text/javascript">
	function goPage(p) {
		var page = document.getElementById("page");
		page.value = p;
		document.forms[0].submit();
	}
</script>
</html>

