<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="cn.edu.repairmentsystem.javabean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<HTML><HEAD>
<base href="<%=basePath%>">
<TITLE></TITLE>

    <title>My JSP 'repairadd.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<META http-equiv=Content-Language content=zh-cn>
	<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
	<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" style="background-color:#d5e2e1">
<br>


<TABLE width="98%" border=0 align="center">
    <TR>
     <TD width="100%">
	
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>产品信息</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
        <TR>
        	<TD width="15%" height=13 align="left" colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机器信息：</TD>
        </TR>
		<TR>
			<TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>产品类型：</TD>
			<TD width="15%" height=13 >
            	<b>${result.dev_ptype}</b>
            </TD>
			<TD width="15%" height=13 align="right">机器品牌：</TD>
			<TD width="15%" height=13>
            	<b>${result.dev_brand}</b>
            </TD>
            <TD width="15%" height=13 align="right">机器型号：</TD>
			<TD width="15%" height=13 >
            	<b>${result.dev_model}</b>
            </TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>序列号：</TD>
			<TD width="15%" height=13 ><b>${result.dev_series}</b></TD>
            <TD width="15%" height=13 align="right">开机口令：</TD>
			<TD width="15%" height=13 colspan="3"><b>${result.dev_command}</b>
            </TD>
		</TR>
        <TR>
			<TD width="15%" height=13 align="right">HDD：</TD>
			<TD width="15%" height=13 ><b>${result.dev_hdd}</b></TD>
			<TD width="15%" height=13 align="right">内存：</TD>
			<TD width="15%" height=13 colspan="3"><b>${result.dev_rom}</b></TD>
		</TR>
        <TR>
			<TD width="15%" height=13 align="right">外置PC卡：</TD>
			<TD width="15%" height=13 ><b>${result.dev_pc}</b></TD>
			<TD width="15%" height=13 align="right">AC适配器：</TD>
			<TD width="15%" height=13 colspan="3"><b>${result.dev_adapt}</b></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">电池：</TD>
			<TD width="15%" height=13 ><b>${result.dev_battery}</b></TD>
			<TD width="15%" height=13 align="right">外接光驱：</TD>
			<TD width="15%" height=13 colspan="3"><b>${result.dev_drive}</b></TD>
		</TR>
		<TR>
			<TD height=13 colspan="6"  align="center"><button onClick="window.history.back()">&nbsp;&nbsp;确定&nbsp;&nbsp;</button></TD>
		</TR>  
  	</TABLE>

	</TD></TR></TABLE>
</body>
</html>
