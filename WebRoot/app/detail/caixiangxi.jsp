<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<%@include file="/app/detail/public/header.jsp" %>
	<link href="${basePath}app/detail/style/css/index.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="${basePath}app/detail/style/css/dis_message.css" />
</head>
<body style="text-align: center">
	<div id="all">
		<!--左边菜品详细信息 -->
		<div id="menu1">
			<div class="menu2" style="text-align:center;">
				<img src="${basePath}app/detail/style/images/order_detials_bg.png" />
			</div>                                      
			<div class="menu3">
				<div class="menu3_left">
					<img src="${basePath }upload/${requestScope.foodDetail.img}""
						style="width:270px; height:290px;" />
				</div>
				<div class="menu3_right">
					<p>菜名:${requestScope.foodDetail.foodName}</p>
					<c:choose>
									<c:when test="${not empty info }">
										<p>价格:&nbsp;&nbsp;&yen;&nbsp;${requestScope.foodDetail.mprice }</p>
									</c:when>
									<c:otherwise>
										<p>价格:&nbsp;&nbsp;&yen;&nbsp;${requestScope.foodDetail.price }</p>
									</c:otherwise>
								</c:choose>
					<p>简介:${requestScope.foodDetail.remark }</p>
				</div>
			</div>
			<div class="menu4">
				
				<a href="${basePath}put.action?foodId=${requestScope.foodDetail.id}" style="background:url(${basePath}app/detail/style/images/img/order_left_corner_bg.png);">放入餐车</a>
				<a href="javascript:history.go(-1);" onclick="# " style="background:url(${basePath}app/detail/style/images/img/order_right_corner_bg.png);">返回</a>
			</div>
		</div>
		
		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="${basePath}order.action">
							<img src="${basePath}app/detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>
					<c:forEach items="${requestScope.foodTypeList}" var="foodType">
						<li>
							<a href="${basePath}searchByType.action?keyword=${foodType.id}">${foodType.typeName}</a>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="${basePath}search.action" method="post">
					<table width="166px">
						<tr>
							<td>
								<input type="text" id="dish_name" name="keyword" class="select_value" /> 
								<input type="hidden" value="searchFood" name="method">
							</td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td>
								<a href="${basePath}app_list.action">
									<img src="${basePath}app/detail/style/images/look.gif" />
								</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
