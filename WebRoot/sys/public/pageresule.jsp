<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="s" uri="/struts-tags" %>

总共${ requestScope.pageResult.totalCount}条记录
		当前${requestScope.pageResult.pageNo }/${requestScope.pageResult.totalPageCount }页     &nbsp;&nbsp;
		<c:if test="${requestScope.pageResult.pageNo > 1}">
			<a href="javascript:doGoPage(${requestScope.pageResult.pageNo - 1})">上一页 </a>
		</c:if>
		<c:if test="${requestScope.pageResult.pageNo < requestScope.pageResult.totalPageCount}">
			<a href="javascript:doGoPage(${requestScope.pageResult.pageNo + 1})">下一页 </a>
		</c:if>
		
			到&nbsp;<input id="pageNo" name="pageNo" type="text" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="${requestScope.pageResult.totalPageCount }" value="${requestScope.pageResult.pageNo}" /> &nbsp;&nbsp;
		
<script type="text/javascript">
		
		//翻页
		function doGoPage(pageNo){
			$("#pageNo").val(pageNo);
			$("#form_page").action=list_url;
			$("#form_page").submit();
		}
</script>