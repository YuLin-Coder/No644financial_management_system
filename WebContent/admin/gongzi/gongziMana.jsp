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
        <script language="javascript">
           function gongziAdd()
           {
                 var url="<%=path %>/zhigong?type=zhigongList";
				 window.location.href=url;
           }
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="10" background="<%=path %>/img/tbg.gif">&nbsp;职工工资管理&nbsp;</td>
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
					<td>操作</td>
		        </tr>	
				<c:forEach items="${requestScope.gongziList}" var="gongzi">
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
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/gongzi/gongziEditPre.jsp" method="post">
							<input type="hidden" name="id" value="${gongzi.id }"/>
							<input type="hidden" name="bmmc" value="${gongzi.zgxx.bmmc }"/>
							<input type="hidden" name="bianhao" value="${gongzi.zgxx.bianhao }"/>
							<input type="hidden" name="xingming" value="${gongzi.zgxx.xingming }"/>
							<input type="hidden" name="xishu" value="${gongzi.zgxx.xishu }"/>
							<input type="hidden" name="jiben" value="${gongzi.jiben }"/>
							<input type="hidden" name="gongling" value="${gongzi.gongling }"/>
							<input type="hidden" name="zhiwu" value="${gongzi.zhiwu }"/>
							<input type="hidden" name="butie" value="${gongzi.butie }"/>
							<input type="submit" value="修改"/>						
						</form>
					</td>					
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="gongziAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
