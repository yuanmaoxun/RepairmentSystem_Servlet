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
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" style="background-color:#d5e2e1">
<br>

<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>
<TABLE width="98%" border=0 align="center">
   <TR>
     <TD width="100%" align="right"><a>打印</a></TD>
   </TR>
    <TR>
     <TD width="100%">
	<input type="hidden" name="act" value="add">
		<TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
		  <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>电子维修客户确认表</b></td>
				</tr>
			</table>
			</td>
		  </tr>
        <TR>
        	<TD width="15%" height=13 colspan="6" align="left" style="font-size: 14px">&nbsp;&nbsp;&nbsp;<span style="font-size: 14px">&nbsp;&nbsp;报修信息：</span></TD>
        </TR>
		<TR>
	      <TD width="15%" height=13 align="right" style="font-size: 14px" >报修单号：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;">${data4.rep_no}<input  type="hidden" id="" name="rep_no" value="${data4.rep_no}" /></TD>
          <TD width="15%" height=13 align="right" style="font-size: 14px" >客户编号：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;">${param.cus_no}<input  type="hidden" id="cus_no" name="cus_no" value="${param.cus_no}" /></TD>
          <TD width="15%" height=13 align="right" style="font-size: 14px" >报修状态：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >进行中<input  type="hidden" id="rep_condition" name="rep_condition" value="进行中" /></TD>
		</TR>
		  
		<TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px" >预估价格：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.rep_estimate}<INPUT type="hidden" name="rep_estimate" value="${param.rep_estimate}" size="20" maxlength="50"></TD>
          <TD width="15%" height=13 align="right" style="font-size: 14px" >预估完成时间：</TD>
		  <TD width="15%" height=13 colspan="4" style="font-size: 14px; font-weight: bold;" >${param.rep_end}<INPUT type="hidden" name="rep_end" value="${param.rep_end}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">重要资料：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.rep_data}<INPUT type="hidden" name="rep_data" value="${param.rep_data}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right" style="font-size: 14px">其他(详)：</TD>
		  <TD width="15%" height=13 colspan="3" style="font-size: 14px; font-weight: bold;">${param.rep_others}<INPUT type="hidden" name="rep_others" value="${param.rep_others}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
        	<TD width="15%" height=13 colspan="6" align="left" style="font-size: 14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机器信息：</TD>
        </TR>
		<TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px"><FONT color=#FF0000>&nbsp;</FONT>产品类型：</TD>
			<TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.dev_ptype}
            	<INPUT type="hidden" name="dev_ptype" value="${param.dev_ptype}" size="20" maxlength="50">
            </TD>
			<TD width="15%" height=13 align="right" style="font-size: 14px">机器品牌：</TD>
			<TD width="15%" height=13 style="font-size: 14px; font-weight: bold;">${param.dev_brand}
            	<INPUT type="hidden" name="dev_brand" value="${param.dev_brand}" size="20" maxlength="50">
            </TD>
            <TD width="15%" height=13 align="right" style="font-size: 14px">机器型号：</TD>
			<TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.dev_model}
            	<INPUT type="hidden" name="dev_model" value="${param.dev_model}" size="20" maxlength="50">
            </TD>
		</TR>
		<TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">序列号：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.dev_series}<INPUT type="hidden" name="dev_series" value="${param.dev_series}" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" style="font-size: 14px">开机口令：</TD>
		  <TD width="15%" height=13 colspan="3" style="font-size: 14px; font-weight: bold;">${param.dev_command}<INPUT type="hidden" name="dev_command" value="${param.dev_command}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">HDD：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.dev_hdd}<INPUT type="hidden" name="dev_hdd" value="${param.dev_hdd}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right" style="font-size: 14px">内存：</TD>
		  <TD width="15%" height=13 colspan="3" style="font-size: 14px; font-weight: bold;">${param.dev_rom}<INPUT type="hidden" name="dev_rom" value="${param.dev_rom}" size="20" maxlength="50"></TD>
		</TR>
        <TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">外置PC卡：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.dev_pc}<INPUT type="hidden" name="dev_pc" value="${param.dev_pc}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right" style="font-size: 14px">AC适配器：</TD>
		  <TD width="15%" height=13 colspan="3" style="font-size: 14px; font-weight: bold;">${param.dev_adapt}<INPUT type="hidden" name="dev_adapt" value="${param.dev_adapt}" size="20" maxlength="50"></TD>
		</TR>
		<TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">电池：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.dev_battery}<INPUT type="hidden" name="dev_battery" value="${param.dev_battery}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right" style="font-size: 14px">外接光驱：</TD>
		  <TD width="15%" height=13 colspan="3" style="font-size: 14px; font-weight: bold;">${param.dev_drive}<INPUT type="hidden" name="dev_drive" value="${param.dev_drive}" size="20" maxlength="50"></TD>
		</TR>
		<TR>
			<TD width="15%" height=13 colspan="6" align="left" style="font-size: 14px">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;机器故障信息：</TD>
		</TR>	
		<TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">缺少零件：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.rep_spare}<INPUT type="hidden" name="rep_spare" value="${param.rep_spare}" size="20" maxlength="50"></TD>
			<TD width="15%" height=13 align="right" style="font-size: 14px"><FONT color=#FF0000>&nbsp;</FONT>故障现象：</TD>
		  <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.rep_app}<INPUT type="hidden" name="rep_app" value="${param.rep_app}" size="20" maxlength="50"></TD>
            <TD width="15%" height=13 align="right" style="font-size: 14px">故障类型：</TD>
            <TD width="15%" height=13 style="font-size: 14px; font-weight: bold;" >${param.rep_fault}<INPUT type="hidden" name="rep_fault" value="${param.rep_fault}" size="20" maxlength="50"></TD>
		</TR>		  
		<TR>
		  <TD width="15%" height=13 align="right" style="font-size: 14px">机器检查：</TD>
		  <TD width="15%" height=13 colspan="5" style="font-size: 14px; font-weight: bold;">${param.rep_check}<INPUT type="hidden" name="rep_check" value="${param.rep_check}" size="20" maxlength="50"></TD>
		</TR> 
  	</TABLE>
	</TD></TR></TABLE>
    &nbsp;&nbsp;&nbsp;<span style="font-size: 14px">
		接机签字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		机主签字:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		打印时间:
    </span>
</body>
</html>
