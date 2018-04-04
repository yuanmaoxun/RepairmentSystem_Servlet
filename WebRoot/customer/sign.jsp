<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="cn.edu.repairmentsystem.javabean.*" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <title>sign.jsp</title>
	
    <meta name="keywords" content="keyword1,keyword2,keyword3">
    <meta name="description" content="this is my page">
    <meta name="content-type" content="text/html; charset=UTF-8">
    

  </head>
  
<BODY style="background-color:#d5e2e1" leftmargin="0" topmargin="0" marginheight="0" marginwidth="0">
<br/>
<TABLE width="98%" border=0 align="center">
	<tr>
	  <td align="right"><a style="font-size: 14px">打印</a></td></tr>
  <TD width="100%"><FORM name="form1" action="/RepairmentSystem/customerservlet1" method="post">
        <TABLE borderColor=#f7f8c7 height=18 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="100%" bgColor=#f0f0f0
       borderColorLight=#000000 border=1>
          <tr height="15" style="height:11.25pt">
			<td height="15"  colspan="6" >
			<table border="0" width="100%" >
				<tr>
					<td align="center"><b>客户登记管理</b></td>
				</tr>
			</table>
			</td>
		  </tr>
          <TR>
               <TD width="15%" height=13 align="right">客户编号：</TD>
               <TD width="15%" height=13>${param.cus_no}</TD>
               <TD width="15%" align="right">身份证号码：</TD>
               <TD width="15%">${ param.cus_id}</TD>
       
          </TR>
             <TR>
               <TD width="15%" height=13 align="right">客户性质：</TD>
               <TD width="85%" height=13 colspan="5" >${ param.cus_pro}</TD>
              </TR>
          <TR>
               <TD width="15%" height=13 align="right">单位名称：</TD>
               <TD width="15%" height=13>${ param.cus_pro}</TD>
               <TD width="15%" align="right">座机：</TD>
               <TD width="15%">${ param.cus_phone}</TD>
               <TD width="10%" align="right">移动电话：</TD>
            <TD width="30%" align="left">${ param.cus_mobile}</TD>
          </TR>
          <TR>
               <TD width="15%" height=13 align="right">客户地址：</TD>
               <TD width="15%" height=13>${ param.cus_addr}</TD>
               <TD width="15%" align="right">联系人：</TD>
               <TD width="15%">${ param.cus_contact}</TD>
               <TD width="10%" align="right">email：</TD>
               <TD width="30%" align="left">${ param.cus_email}</TD>
             </TR>
        </TABLE>
      </FORM>
      </TD>
  </TR>
</TABLE>

