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
           function zhigongAdd()
           {
                 var url="<%=path %>/admin/zhigong/zhigongAdd.jsp";
				 window.location.href=url;
           }
           
           function zhigongDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/zhigong?type=zhigongDel&id="+id;
               }
           }           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="8" background="<%=path %>/img/tbg.gif">&nbsp;职工信息管理&nbsp;</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td colspan="6" >
						<form action="<%=path %>/zhigong?type=zhigongMana" method="post">
							职工编号:<input type="text" name="bianhao" value="${bianhao }"/>
							<input type="submit" value="查询"/>
						</form>
					</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>职工编号</td>
					<td>姓名</td>
					<td>所在部门</td>
					<td>性别</td>
					<td>入职时间</td>
					<td>操作</td>
		        </tr>	
				<c:forEach items="${requestScope.zhigongList}" var="zhigong">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${zhigong.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong.xingming}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong.bmmc}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong.xingbie}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zhigong.ruzhi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/zhigong/zhigongEditPre.jsp" method="post">
							<input type="hidden" name="id" value="${zhigong.id }"/>
							<input type="hidden" name="bumen_id" value="${zhigong.bumen_id }"/>
							<input type="hidden" name="bmmc" value="${zhigong.bmmc }"/>
							<input type="hidden" name="bianhao" value="${zhigong.bianhao }"/>
							<input type="hidden" name="loginpw" value="${zhigong.loginpw }"/>
							<input type="hidden" name="xingming" value="${zhigong.xingming }"/>
							<input type="hidden" name="xingbie" value="${zhigong.xingbie }"/>
							<input type="hidden" name="ruzhi" value="${zhigong.ruzhi }"/>
							<input type="submit" value="修改"/>						
							<input type="button" value="删除" onclick="zhigongDel(${zhigong.id})"/>
						</form>
					</td>					
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="zhigongAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
