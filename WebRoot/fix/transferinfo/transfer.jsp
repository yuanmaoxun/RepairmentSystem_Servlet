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

    	<br><table align="center">
    		<tr>
    			<td align="center" style="font-size: 18px; font-weight: bold;">维修人员表</td>
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
				valign='middle'>维修人员工号</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>员工姓名</td>
			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>操作</td>
		</TR>
		<c:forEach items="${datafix}" var="f">
			<tr>
				<td bgcolor=#F2F2F2 align='center' height='20'>${f.adm_no}</td>
				<td bgcolor=#F2F2F2 align='center' height='20'>${f.adm_name}</td>
				<td bgcolor=#F2F2F2 align='center' height='20'><a
					href="/RepairmentSystem/TransferServlet?fix_no=${param.fix_no}&adm_no=${f.adm_no}"
					>分配</a></td>
			</tr>
		</c:forEach>
	</table>
	<p align="center">
		总共${pages}页,当前是${currentPage}页&nbsp;&nbsp;&nbsp;
		<c:forEach begin="1" end="${pages}" var="p">
			<a href="javascript:goPage('${p}')">${p}</a>&nbsp;
  	</c:forEach>
	</p>
	<form action="/RepairmentSystem/FixstaffnoServlet"
		method="get">
		<!--  param取的是原先参数的值 -->
		<input type="hidden" id="fix_no" name="fix_no" value="${param.fix_no}" />
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

