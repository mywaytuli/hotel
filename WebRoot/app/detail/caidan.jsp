<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<%@include file="/app/detail/public/header.jsp" %>
	<link href="${basePath}app/detail/style/css/index.css" rel="stylesheet" type="text/css" />
	
	<script type="text/javascript">
		var list_url = "${basePath}app_list.action";
	</script>
</head>                                               
<body style="text-align: center">
	<div id="all">
		<form  id="form_page" action="" method="post">
		<div id="menu">
			<!-- 显示菜品的div -->
			<div id="top">
				<ul>
					<!-- 循环列出餐品 -->
					
					<c:forEach items="${requestScope.pageResult_food.items}" var="food">
					
						<li>
							<dl>
								<dt>
									<a href="${basePath}foodDetail.action?food.id=${food.id}">
										<img width="214px" height="145px" src="${basePath }upload/${food.img}" />
									</a>
								</dt>
								<dd class="f1">
									<a href="">${food.foodName}</a>
								</dd>
								<c:choose>
									<c:when test="${not empty info }">
										<dd class="f2">
											<a href="">&yen;${food.mprice}</a>
										</dd>
									</c:when>
									<c:otherwise>
										<dd class="f2">
											<a href="">&yen;${food.price}</a>
										</dd>
									</c:otherwise>
								</c:choose>
							</dl>
						</li>
					</c:forEach>
				</ul>
			</div>
			
			
			<!-- 底部分页导航条div -->
			<div id="foot">
				
						<span
							style="float:left; line-height:53PX; margin-left:-50px; font-weight:bold; ">
							<span style="font-weight:bold">&lt;&lt;</span>
						</span>
					
						<jsp:include page="/sys/public/pageresule.jsp"></jsp:include>
				
					
						<span style="float:right; line-height:53px; margin-right:10px;  ">
							<a
							href="#"
							style=" text-decoration:none;color:#000000; font-weight:bold">&gt;&gt;</a>
						</span>
					
					
				
			</div>
			
		</div>
		</form>
		<!-- 右边菜系列表，菜品搜索框  -->
		<div id="dish_class">
			<div id="dish_top">
				<ul>
				<li class="dish_num"></li>
					<li>
						<a href="${basePath }order.action">
							<img src="${basePath }app/detail/style/images/call2.gif" />
						</a>
					</li>
				</ul>                     
			</div>
                               
			<div id="dish_2">
				<ul>
					<c:forEach items="${requestScope.foodTypeList}" var="foodType">
						<li>
							<a href="${basePath }searchByType.action?keyword=${foodType.id}">${foodType.typeName}</a>
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
								<a href="${basePath }app_list.action">
									<img src="${basePath }app/detail/style/images/look.gif" />
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
