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
					<td align="center"><b>报修产品登记管理</a></b></font></td>
				</tr>
			</table>
			</td>
		  </tr>
        <TR>
        	<TD width="15%" height=13 align="left" colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;报修信息：</TD>
        </TR>
		<TR>
			<TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>客户编号：</TD>
			<TD width="15%" height=13 colspan="5">${data2.cus_no}<input  type="hidden" id="cus_no" name="cus_no" value="${data2.cus_no}" />
			</TD>
		</TR>
		  
		<TR>
			<TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>预估价格：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="rep_estimate" value="${param.rep_estimate}" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>预估完成时间：</TD>
			<TD width="15%" height=13 ><INPUT type="Date" name="rep_end" value="${param.rep_end}" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" ><FONT color=#FF0000>*&nbsp;</FONT>报修状态：</TD>
			<TD width="15%" height=13 >进行中<input  type="hidden" id="rep_condition" name="rep_condition" value="进行中" /></TD>
		</TR>
        <TR>
			<TD width="15%" height=13 align="right">重要资料：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="rep_data" value="${param.rep_data}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">其他(详)：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT type="text" name="rep_others" value="${param.rep_others}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
        	<TD width="15%" height=13 align="left" colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机器信息：</TD>
        </TR>
        <TR>
			<TD width="15%" height=13 align="right" >序列号查询：</TD>
			<TD width="15%" height=13 colspan="5"><INPUT type="text" id="u" name="dev_seriesque" value="" size="20" maxlength="50">&nbsp;&nbsp;		 
            <button onclick="doQuery1()" >查询</button>
            <span><font color='red'>&nbsp;&nbsp;${data3}</font></span>
            <input  type="hidden" id="dev_id" name="dev_id" value="${data1.dev_id}" />
            </TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>产品类型：</TD>
			<TD width="15%" height=13 >
            	<INPUT type="text" name="dev_ptype" value="${data1.dev_ptype}" size="20" maxlength="50">
            </TD>
			<TD width="15%" height=13 align="right">机器品牌：</TD>
			<TD width="15%" height=13>
            	<INPUT type="text" name="dev_brand" value="${data1.dev_brand}" size="20" maxlength="50">
            </TD>
            <TD width="15%" height=13 align="right">机器型号：</TD>
			<TD width="15%" height=13 >
            	<INPUT type="text" name="dev_model" value="${data1.dev_model}" size="20" maxlength="50">
            </TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>序列号：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="dev_series" value="${data1.dev_series}" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right">开机口令：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT type="text" name="dev_command" value="${data1.dev_command}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
			<TD width="15%" height=13 align="right">HDD：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="dev_hdd" value="${data1.dev_hdd}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">内存：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT type="text" name="dev_rom" value="${data1.dev_rom}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
			<TD width="15%" height=13 align="right">外置PC卡：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="dev_pc" value="${data1.dev_pc}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">AC适配器：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT type="text" name="dev_adapt" value="${data1.dev_adapt}" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="right">电池：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="dev_battery" value="${data1.dev_battery}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right">外接光驱：</TD>
			<TD width="15%" height=13 colspan="3"><INPUT type="text" name="dev_drive" value="${data1.dev_drive}" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 align="left" colspan="6">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机器故障信息：</TD>
		</TR>	
		<TR>
			<TD width="15%" height=13 align="right">缺少零件：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="rep_spare" value="${param.rep_spare}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>故障现象：</TD>
			<TD width="15%" height=13 ><INPUT type="text" name="rep_app" value="${param.rep_app}" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right"><FONT color=#FF0000>*&nbsp;</FONT>故障类型：</TD>
			<TD width="15%" height=13 >
            	<select id="rep_fault" name="rep_fault" value="${param.rep_fault}">
                <option>请选择</option>
                <option>固定性故障</option>
                <option>间隙性故障</option>
            	</select>
            </TD>
		</TR>		  
		<TR>
			<TD width="15%" height=13 align="right">机器检查：</TD>
			<TD width="15%" height=13 colspan="5"><INPUT type="text" name="rep_check" value="${param.rep_check}" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD height=13 colspan="6"  align="center"><button onclick="doSave()">&nbsp;&nbsp;保存&nbsp;&nbsp;</button> <INPUT type="reset" value=" 清除  " name=""></TD>
		</TR>  
  	</TABLE>
	</FORM>
	</TD></TR></TABLE>
</body>
<script type="text/javascript">
  	function doQuery1(){
  		//var u=document.getElementById("u");
  		//var info=document.getElementById("info1");
  	    document.forms[0].action='/RepairmentSystem/repair/DeviceInfo';
  		document.forms[0].submit();
  		//info.innerHTML="<font color='red'>${str}jkdjfkj</font>";
		//return false;
  	}
  	/* function dohint(){
  		var info=document.getElementById("info1");
  		info.innerHTML="<font color='red'>${str}jkdjfkj</font>";
		return false;
  	} */
  	function doSave(){
  	    document.forms[0].action='/RepairmentSystem/DeviceSubmitServlet';
  		document.forms[0].submit();
  	}
 </script>
</html>
