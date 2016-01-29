<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>帖子流水</title>
<link href="<c:url value="/resources/styles/admin/base.css" />"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<c:url value="/resources/js/calendar.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery_1.7.2.js"/>"></script>
</head>
<body class="frame_right">
	<div class="location">功能点击明细</div>

	<%-- 
<div class="location"> &#8250;&#8250; 评论流水  &nbsp;&nbsp;
    <a href="/admin/comment/index?pageNo=${formbean.pageNo}&startTime=${formbean.starttime}&endTime=${formbean.endtime}&bgUrl=${formbean.bgUrl}&valueType=${formbean.valueType}">评论最多</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="/admin/comment/index?pageNo=${formbean.pageNo}&startTime=${formbean.starttime}&endTime=${formbean.endtime}&bgUrl=${formbean.bgUrl}&valueType=${formbean.valueType}">赞最多</a>
</div>
--%>

	<div id="user_query" class="user_query">
		<form action="<%=basePath%>userlogs/clickFunctions.do" method="get"
			id="formbean">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<th>选择时间&nbsp;&nbsp; <label> 开始时间 <input
							name="startDate" id="startDate"
							onclick="fPopCalendar(event,this,this)" onfocus="this.select()"
							value="${startDate }" readonly="readonly" />
					</label> <label> 结束时间 <input id="endDate" name="endDate"
							onclick="fPopCalendar(event,this,this)" onfocus="this.select()"
							value="${endDate}" readonly="readonly" />
					</label> 项目：<select name="projectId">
							<option value="0" <c:if test="${projectId==0}">selected</c:if>>全部</option>
							<c:forEach items="${projects}" var="item" varStatus="vs">
								<option value="${item.projectId }"
									<c:if test="${projectId==item.projectId}">selected</c:if>>${item.projectName }</option>
							</c:forEach>
					</select><input id="ok" type="button" value="确定" /></th>
				</tr>
			</table>
		</form>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<!-- <th>选择</th> -->
				<th>时间段</th>
				<th>点击数</th>
				<th>百分比</th>
			</tr>
			<c:forEach items="${view.functionList}" var="item" varStatus="vs">
				<tr class="select">
					<!-- <td> <input type="checkbox" name="commentid" value="" /></td> -->
					<td>${item.functionName}</td>
					<td>${item.times}</td>
					<td>${item.percent}%</td>
				</tr>
			</c:forEach>
			<!-- 
	        		<tr >
		                <td colspan="11" style="text-align:center;">
		            		<input type="button" id="unallselect" value="全选/取消全选"/>
		            		<input type="submit" id="del_post" value="删除选中帖子"/>
		            	</td>
		            </tr>
		      -->

		</table>
		<%-- <%@ include file="/common/fenye.jsp" %> --%>
		<pager:page pageView="${pageView}" viewPages="15" />
	</div>
	<script type="text/javascript">
		var getDateStr = function(date) {
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			m = m < 10 ? "0" + m : m;
			var d = date.getDate();
			d = d < 10 ? "0" + d : d;
			var strDate = y + "-" + m + "-" + d;
			return strDate;
		};

		$(function() {

			$("#ok").click(function() {
				var startDate = $("#startDate").val();
				var endDate = $("#endDate").val();
				var date = new Date();
				var strDate = getDateStr(date);

				var yesterdyDate = new Date(date.getTime() - 86400000);
				var strYesterday = getDateStr(yesterdyDate);

				if (endDate > strDate) {
					alert("结束时间不能大于今天!");
					return;
				}

				if (strYesterday > strYesterday) {
					alert("开始时间不能大于昨天");
				}

				if (startDate > endDate) {
					alert("开始时间不能大于结束时间!");
					return;
				}
				$("#formbean").submit();
			});

		});
	</script>
</body>
</html>