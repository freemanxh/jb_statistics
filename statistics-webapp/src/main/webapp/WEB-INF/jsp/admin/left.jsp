<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>导航</title>
    <link href="<c:url value="/resources/styles/admin/base.css" />" rel="stylesheet" type="text/css"/>
</head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<body class="frame_left">
<div class="nav">
    <%-- <c:forEach items="${channels}" var="channel"> --%>
<%--         <c:set var="nodes" value="${md:nodes(channel.id, currentUser.nodes)}"/>
        <c:if test="${not empty nodes}"> --%>
            <dl>
<%--                 <dt>${channel.name}</dt>
                <c:forEach items="${nodes}" var="item">
                    <dd><a href="${item.url}" target="mainFrame">${item.name}</a></dd>
                </c:forEach> --%>
                
 <dt>用户统计</dt>
                    <dd><a href="<%=basePath%>userlogs/click.do" target="mainFrame">用户点击</a></dd>
                    <dd><a href="<%=basePath%>userlogs/clickFunctions.do" target="mainFrame">功能点点击</a></dd>
                    <dd><a href="<%=basePath%>userlogs/newUsers.do" target="mainFrame">新增用户</a></dd>
            </dl>
<%--         </c:if>
    </c:forEach> --%>
</div>
</body>
</html>
