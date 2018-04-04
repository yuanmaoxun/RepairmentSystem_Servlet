<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
<HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<script LANGUAGE="JavaScript" TYPE="text/javascript" src="function.js"></script>
<TITLE></TITLE>
</HEAD>

<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" style="background-color:#d5e2e1">
<table style='BORDER-COLLAPSE: collapse' borderColor=#808080 align=center cellPadding=1 width=98% border=1>
  <TR>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>备件id</td>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>备件名称</td>
    <td bgcolor=#C0C0C0 width='16%' height='20' align='center' valign='middle'>型号</td>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>单价</td>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>数量</td>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>警戒数量</td>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>库存状态</td>
    <td bgcolor=#C0C0C0 width='12%' height='20' align='center' valign='middle'>操作</td>
  </TR>
	<c:forEach items="${data}" var="u"><!--data为共享的数据 u相当于data中的javabean对象 -->
    		<tr>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_id}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_name}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_model}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_cost}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_num}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_alternum}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'>${u.equ_condition}</td>
    	 		<td bgcolor=#F2F2F2 align='center' height='20'><a href ="/RepairmentSystem/fillstorage?id=${u.equ_id}" target = "work"> 修改 </a></td>
    	 	</tr>
    	</c:forEach>
</table>
	<p align ="center">总共${pages}页,当前是${currentPage}页&nbsp;&nbsp;&nbsp;
    	<c:forEach begin="1" end="${pages}" var="p">
    		<a href="javascript:goPage('${p}')">${p}</a>&nbsp;
    	</c:forEach>
    </p>
    <form action="/RepairmentSystem/querystorage" method="post">
    	<input type="hidden" name="equname" value="${param.equname}"/><!--param 取得是请求参数得值-->
    	<input type="hidden" name="equmodel" value="${param.equmodel}"/>
    	<input type="hidden" name="equcondition" value="${param.equcondition}"/>
    	<input type="hidden" id="page" name="page" value=""/>
    </form>
<br>

</body>
</html>
<script type="text/javascript">
	function goPage(p) {
		var page = document.getElementById("page");
		page.value = p;
		document.forms[0].submit();
	}
</script>
</script>
