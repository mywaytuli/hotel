<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>修改密码信息</title>
	 <script type="text/javascript" src="${basePath }js/jquery-1.8.2.min.js"></script>
  </head>
  
  <body style="background-image:url(${basePath}images/6-1003291913490.jpg);background-position:center; background-repeat:repeat-y">
  <div>
  	<img src="${basePath}images/login/form_03.png"   width="332" height="47" style="margin-top: 0px;margin-left: 0px"/>
         
 </div>
 <div>
<form id="form" name="form" style="margin-left: 150px;margin-top: 150px" action="${basePath }modifyInfo_2.action" method="post" enctype="multipart/form-data">
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0" " >
        <tr>
            <td class="tdBg" width="100px" height="50px">输入旧密码：</td>
            <td width="100px"><input type="password" id="password" name="password"/></td>
            <td id="td2" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">输入新密码：</td>
            <td><input type="password" id="pwd1" name="pwd1"/></td>
            <td id="td3" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">确认新密码：</td>
            <td><input type="password" id="pwd" name="user.pwd"/></td>
            <td id="td4" style="color: red"></td>
        </tr>
    </table>
    <div class="tc mt20" >
        <a href="javascript:doSubmit()" style="text-decoration: none;color: black;font-size: 20">修改</a>
    </div>
    </div>
</form>
<script type="text/javascript">
    
    	$("#password").blur(function(){
    		if($("#password").val()==""){
    			$("#td2").text("密码不能为空！");
    		}else{
    			$.ajax( {
					type    : "POST",
					url     : "${basePath}doModifyInfo_2.action?date="+new Date().getTime(),
					data	:{"user.pwd":$("#password").val()},
					dataType:"json",
					success : function(data){
								
						if(data.msg){
							$("#td2").text("密码错误，请重新输入！");
					    	}else{
					    		$("#td2").text("");
					    	}
	    				},
	    				
				});
    		}
    	})
    
    	$("#pwd1").blur(function(){
    		if($("#pwd1").val()==""){
    			$("#td3").text("密码不能为空！");
    		}else{
    			$("#td3").text("");
    		}
    	})
    	
    	$("#pwd").blur(function(){
    		if($("#pwd").val()==""){
    			$("#td4").text("密码不能为空！");
    		}else{
    			if($("#pwd").val()!=$("#pwd1").val()){
    				$("#td4").text("两次密码不一致！");
    			}else{
    				$("#td4").text("");
    			}
    		}
    	})	
    	
    	function doSubmit(){
    		if($("#td2").text()==""&&$("#td3").text()==""&&$("#td4").text()==""){
    			document.forms[0].submit();
    		}
    	}
    	
    </script>
  </body>
</html>
