<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>信息</title>
	 <script type="text/javascript" src="${basePath }js/jquery-1.8.2.min.js"></script>
  </head>
  
  <body style="background-image:url(${basePath}images/6-1003291913490.jpg);background-position:center; background-repeat:repeat-y">
  <div>
  	<img src="${basePath}images/login/form_03.png"   width="332" height="47" style="margin-top: 0px;margin-left: 0px"/>
         
 </div>
<div  style="margin-top: 150px;margin-left: 200px;float: left;">
	<div style="height: 50px"><a href="javascript:doModifyInfo_1()" style="text-decoration: none;color: black;font-size: 25">修改基本信息</a></div>
	<div style="height: 50px"><a href="javascript:doModifyInfo_2()" style="text-decoration: none;color: black;font-size: 25">修改密码</a></div>
	<div style="height: 50px"><a href="javascript:doModifyInfo_3()" style="text-decoration: none;color: black;font-size: 25">查看订单</a></div>
</div>
<div style="margin-top: 200px;margin-left: 400px"></div>
<script type="text/javascript">
		
		function doModifyInfo_1(){
			window.open("${basePath}doModifyInfo_1.action");
		}
		
		function doModifyInfo_2(){
			window.open("${basePath}info/doModifyInfo_2.jsp");
		}
		
		function doModifyInfo_3(){
			window.open("${basePath}doModifyInfo_3.action");
		}
		
</script>
  </body>
</html>
