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
	<form  id="form_page" action="" method="post" >
	<!-- 主内容区域（数据列表或表单显示） -->
	<div id="MainArea">
		<table class="MainArea_Content" align="center" cellspacing="0"
			cellpadding="0">
			<!-- 表头-->
			<thead>
				<tr align="center" valign="middle" id="TableTitle">
					<td>订单编号</td>
					<td>餐桌名</td>
					<td>下单日期</td>
					<td>总金额</td>
					<td>状态</td>
					<td>操作</td>
				</tr>
			</thead>
			<!--显示数据列表 -->
			<tbody id="TableData">
				<c:choose>
        		<c:when test="${not empty requestScope.orderList }">
        			<c:forEach var="order" items="${requestScope.orderList }" varStatus="o">
        				<tr align="center">
        					<td>${order.id }</td>
        					<td>${order.dinnerTable.tableName }</td>
        					<td>${order.orderDate }</td>
        					<td>${order.totalPrice }</td>
        					<c:choose>
							<c:when test="${order.orderStatus==0}">
							<td align="center">未结账</td>
							</c:when>
								<c:otherwise>
									<td align="center">已结账</td>
								</c:otherwise>
							</c:choose>
									
							<td><a href="${basePath}modifyInfo_3detail.action?order.id=${order.id}" class="FunctionButton">详细</a>

							<a href="${basePath}modifyInfo_3pay.action?order.id=${order.id}&money=${order.totalPrice }" class="FunctionButton">结账</a>
							<a href="${basePath}modifyInfo_3delete.action?order.id=${order.id}" class="FunctionButton">退订</a>
							</td>
						</tr>      			
        			</c:forEach>
        		</c:when>
        		<c:otherwise>
        			<tr>
        				<td colspan="6">没有你要找找的数据</td>
        			</tr>
        		</c:otherwise>
        	</c:choose>
				
			</tbody>
		</table>
		
	
	</div>
</form>

  </body>
</html>
