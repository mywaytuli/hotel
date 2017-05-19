<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@include file="/app/detail/public/otherheader.jsp" %>
<link rel="stylesheet" type="text/css"
	href="${basePath }app/detail/style/css/index.css" />

</head>

<body style="text-align: center">
	<div id="all">
		<div id="menu">
			<!-- 餐车div -->
			<div id="count">
				<table align="center" width="100%">
					<tr height="40">
						<td align="center" width="20%">菜名</td>
						<td align="center" width="20%">单价</td>
						<td align="center" width="20%">数量</td>
						<td align="center" width="20%">小计</td>
					</tr>
					<c:choose>
					<c:when test="${not empty requestScope.orderDetailList}">
					<c:forEach items="${requestScope.orderDetailList}" var="od">
						<c:choose>
							<c:when test="${not empty info }">
								<tr height="60">
							 		<td align="center" width="20%">${od.food.foodName }</td>
							 		<td align="center" width="20%">￥${od.food.mprice }</td>
							 		<td align="center" width="20%">${od.foodCount}</td>
							 		<td align="center" width="20%">${od.food.mprice*od.foodCount}</td>
				 				</tr>
				 				<c:set var="sum" value="${sum+od.food.mprice*od.foodCount}"></c:set>
							</c:when>
							<c:otherwise>
								<tr height="60">
							 		<td align="center" width="20%">${od.food.foodName }</td>
							 		<td align="center" width="20%">￥${od.food.price }</td>
							 		<td align="center" width="20%">${od.foodCount}</td>
							 		<td align="center" width="20%">${od.food.price*od.foodCount}</td>
						 		</tr>
				 				<c:set var="sum" value="${sum+od.food.price*od.foodCount}"></c:set>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="4">您还没下单！</td></tr>
					</c:otherwise>
					</c:choose>
					<tr>
						<td colspan="6" align="right">总计: <span
							style="font-size:36px;">&yen;&nbsp;<c:out value="${sum }"></c:out></span>
							<label id="counter" style="font-size:36px"></label>
						</td>
					</tr>
					<tr>
						<td colspan="6" style="margin-left: 100px; text-align: center;"
							align="right"><input type="hidden" name="bId" value="">
							<input type="button" value="结账" class="btn_next" lang=""
							onclick="pay()" /></td>
					</tr>
				</table>
			</div>
		</div>

		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
					<li class="dish_num"></li>
					<li><a
						href="${basePath }order.action">
							<img
							src="${basePath }app/detail/style/images/call2.gif" />
					</a></li>
				</ul>
			</div>

			<div id="dish_2">
				<ul>

					<c:forEach items="${requestScope.foodTypeList}" var="foodType">
						<li><a
							href="${basePath }searchByType.action?keyword=${foodType.id}">${foodType.typeName}</a>
						</li>
					</c:forEach>

				</ul>
			</div>
			<div id="dish_3">
				<!-- 搜索菜品表单  -->
				<form action="${basePath}search.action"
					method="post">
					<table width="166px">
						<tr>
							<td><input type="text" id="dish_name" name="keyword"
								class="select_value" /> <input type="hidden" value="searchFood"
								name="method"></td>
						</tr>
						<tr>
							<td><input type="submit" id="sub" value="" /></td>
						</tr>
						<tr>
							<td><a
								href="${basePath }app_list.action">
									<img
									src="${basePath }app/detail/style/images/look.gif" />
							</a></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</div>
	
	<script type="text/javascript">
	
	function pay() {
		window.location.href = "${basePath}pay.action?money=${sum}";
	}
</script>
</body>
</html>
