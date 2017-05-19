<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/1999/REC-html401-19991224/loose.dtd">
<html>
<head>
 	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>
<%@include file="/sys/public/header.jsp"%>
</head>
	<script type="text/javascript">
		var list_url = "${basePath}sys/dinnertable_list";
	</script>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${basePath}sys/style/images/title_arrow.gif"/> 餐桌明细列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>




<!-- 主内容区域（数据列表或表单显示） -->
<form  id="form_page" action="" method="post">
<div id="MainArea">
    <table class="MainArea_Content"   cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>桌名</td>
				<td>就餐时间</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        	<c:choose>
        		<c:when test="${not empty requestScope.tableDetailList }">
        			<c:forEach var="detail" items="${requestScope.tableDetailList }" varStatus="td">
        				<tr align="center">
        					<td>${td.count }</td>
        					<td>${detail.dinnerTable.tableName }</td>
        					<td>${detail.eatDate }</td>
							<td>
							<a href="${basePath}sys/tableDetail_delete.action?tableDetail.id=${detail.id}" onClick="return delConfirm();"class="FunctionButton">退桌</a>				
							</td>
						</tr>        			
        			</c:forEach>
        		</c:when>
        		<c:otherwise>
        			<tr>
        				<td colspan="3">没有你要找找的数据，请先保存记录再查看！</td>
        			</tr>
        		</c:otherwise>
        	</c:choose>
        	
			
        </tbody>
    </table>
	
   <!-- 其他功能超链接 -->
	<div id="TableTail" align="center">
		<div class="FunctionButton"></div>
    </div> 
</div>
</form>

<script type="text/javascript">
	$("table tr").mouseover(function(){
 		$(this).css("background-color","#FAEBD7");
	});
	$("table tr").mouseout(function(){
 		$(this).css("background-color","white");
	});
</script>
</body>
</html>
