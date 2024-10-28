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
					<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;资产情况&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>数量</td>
					<td>价值(万元)</td>
					<td>类型</td>
		        </tr>	
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${zczj.sl}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zczj.jz}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						增加资产
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${zcjs.sl}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${zcjs.jz}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						减少资产
					</td>
				</tr>
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="left" colspan="3">
						总资产：${zongzichan.zichan}&nbsp;&nbsp;&nbsp;&nbsp;(万元)
					</td>
				</tr>
			</table>
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="3" background="<%=path %>/img/tbg.gif">&nbsp;经营情况&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td>总投入(万元)</td>
					<td>总收益(万元)</td>
					<td>总利润(万元)</td>
		        </tr>	
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${jingying.touru}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jingying.shouyi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${jingying.lirun}
					</td>
				</tr>
			</table>	
			
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14">年终资产:${nz.nz }&nbsp;&nbsp;&nbsp;(万元)</td>
				</tr>
			</table>					
	</body>
</html>
