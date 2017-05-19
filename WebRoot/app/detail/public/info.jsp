<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty info }">
	<div style="margin-left: 20px; width: 410px" >
	<p style="font-size: 15;color: black">您好，${info.userName }&nbsp;&nbsp;
	<a href="${basePath }exit.action" style="text-decoration: none;color: red;font-size: 15">退出</a>&nbsp;&nbsp;
	<a href="javascript:doModifyInfo()" style="text-decoration: none;color: red;font-size: 15">修改信息 </a>
	</p>
	</div>
</c:if>	


<script type="text/javascript">
		
		function doModifyInfo(){
			window.open("${basePath}info/information.jsp");
		}
</script>