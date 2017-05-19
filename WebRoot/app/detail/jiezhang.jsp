<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
	<%@include file="/app/detail/public/otherheader.jsp" %>
<script>alert('尊敬的顾客,您好!已经通知服务员结账，请稍等!');window.location.href='${pageContext.request.contextPath}/order?method=call'</script>