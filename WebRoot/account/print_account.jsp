<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<<HTML><HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Language content=zh-cn>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<META content="MSHTML 5.50.4134.600" name=GENERATOR></HEAD>
<link rel="stylesheet" href="style/style.css" type="text/css">
<BODY leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" style="background-color:#d5e2e1">

<table border="0" width="98%" align="center"><tr><td height='4'></td></tr></table>

<TABLE width="72%" border=0 align="center">
    <TR>
     <TD width="100%">
  <FORM name="intostorage" action="" method="post">
  <input type="hidden" name="act" value="add">
    <TABLE borderColor=#f7f8c7 height=418 cellSpacing=0  borderColorDark=#f7f8c7 cellPadding=2 width="93%" bgColor=#f0f0f0   borderColorLight=#000000 border=1>
        <tr height="15" style="height:11.25pt">
        <td height="15"  colspan="6" >
          <table border="0" width="100%" >
            <tr>
              <td align="center"><b>打印结算清单</a></b></font></td>
            </tr>
          </table>
        </td>
        </tr>
			<TR>
                <TD width="15%" height=32 align="right"><font size="4">结算单号:</font></TD>
                <TD width="35%" height=32><b>${result+1}</b><input type ="hidden" name="accno" value="${result+1}"/></TD>
             </TR>
        	<TR>
                <TD width="15%" height=32 align="right"><font size="4">维修信息:</font></TD>
                <TD width="35%" height=32></TD>
         
             </TR>
			<TR>
                <TD width="15%" height=13 align="right">维修单号：</TD>
                <TD width="35%" height=13><b>${data.fix_no}</b><input type ="hidden" name="fixno" value="${data.fix_no}"/></TD>
          		<TD width="15%" height=13 align="right">接修日期：</TD>
          		<TD width="35%" height=13><b>${data.fix_allocatetime}</b></TD>
             </TR>
             <TR>
                <TD width="15%" height=13 align="right">机器类型：</TD>
                <TD width="35%" height=13><b>${data.dev_ptype}</b></TD>
          <TD width="15%" height=13 align="right">机器品牌：</TD>
          <TD width="35%" height=13><b>${data.dev_brand}</b></TD>
             </TR>
             <TR>
                <TD width="15%" height=13 align="right">机器型号：</TD>
                <TD width="35%" height=13><b>${data.dev_model}</b></TD>
          <TD width="15%" height=13 align="right">维修人员：</TD>
          <TD width="35%" height=13><b>${data.adm_name}</b></TD>
             </TR>
             <TR>
                <TD width="15%" height=13 align="right"><font size="4">缴费人信息:</font></TD>
                <TD width="35%" height=13></TD>
         
             </TR>

             <TR>
                <TD width="15%" height=13 align="right">联系人姓名：</TD>
                <TD width="35%" height=13><b>${data.cus_contact}</b></TD>
          <TD width="15%" height=13 align="right">身份证号：</TD>
          <TD width="35%" height=13><b>${data.cus_id}</b></TD>
             </TR>
             <TR>
                <TD width="15%" height=13 align="right">客户性质：</TD>
                <TD width="35%" height=13><b>${data.cus_pro}</b></TD>
          <TD width="15%" height=13 align="right">移动电话：</TD>
          <TD width="35%" height=13><b>${data.cus_mobile}</b></TD>
             </TR>

        <TR>
                <TD width="15%" height=13 align="right"><font size="4">缴费信息:</font></TD>
                <TD width="35%" height=13></TD>
         
             </TR>

             <TR>
                <TD width="15%" height=13 align="right">人工费：</TD>
                <TD width="35%" height=13><b>${data.fix_money}</b></TD>
          		<TD width="15%" height=13 align="right">材料费：</TD>
          		<TD width="35%" height=13><b>${data.fix_material}</b></TD>
             </TR>
             <TR>
                <TD width="15%" height=13 align="right">费用合计：</TD>
                <TD width="35%" height=13><b>${data.fix_money+data.fix_material}</b><input type ="hidden" name="cost" value="${data.fix_money+data.fix_material}"/></TD>
         
             </TR>
             
            <TR>
                  <TD width="15%" height=25 align="right"></TD>
              </TR>
              
             <TR>
                <TD width="15%" height=13></TD>
                <TD width="35%" height=13  align="left"> 缴费人签字: </TD>
          		<TD width="15%" height=13 ></TD>
          		<TD width="35%" height=13 align="left"> 财务处盖章: </TD>
             </TR>
              <TR>
                  <TD height=76 colspan="4"  align="center"><button onClick="doSave()">&nbsp;&nbsp;提交&nbsp;&nbsp;</button><INPUT type='reset' value=" 打印   " name=B2></TD>
              </TR>
              
        </TABLE>
  </FORM>
  </TD></TR></TABLE>
</body>
<script type="text/javascript">
function doSave(){
  	    document.forms[0].action='/RepairmentSystem/addaccount';
  		document.forms[0].submit();
  	}
</script>

</html>
