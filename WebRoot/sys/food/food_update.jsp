﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
   <!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>



<%@include file="/sys/public/header.jsp"%>
<script type="text/javascript" src="../style/js/jquery-1.8.2.min.js"></script></head>
<body>

<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			
				
					<img border="0" width="13" height="13" src="${basePath}sys/style/images/title_arrow.gif"/> 更新新菜品
				
				
			
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>

<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
	<!-- 表单内容 -->
	<form action="${basePath}sys/food_update.action" method="post" enctype="multipart/form-data">
		<!-- 本段标题（分段标题） -->
		<div class="ItemBlock_Title">
        	<img width="4" height="7" border="0" src="${basePath}sys/style/images/item_point.gif"> 菜品信息&nbsp;
        </div>
		<!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
				<div class="ItemBlock2">
					<table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
							<td width="80px">菜系</td>
							<td>
			   				<select id="foodsel" name="cid" style="width:80px">
			   					<option>${food.foodType.typeName }</option>
	                            <c:forEach  var="type" items="${foodTypeList}" >
	                            	<c:if test="${food.foodType.id!=type.id }">
			   							<option value="${type.id}">${type.typeName }</option>
			   						</c:if>
			   					</c:forEach>	
			   						
                            </select>
                            <input type="hidden" id="hid" name="typeId" value="${food.foodType.id}" />
                            <input type="hidden"  name="food.id" value="${food.id}" />
                            </td>
						</tr>
						<tr>
							<td width="80px">菜名</td>
							<td><input type="text" name="food.foodName" class="InputStyle" value="${food.foodName}"/> *</td>
						</tr>
						<tr>
							<td>价格</td>
							<td><input type="text" name="food.price" class="InputStyle" value="${food.price}"/> *</td>
						</tr>
                        <tr>
							<td>会员价格</td>
							<td><input type="text" name="food.mprice" class="InputStyle" value="${food.mprice}"/> *</td>
						</tr>
						
						<tr>
							<td>简介</td>
							<td><textarea name="food.remark" class="TextareaStyle">${food.remark}</textarea></td>
						</tr>
						<tr>
							<td width="80px">菜品图片</td>
							<td>
								
									<img style='max-width:68px;width:68px;width:expression(width>68?"68px":width "px");max-width: 68px;' 
									src="${basePath }upload/${food.img}">
									<input type="hidden" name="food.img" value="${ food.img}">
								
								<input type="file" name="img"/> *
							</td>
						</tr>
					</table>
				</div>
            </div>
        </div>
		
		
		<!-- 表单操作 -->
		<div id="InputDetailBar">
            
				
					 <input type="submit" value="修改" class="FunctionButtonInput">
				
				
			
            
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
	</form>
</div>

<script type="text/javascript">
	
		$("#foodsel").change(function(){
			$("#hid").val($(this).val());
		});
</script>

</body>
</html>