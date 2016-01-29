<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/taglibs.jsp"%>
<script type="text/javascript">
<!--
function topage(page){
	var form = document.getElementById("formbean");
	form.pageNo.value=page;
	form.submit();
}
//-->
</script>
<div class="page">
	<font>共${pageView.totalpage}页/${pageView.totalrecord}条记录</font>
	<ul>
		<c:forEach begin="${pageView.pageindex.startindex}" end="${pageView.pageindex.endindex}" var="wp">
		    	<c:if test="${pageView.currentpage==wp}"><li><font>${wp}</font></li></c:if>
		    	<c:if test="${pageView.currentpage!=wp}"><li><a href="javascript:topage('${wp}')">${wp}</a></li></c:if>
		</c:forEach>
	</ul>
</div>
