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
		
        <script language="javascript">
           function bumenDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/bumen?type=bumenDel&id="+id;
               }
           }
           
           function bumenAdd()
           {
                 var url="<%=path %>/admin/bumen/bumenAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="30" background="<%=path %>/img/tbg.gif">部门信息管理</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="33%">名称</td>
					<td width="33%">人数</td>
					<td width="33%">工资系数</td>
					<td width="33%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.bumenList}" var="bumen">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${bumen.mingcheng}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${bumen.renshu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${bumen.xishu}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<form action="<%=path %>/admin/bumen/bumenEditPre.jsp" method="post">
							<input type="hidden" name="id" value="${bumen.id }"/>
							<input type="hidden" name="mingcheng" value="${bumen.mingcheng }"/>
							<input type="hidden" name="renshu" value="${bumen.renshu }"/>
							<input type="hidden" name="xishu" value="${bumen.xishu }"/>
							<input type="submit" value="修改"/>						
							<input type="button" value="删除" onclick="bumenDel(${bumen.id})"/>
						</form>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="bumenAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
