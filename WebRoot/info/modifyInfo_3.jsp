<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>订单信息</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="${basePath}sys/style/js/jquery.js"></script>
	<script type="text/javascript" src="${basePath}sys/style/js/page_common.js"></script>
	<link href="${basePath}sys/style/css/common_style_blue.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="${basePath}sys/style/css/index_1.css" />
	 <script type="text/javascript" src="${basePath }js/jquery-1.8.2.min.js"></script>
  </head>
  
  <body>
  	<div class="head" style="margin-top: 30px">
      <table width="1000" height="60" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr>
          <td width="840" align="left"><img src="${basePath}images/login/form_03.png"   width="332" height="47"/></td>
          <td align="center">&nbsp;&nbsp;<a href="#"></a></td>
        </tr>
      </table>
 </div>
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0" cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>菜名</td>
					<td>单价</td>
					<td>数量</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:forEach items="${requestScope.orderDetailList}" var="od">
			 		<tr height="60">
			 		<td align="center" width="20%">${od.food.foodName }</td>
			 		<c:choose>
			 			<c:when test="${not empty od.order.user}">
							<td align="center" width="20%">￥${od.food.mprice }</td>
			 			</c:when>
			 			<c:otherwise>
							<td align="center" width="20%">￥${od.food.price }</td>
			 			</c:otherwise>
			 		</c:choose>
					<td align="center" width="20%">${od.foodCount}</td>
			 		</tr>
			 	</c:forEach>
			 	
			 	
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
			 <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
		</div>
	</div>
  </body>
</html>
