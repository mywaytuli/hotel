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
			<img border="0" width="13" height="13" src="${basePath}sys/style/images/title_arrow.gif"/> 餐桌列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


<!-- 过滤条件 -->
<div id="QueryArea">
	<form action="${basePath}sys/dinnertable_search" method="post">
		<input type="hidden" name="method" value="search">
		<input type="text" name="keyword" title="请输入餐桌名称">
		<input type="submit" value="搜索">
	</form>
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
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        	<c:choose>
        		<c:when test="${not empty requestScope.pageResult.items }">
        			<c:forEach var="table" items="${requestScope.pageResult.items }" varStatus="dt">
        				<tr align="center">
        					<td>${dt.count }</td>
        					<td>${table.tableName }</td>
							<td align="center">
							<a href="${basePath}sys/tableDetail_list.action?dinnerTable.id=${table.id}" class="FunctionButton">明细</a>
							<a href="${basePath}sys/dinnertable_middle.action?dinnerTable.id=${table.id}" class="FunctionButton">预定</a>
							<a href="${basePath}sys/dinnertable_delete.action?dinnerTable.id=${table.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
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
		<div class="FunctionButton"><a href="${basePath}sys/dinnertable/dinnertable_save.jsp">添加</a></div>
		<jsp:include page="/sys/public/pageresule.jsp"/>
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
