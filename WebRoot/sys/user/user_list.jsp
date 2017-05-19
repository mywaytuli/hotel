<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<!-- 包含公共的JSP代码片段 -->
	
<title>无线点餐平台</title>

<%@include file="/sys/public/header.jsp"%>
	
	<script type="text/javascript">
		var list_url = "${basePath}sys/user_list.action";
	</script>
<body>
<!-- 页面标题 -->
<div id="TitleArea">
	<div id="TitleArea_Head"></div>
	<div id="TitleArea_Title">
		<div id="TitleArea_Title_Content">
			<img border="0" width="13" height="13" src="${basePath }sys/style/images/title_arrow.gif"/> 用户列表
		</div>
    </div>
	<div id="TitleArea_End"></div>
</div>


	<!-- 过滤条件 -->
	<div id="QueryArea">
		<form action="${basePath }sys/user_search.action" method="post">
			<input type="text" name="keyword" title="请输入会员名称" value="">
			<input type="submit" value="搜索">
		</form>
		<input type="button" value="导出" class="s_button" onclick="doExportExcel()"/>
	</div>
<form  id="form_page" action="" method="post" >
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <table class="MainArea_Content"  cellspacing="0" cellpadding="0">
        <!-- 表头-->
        <thead>
            <tr align="center" valign="middle" id="TableTitle">
				<td>编号</td>
				<td>姓名</td>
				<td>角色</td>
				<td>手机号码</td>
                <td>地址</td>
				<td>操作</td>
			</tr>
		</thead>	
		<!--显示数据列表 -->
        <tbody id="TableData">
        
        	<c:choose>
        		<c:when test="${not empty requestScope.pageResult.items }">
        			<c:forEach var="user" items="${requestScope.pageResult.items }" varStatus="u">
        				<tr align="center">
        					<td>${u.count }</td>
        					<td>${user.userName }</td>
        					<td>${ user.role}</td>
        					<td>${ user.mobile}</td>
        					<td>${user.address}</td>
        					<td align="center">
        						<a href="${basePath }sys/user_order.action?userId=${user.id}"  class="FunctionButton">订单</a>	
								<a href="${basePath }sys/user_delete?user.id=${user.id}" onClick="return delConfirm();"class="FunctionButton">删除</a>				
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
<script type="text/javascript">
	$("table tr").mouseover(function(){
 		$(this).css("background-color","#FAEBD7");
	});
	$("table tr").mouseout(function(){
 		$(this).css("background-color","white");
	});
	
	//导出用户列表
    function doExportExcel(){
      	window.open("${basePath}sys/user_exportExcel.action");
    }
</script>


</body>
</html>
