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
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="30" background="<%=path %>/img/tbg.gif">公司经营查询</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>项目名称</td>
					<td>时间</td>
					<td>投入</td>
					<td>收入（万元）</td>
					<td>利润</td>
					<td>类型</td>
		        </tr>	
				<c:forEach items="${requestScope.jingyingList}" var="jingying">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${jingying.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jingying.riqi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jingying.touru}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jingying.shouyi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jingying.lirun}
					</td>					
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${jingying.lirun>0}">
							盈利
						</c:if>
						<c:if test="${jingying.lirun<0}">
							亏损
						</c:if>
					</td>					
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
