<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="cn.edu.repairmentsystem.javabean.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<HTML><HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY style="background-color:#d5e2e1" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>
<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>

<TABLE width="98%" border=0 align="center">
   <TR>
     <TD width="100%" align="right"><FONT color=#493eb5>注:标有</FONT><FONT color=#FF0000> * </FONT><FONT color=#493eb5>的项必填&nbsp;</FONT></TD>
   </TR>
    <TR>
     <TD width="100%">
	<FORM action="/Repairment/addspareinfo" method="post">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<th>
					<td align="center"><b>备件流水表</b></font></td>
				</th>
			</table>
			</td>
		  </tr>
          	<TR>
               <TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>维修单号：</TD>
               <TD width="35%" height=13 colspan="3">
					${param.fix_no}<input type = "hidden" name = "fix_no" value="${param.fix_no}" size = "30" maxlength="50"/>
			   </TD>
              </TR>
             <TR>
               <TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>备件ID：</TD>
               <TD width="35%" height=13>
					<input type = "text" name = "equ_id" value="" size = "30" maxlength="50"/>
			   </TD>
			   <TD width="15%" height=13 align="right">数量：</TD>
			   <TD width="35%" height=13><INPUT type = "text" name="spare_num" value="" size="30" maxlength="50"></TD>
             </TR>
             <TR>
			<TD height=13 colspan="6"  align="center"><INPUT type="button" value=" 提交  " name=""><INPUT type="reset" value=" 清除  " name=""></TD>
		</TR>
  		  </TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
</html>