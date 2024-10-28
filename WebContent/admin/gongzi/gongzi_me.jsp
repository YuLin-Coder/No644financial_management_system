<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/jsxx/jsxxBus.js"></script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/img/tbg.gif">&nbsp;职工工资查询&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>职工编号</td>
					<td>姓名</td>
					<td>所在部门</td>
					<td>工资系数</td>
					<td>基本工资</td>
					<td>工龄</td>
					<td>职务</td>
					<td>补贴</td>
					<td>合计</td>
		        </tr>	
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.zgxx.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.zgxx.xingming}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.zgxx.bmmc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.zgxx.xishu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.jiben}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.gongling}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.zhiwu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.butie}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${gongzi.hj}
					</td>
				</tr>
			</table>
	</body>
</html>
