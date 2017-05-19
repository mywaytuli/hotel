<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 包含公共的JSP代码片段 -->

<title>无线点餐平台</title>

<%@include file="/sys/public/header.jsp"%>
	<script type="text/javascript">
		var list_url = "${basePath}sys/order_list.action";
	</script>
</head>
<body>
	<!-- 页面标题 -->
	<div id="TitleArea">
		<div id="TitleArea_Head"></div>
		<div id="TitleArea_Title">
			<div id="TitleArea_Title_Content">
				<img border="0" width="13" height="13"
					src="${basePath }sys/style/images/title_arrow.gif" />
				用户订单列表
			</div>
		</div>
		<div id="TitleArea_End"></div>
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
        		<c:when test="${not empty requestScope.pageResult.items }">
        			<c:forEach var="order" items="${requestScope.pageResult.items }" varStatus="o">
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
									
							<td><a href="${basePath}sys/user_orderDetail.action?order.id=${order.id}" class="FunctionButton">详细</a>

							<a href="${basePath}sys/user_orderPay.action?order.id=${order.id}" class="FunctionButton">结账</a>
							<a href="${basePath}sys/user_orderDelete.action?order.id=${order.id}" class="FunctionButton">删除</a>
							</td>
						</tr>      			
        			</c:forEach>
        		</c:when>
        		<c:otherwise>
        			<tr>
        				<td colspan="6">没有你要找找的数据，请先保存记录再查看！</td>
        			</tr>
        		</c:otherwise>
        	</c:choose>
				
			</tbody>
		</table>
		<!-- 其他功能超链接 -->
		<div id="TableTail" align="center">
		<jsp:include page="/sys/public/pageresule.jsp"/>
		
    </div> 
	</div>
</form>
</body>
</html>
