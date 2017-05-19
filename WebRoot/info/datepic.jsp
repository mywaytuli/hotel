<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>选择就餐时间</title>
   	<script type="text/javascript" src="${basePath }js/datepicker/WdatePicker.js"></script>
	 <script type="text/javascript" src="${basePath }js/jquery-1.8.2.min.js"></script>
  </head>
  
  <body style="background-image:url(${basePath}images/6-1003291913490.jpg);background-position:center; background-repeat:repeat-y">
  <div>
  	<img src="${basePath}images/login/form_03.png"   width="332" height="47" style="margin-top: 0px;margin-left: 0px"/>
 </div>
 <%@include file="/app/detail/public/info.jsp" %>
	<form action="${basePath }app_showTable.action" method="post" style="margin-top: 150px;margin-left: 200px">
		<table>
			<tr>
				<td class="tdBg" width="200px" style="width: 100px">就餐时间：</td>
            	<td><input type="text" id="eatDate" name="eatTime1" readonly="true" onfocus="WdatePicker({'skin':'whyGreen','dateFmt':'yyyy-MM-dd'});" /></td>
            	<td>
            		<input type="radio" value="中午" name="eatTime2" checked="checked"/>中午
            		<input type="radio" value="晚上" name="eatTime2"/>晚上
            	</td>
			</tr>
		</table>
		<div style="height: 30px"></div>
		<div class="tc mt20" style="height: 100px">
    	<a href="javascript:doSubmit()" style="text-decoration: none;color: black;font-size: 20">确定</a>
   		 </div>
	</form>
	<script type="text/javascript">
    
    	function doSubmit(){
    		if($("#eatDate").val!=""){
    			document.forms[0].submit();
    		}else{
    			alert("请选择日期");
    		}
    	}
    	
    </script>
  </body>
</html>
