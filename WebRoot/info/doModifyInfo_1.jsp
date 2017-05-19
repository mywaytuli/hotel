<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>修改基本信息</title>
	 <script type="text/javascript" src="${basePath }js/jquery-1.8.2.min.js"></script>
  </head>
  
  <body style="background-image:url(${basePath}images/6-1003291913490.jpg);background-position:center; background-repeat:repeat-y">
  <div>
  	<img src="${basePath}images/login/form_03.png"   width="332" height="47" style="margin-top: 0px;margin-left: 0px"/>
         
 </div>
<form id="form" name="form" style="margin-left: 150px;margin-top: 150px" action="${basePath }modifyInfo_1.action" method="post" enctype="multipart/form-data">
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0" " >
        
        <tr>
            <td class="tdBg" width="100px" height="50px">姓名：</td>
            <td width="100px"><input type="text" id="name" name="user.userName" value="${doModifyInfo_1.userName }"/></td>
            <td id="td1" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px"> 手机：</td>
            <td><input type="text" id="mobile" name="user.mobile" value="${doModifyInfo_1.mobile }"/></td>
            <td id="td5" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">地址：</td>
            <td><input type="text" id="address" name="user.address" value="${doModifyInfo_1.address}"/></td>
            <td id="td6" style="color: red"></td>
        </tr>
        
    </table>
    <div class="tc mt20" style="height: 100px">
    	<a href="javascript:doSubmit()" style="text-decoration: none;color: black;font-size: 20">修改</a>
    </div>
</form>
<script type="text/javascript">
    
    	
    	$("#name").blur(function(){
    		if($("#name").val()==""){
    			$("#td1").text("用户名不能为空！");
    		}else{
    			$("#td1").text("");
    		}
    	})
    	
    	$("#mobile").blur(function(){
    		if($("#mobile").val()==""){
    			$("#td5").text("手机号不能为空！");
    		}else{
    			$("#td5").text("");
    		}
    	})
    	
    	$("#address").blur(function(){
    		if($("#address").val()==""){
    			$("#td6").text("地址不能为空！");
    		}else{
    			$("#td6").text("");
    		}
    	})
    	
    	function doSubmit(){
    		if($("#td1").text()==""&&$("#td5").text()==""&&$("#td6").text()==""){
    			document.forms[0].submit();
    		}
    	}
    	
    </script>
  </body>
</html>
