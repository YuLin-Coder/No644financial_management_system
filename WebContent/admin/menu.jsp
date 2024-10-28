<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'menu.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=path %>/css/base.css" type="text/css" />
	<link rel="stylesheet" href="<%=path %>/css/menu.css" type="text/css" />
	<style type="text/css">
	    div {
			padding:0px;
			margin:0px;
		}
		
		body {
		 scrollbar-base-color:#bae87c;
		 scrollbar-arrow-color:#FFFFFF;
		 scrollbar-shadow-color:#c1ea8b;
		 padding:0px;
		 margin:auto;
		 text-align:center;
		 background-color:#9ad075;
		}
		
		dl.bitem {
			width:148px;
			margin:0px 0px 5px 4px;
		}
		
		dl.bitem dt {
		  background:url(<%=path %>/img/menubg.gif);
		  height:26px;
		  line-height:26px;
		  text-align:center;
		  cursor:pointer;
		}
		
		dl.bitem dd {
		  padding:3px 3px 3px 3px;
		  background-color:#fff;
		}
		
		.fllct
		{
			float:left;
			
			width:90px;
		}
		
		.flrct
		{
			padding-top:3px;
			float:left;
		}
		
		div.items
		{
			line-height:22px;
			background:url(<%=path %>/img/arr4.gif) no-repeat 10px 9px;
		}
		
		span.items
		{
			padding:10px 0px 10px 22px;
			background:url(<%=path %>/img/arr4.gif) no-repeat 10px 12px;
		}
		
		ul {
		  padding-top:3px;
		}
		
		li {
		  height:22px;
		}
		
		.sitemu li {
			padding:0px 0px 0px 22px;
			line-height:24px;
			background:url(<%=path %>/img/arr4.gif) no-repeat 10px 9px;
		}
	</style>
	<script language='javascript'>var curopenItem = '1';</script>
	<script language="javascript" type="text/javascript" src="<%=path %>/js/menu.js"></script>
	<base target="main" />
  </head>
  
  <body target="main">
  <c:if test="${sessionScope.userType==0}">
	<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
	  <tr>
	    <td style='padding-left:3px;padding-top:8px' valign="top">
	      <dl class='bitem'>
	        <dt onClick='showHide("items1_1")'><b>修改个人密码</b></dt>
	        <dd style='display:block' class='sitem' id='items1_1'>
	          <ul class='sitemu'>
	              <li><a href='<%=path %>/admin/userinfo/userPw.jsp' target='main'>修改个人密码</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items2_1")'><b>部门信息管理</b></dt>
	        <dd style='display:block' class='sitem' id='items2_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/admin/bumen/bumenAdd.jsp' target='main'>部门信息添加</a> </li>
                 <li><a href='<%=path %>/bumen?type=bumenMana' target='main'>部门信息管理</a> </li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items2_1")'><b>职工信息管理</b></dt>
	        <dd style='display:block' class='sitem' id='items2_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/admin/zhigong/zhigongAdd.jsp' target='main'>职工信息添加</a> </li>
                 <li><a href='<%=path %>/zhigong?type=zhigongMana' target='main'>职工信息管理</a> </li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items2_1")'><b>职工工资管理</b></dt>
	        <dd style='display:block' class='sitem' id='items2_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/zhigong?type=zhigongList' target='main'>职工工资添加</a> </li>
                 <li><a href='<%=path %>/gongzi?type=gongziMana' target='main'>职工工资管理</a> </li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items3_1")'><b>资产类别管理</b></dt>
	        <dd style='display:block' class='sitem' id='items3_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/admin/catelog/catelogAdd.jsp' target='main'>资产类别添加</a> </li>
                 <li><a href='<%=path %>/catelog?type=catelogMana' target='main'>资产类别管理</a> </li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items4_1")'><b>资产信息管理</b></dt>
	        <dd style='display:block' class='sitem' id='items4_1'>
	          <ul class='sitemu'>
	              <li><a href='<%=path %>/zichan?type=zichanToAdd' target='main'>资产信息添加</a></li>
	              <li><a href='<%=path %>/zichan?type=zichanMana' target='main'>资产信息管理</a></li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items4_1")'><b>经营信息管理</b></dt>
	        <dd style='display:block' class='sitem' id='items4_1'>
	          <ul class='sitemu'>
	              <li><a href='<%=path %>/admin/jingying/jingyingAdd.jsp' target='main'>经营信息添加</a></li>
	              <li><a href='<%=path %>/jingying?type=jingyingMana' target='main'>经营信息查看</a></li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items4_1")'><b>费用信息管理</b></dt>
	        <dd style='display:block' class='sitem' id='items4_1'>
	          <ul class='sitemu'>
	              <li><a href='<%=path %>/admin/feiyong/feiyongAdd.jsp' target='main'>费用信息添加</a></li>
	              <li><a href='<%=path %>/feiyong?type=feiyongMana' target='main'>费用信息查看</a></li>
	          </ul>
	        </dd>
	      </dl>
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>年终资产分析</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/fenxi' target='main'>年终资产分析</a></li>
	          </ul>
	        </dd>
	      </dl>		      
		  </td>
	  </tr>
	</table>
	</c:if>
	
  <c:if test="${sessionScope.userType==1}">
	<table width='99%' height="100%" border='0' cellspacing='0' cellpadding='0'>
	  <tr>
	    <td style='padding-left:3px;padding-top:8px' valign="top">
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>个人信息修改</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/zhigong?type=zhigong_me' target='main'>个人信息修改</a></li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>个人工资查看</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/gongzi?type=gongzi_me' target='main'>个人工资查看</a></li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>公司资产查询</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/zichan?type=zichanList' target='main'>公司资产查询</a></li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>公司经营查询</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/jingying?type=jingyingList' target='main'>公司经营查询</a></li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>公司费用查询</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/feiyong?type=feiyongList' target='main'>公司费用查询</a></li>
	          </ul>
	        </dd>
	      </dl>	      
	      <dl class='bitem'>
	        <dt onClick='showHide("items99_1")'><b>年终资产分析</b></dt>
	        <dd style='display:block' class='sitem' id='items99_1'>
	          <ul class='sitemu'>
                 <li><a href='<%=path %>/fenxi' target='main'>年终资产分析</a></li>
	          </ul>
	        </dd>
	      </dl>	      
		  </td>
	  </tr>
	</table>
	</c:if>
  </body>
</html>
