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
<META http-equiv=Content-Type content="text/html; charset=gb2312">
<META content="MSHTML 5.50.4134.600" name=GENERATOR>
</HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<script LANGUAGE="JavaScript" TYPE="text/javascript" src="function.js"></script>
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" style="background-color:#d5e2e1">
<br>

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
<table style='BORDER-COLLAPSE: collapse'  align=center  width=98% border=0>
</table>
<table style='BORDER-COLLAPSE: collapse' bordercolor=#808080 align=center cellpadding=1 width=98% border=1>
  <tr>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>维修单号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>接机日期</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器类型</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器品牌</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>机器型号</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>产品信息</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>维修人员</td>
    <td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>费用合计</td>
	<td bgcolor=#C0C0C0 width='10%' height='20' align='center' valign='middle'>打印</td>
  </tr>
  	
  	<c:forEach items="${data}" var="u">
  		<tr>
  			<td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.fix_no}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.fix_allocatetime}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.dev_ptype}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.dev_brand}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.dev_model}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'><a href="/RepairmentSystem/messageinaccount?no=${u.fix_no}" target = "work">查看</a></td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.adm_name}</td>
		    <td bgcolor=#F2F2F2 align='center' height='20' valign='middle'>${u.fix_money+u.fix_material}</td>
			<td bgcolor=#F2F2F2 align='center' height='20' valign='middle'><a href="/RepairmentSystem/printaccount?no=${u.fix_no}" target = "work">打印</a></td>
  		</tr>
  	</c:forEach>
</table>
	<form action="/RepairmentSystem/queryaccount" method="post">
    	<input type="hidden" name="fixno" value="${param.fixno}"/><!--param 取得是请求参数得值-->
    	<input type="hidden" name="fixtime" value="${param.fixtime}"/>
    	<input type="hidden" name="fixname" value="${param.fixname}"/>
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