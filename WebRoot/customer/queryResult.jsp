<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cn.edu.repairmentsystem.javabean.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
     <body style="background-color:#d5e2e1">
  	<table align="center" border="1" style="border-collapse:collapse ;width:75%;">
  		<tr>
  			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>客户编号</td>
  			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>联系人</td>
  			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>身份证号</td>
  			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>客户性质</td>
  			<td bgcolor=#C0C0C0 width='12%' height='20' align='center'
				valign='middle'>移动电话</td>
  		</tr>
  		<c:forEach items="${data}" var="u">
   		 <tr>
   		 	<td bgcolor=#F2F2F2 align='center' height='20'>${u.cus_no}</td>
   		 	<td bgcolor=#F2F2F2 align='center' height='20'>${u.cus_contact}</td>
   		 	<td bgcolor=#F2F2F2 align='center' height='20'>${u.cus_id}</td>
   		 	<td bgcolor=#F2F2F2 align='center' height='20'>${u.cus_pro}</td>
			<td bgcolor=#F2F2F2 align='center' height='20'>${u.cus_mobile}</td>
   		 </tr>
   		</c:forEach>
  	</table>
</html>
