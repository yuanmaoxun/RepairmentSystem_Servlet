<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML>
<HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR>
</HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<script LANGUAGE="JavaScript" TYPE="text/javascript" src="function.js"></script>
<BODY style="background-color:#d5e2e1" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0"><table border="0" width="98%" align="center">
  <tr>
    
  </tr>
</table>
<table style='BORDER-COLLAPSE: collapse'  align=center  width=98% border=0>
</table>
<table style='BORDER-COLLAPSE: collapse' bordercolor=#808080 align=center cellpadding=1 width=98% border=1>
  <tr>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>结算单号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>接机日期</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>维修单号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>维修人员</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>结算费用</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>缴费情况</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>操作</td>
  </tr>
  	
  	<c:forEach items="${data}" var="u">
  		<tr>
  			<td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.acc_no}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.fix_allocatetime}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.fix_no}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.adm_name}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.acc_cal}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.acc_condition}</td>
			<td bgcolor=#F2F2F2 align='center' height='20' valign='middle'><a href="/RepairmentSystem/submitaccount?no=${u.acc_no}" taget="work">提交</a></td>
  		</tr>
  	</c:forEach>
</table>
	<form action="/RepairmentSystem/queryfinance" method="post">
    	<input type="hidden" name="accno" value="${param.accno}"/><!--param 取得是请求参数得值-->
    	<input type="hidden" name="fixallocatetime" value="${param.fixallocatetime}"/>
    	<input type="hidden" name="acccondition" value="${param.acccondition}"/>
    	<input type="hidden" id="page" name="page" value=""/>
    </form>
	<p align ="center">总共${pages}页,当前是${currentPage}页&nbsp;&nbsp;&nbsp;
    	<c:forEach begin="1" end="${pages}" var="p">
    		<a href="javascript:goPage('${p}')">${p}</a>&nbsp;
    	</c:forEach>
    </p>
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