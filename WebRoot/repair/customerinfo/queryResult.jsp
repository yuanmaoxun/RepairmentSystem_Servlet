<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="cn.edu.repairmentsystem.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'queryResult.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta  equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
<body style="background-color:#d5e2e1">
<table border="0" width="98%" align="center">
		<tr>
			<td height='4'></td>
		</tr>
	</table>

	<table border="0" width="98%" align="center">
		<tr>
			<td height='4'></td>
		</tr>
	</table>

	<table style='BORDER-COLLAPSE: collapse' borderColor=#808080
		align=center cellPadding=1 width=98% border=1>
  		<tr bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>
  			<th>客户编号</th>
  			<th>客户姓名</th>
  			<th>身份证</th>
  			<th>客户性质</th>
  			<th>手机号</th>
  			<th>确认</th>
  		</tr>
  		
  		<c:forEach items="${data}" var="c">
  			<tr bgcolor=#F2F2F2 align='center' height='20'>
  				<td>${c.cus_no}</td>
  				<td>${c.cus_contact}</td>
  				<td>${c.cus_id}</td>
  				<td>${c.cus_pro}</td>
  				<td>${c.cus_mobile}</td>
  				<td><a href="/RepairmentSystem/CusnoServlet?cus_no1=${c.cus_no}" target="_parent">确认</a></td>
  			</tr>
  		</c:forEach>
  </table>
  <p align="center">总共${pages}页,当前是${currentPage}页&nbsp;&nbsp;&nbsp;
  	<c:forEach begin="1" end="${pages}" var="p">
  		<a href="javascript:goPage('${p}')">${p}</a>&nbsp;
  	</c:forEach>
  </p>
  <form action="/RepairmentSystem/customerinfo/CustomerServlet" method="post">
  	<!--  param取的是原先参数的值 -->
	  <input  type="hidden" name="cus_contact" value="${param.cus_contact}"/>
  		<input  type="hidden" id="page" name="page" value="" />
  		
</form>
</body>
  <script type="text/javascript">
  	function goPage(p){
  		var page=document.getElementById("page");
  		page.value=p;
  		document.forms[0].submit();
  	}
  </script>
</html>
