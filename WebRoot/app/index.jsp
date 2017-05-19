<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	<%@include file="/app/detail/public/header.jsp" %>
	
	
<title>无线点餐平台</title>



	<style type="text/css">
	* {
		margin: 0px;
		padding: 0px
	}
	#dish_2 a{
		text-decoration:none;
		font-size:36px;
		color:#000;
	}
	#dish_2 ul { 
		list-style:none;
	} 
	#dish_2 li{
		background:url(style/images/img/btn.gif);
		width:164px;
		height:47px;
		text-align:center;
		padding-top:5px;
	}
	</style>
</head>
<body style="text-align: center">
	<!--外部的大层-->
	<div class="index_all" style="text-align:center;">
		<!--上面的背景层-->
		<div>
			<img src="${basePath}app/detail/style/images/flower.gif" />
		</div>
		<!--中间层-->
		<div id="index_center">
			<!--中间层的空白层-->
			<div id="space">
			
			</div>
			<!--中间层的菜单层-->
			<div>
				<!--菜单层的左边-->
				<div id="index_centerleft"></div>
				<!--菜单层的中间-->
				<div class="bg_middle">
					<img
						src="${basePath}app/detail/style/images/index_menu.gif"
						border="0" usemap="#Map" />
					<map name="Map" id="Map">
						<area shape="rect" coords="164,99,354,199" href="#" />
					</map>
				</div>
				<!--中间层的右边-->
				<div id="index_centerright"></div>
			</div>

			<!--放桌子的层-->
			<div id="center_bottom">
				<ul style=" display:inline-table" id="ulli">
					<c:choose>
					<c:when test="${not empty requestScope.dinnerTableList}">
						<c:forEach items="${requestScope.dinnerTableList }" var="table">
							<li>
								<a href="${basePath }app_list.action?dinnerTable.id=${table.id}">
									${table.tableName}
								</a>
							</li>
						</c:forEach>
					</c:when>	
					<c:otherwise>
					</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
		
		<!--下面的背景层-->
		<div>
			<img src="${basePath}app/detail/style/images/flower.gif" />
		</div>
	</div>
	
	
</body>
</html>