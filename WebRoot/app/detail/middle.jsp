<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>支付成功</title>
  </head>
  <body onload="returnUrlByTime()">
    <div style="margin-top: 270px;margin-left: 200px">
	    <h3>${requestScope.paySuccess }</h3>  
	    <b><span id="layer">3</span>&nbsp;秒后，跳转到首页。</b>  
    </div>
    <%  
        //转向语句  
        response.setHeader("Refresh", "3;URL=info/datepic.jsp");  
    %>  
  </body>
  <script type="text/javascript">  
    var time = 4;  
  
    function returnUrlByTime() {  
  
        window.setTimeout('returnUrlByTime()', 1000);  
  
        time = time - 1;  
  
        document.getElementById("layer").innerHTML = time;  
    }  
</script>  
</html>