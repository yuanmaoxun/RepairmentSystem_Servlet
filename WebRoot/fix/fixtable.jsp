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
<BODY style="background-color:#d5e2e1" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br>

<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>
<TABLE width="98%" border=0 align="center">
   <TR>
     <TD width="100%" align="right"><FONT color=#493eb5>注:标有</FONT><FONT color=#FF0000>&nbsp;*&nbsp;</FONT><FONT color=#493eb5>的项必填&nbsp;</FONT></TD>
   </TR>
    <TR>
     <TD width="100%">
	<form action="" method="post">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>维修产品登记管理</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
		<TR>
			<TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>维修单号：</TD>
			<TD width="15%" height=13 >${result.fix_no}<input  type="hidden" id="fix_no" name="fix_no" value="${result.fix_no}" />
			</TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>分配时间：</TD>
			<TD width="15%" height=13 colspan="3">${result.fix_allocatetime}<input  type="hidden" id="fix_allocatetime" name="fix_allocatetime" value="${result.fix_allocatetime}" />
			</TD>
		</TR>
		  
		<TR>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>检测记录：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="fix_check" value="" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>维修记录：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="fix_fix" value="" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>维修时间：</TD>
			<TD width="15%" height=13 ><INPUT type="Date" name="fix_checktime" value="" size="20" maxlength="50"></TD>
		</TR>
        
        <TR>
			<TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>工作量：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="fix_quantity" value="" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>人工费：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="fix_money" value="" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>材料费：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="fix_material" value="" size="20" maxlength="50"></TD>
		</TR>
        <TR>
        	<TD width="15%" height=13 align="right" >注意事项：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="fix_attention" value="" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>维修状态：</TD>
			<TD width="15%" height=13 >
            	<select id="fix_condition" name="fix_condition" >
                <option>已分配</option>
                <option>已维修</option>
                <option>撤销</option>
            	</select>
            </TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>维修延迟程度：</TD>
			<TD width="15%" height=13 >
            	<select id="fix_level" name="fix_level">
                <option>一般</option>
                <option>比较严重</option>
                <option>严重</option>
            	</select>
            </TD>
        </TR>
        <TR>
			<TD height=13 colspan="6"  align="center"><button onClick="doSave()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button> <INPUT type="reset" value=" 清除  " name=""></TD>
		</TR>
		<TD width="15%" height=13 ><input  type="hidden" id="rep_no" name="rep_no" value="${result.rep_no}" />
		<TD width="15%" height=13 ><input  type="hidden" id="rep_no" name="fix_staffno" value="${result.fix_staffno}" />
			</TD> 
  	</TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
<script type="text/javascript">
  	function doQuery1(){
  	   // document.forms[0].action='/RepairmentSystem/repair/DeviceInfo';
  		//document.forms[0].submit();
  	}
  	/* function dohint(){
  		var info=document.getElementById("info1");
  		info.innerHTML="<font color='red'>${str}jkdjfkj</font>";
		return false;
  	} */
  	function doSave(){
  	    document.forms[0].action='/RepairmentSystem/addfixrecord';
  		document.forms[0].submit();
  	}
 </script>
</html>
