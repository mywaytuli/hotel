<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
   <%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
	%>
    <title>用户注册</title>
    <script type="text/javascript" src="${basePath }js/jquery-1.8.2.min.js"></script>
    
    
   
</head>
<body style="background-image:url(${basePath}images/6-1003291913490.jpg);background-position:center; background-repeat:repeat-y">
  <div>
  	<img src="${basePath}images/login/form_03.png"   width="332" height="47" style="margin-top: 0px;margin-left: 0px"/>
         
 </div>
<div  style="margin-top: 100px;margin-left: 200px">
	
<form id="form" name="form" action="${basePath }register.action" method="post" enctype="multipart/form-data">
    
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0" " >
        
        <tr>
            <td class="tdBg" width="100px" height="50px">姓名：</td>
            <td width="100px"><input type="text" id="name" name="user.userName"/></td>
            <td id="td1" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">帐号：</td>
            <td width="100px"><input type="text" id="account" name="user.account"/></td>
            <td id="td2" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">密码：</td>
            <td><input type="password" id="password" name="password"/></td>
            <td id="td3" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">确认密码：</td>
            <td><input type="password" id="pwd" name="user.pwd"/></td>
            <td id="td4" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px"> 手机：</td>
            <td><input type="text" id="mobile" name="user.mobile"/></td>
            <td id="td5" style="color: red"></td>
        </tr>
        <tr>
            <td class="tdBg" width="100px" height="50px">地址：</td>
            <td><input type="text" id="address" name="user.address"/></td>
            <td id="td6" style="color: red"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="hidden" id="role" name="user.role" value="会员"/></td>
        </tr>
       
    </table>
    <div class="tc mt20" >
        <input type="button" class="btnB2" value="注册" onclick="doSubmit()" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
   </form>
  </div>
<script type="text/javascript">
    
    	
    	$("#name").blur(function(){
    		if($("#name").val()==""){
    			$("#td1").text("用户名不能为空！");
    		}else{
    			$("#td1").text("");
    		}
    	})
    	
    	$("#account").blur(function(){
    		if($("#account").val()==""){
    			$("#td2").text("账号不能为空！");
    		}else{
    			$.ajax( {
					type    : "POST",
					url     : "${basePath}reg_account.action?date="+new Date().getTime(),
					data	:{"user.account":$("#account").val()},
					dataType:"json",
					success : function(data){
								
						if(data.msg){
							$("#td2").text("账号已被注册，请更换！");
					    	}else{
					    		$("#td2").text("");
					    	}
	    				},
	    				
				});
    		}
    	})
    	
    	$("#password").blur(function(){
    		if($("#password").val()==""){
    			$("#td3").text("密码不能为空！");
    		}else{
    			$("#td3").text("");
    		}
    	})
    	
    	$("#pwd").blur(function(){
    		if($("#pwd").val()==""){
    			$("#td4").text("密码不能为空！");
    		}else{
    			if($("#pwd").val()!=$("#password").val()){
    				$("#td4").text("两次密码不一致！");
    			}else{
    				$("#td4").text("");
    			}
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
    		if($("#td1").text()==""&&$("#td2").text()==""&&$("#td3").text()==""&&$("#td4").text()==""&&$("#td5").text()==""&&$("#td6").text()==""){
    			document.forms[0].submit();
    		}
    	}
    	
    </script>
</body>

</html>