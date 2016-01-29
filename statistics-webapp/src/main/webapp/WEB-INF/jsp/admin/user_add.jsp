<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>添加或修改管理帐号</title>
    <link href="<c:url value="/resources/styles/admin/base.css" />" rel="stylesheet" type="text/css"/>
</head>
<body class="frame_right">
<div class="location">账号与权限管理 &#8250;&#8250; 添加或修改管理帐号</div>
<div class="user_query">
    <form:form action="/admin/manageuser/save"  modelAttribute="manageUser"  method="post">
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
                <td>用户名：
                    <form:input path="username" type="text" size="30" />
                </td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;&nbsp;码：
                    <form:password path="password" value="${manageUser.password }" size="30" />
                </td>
            </tr>
            <c:forEach items="${channels}" var="channel">
                <c:set var="nodes" value="${md:cnodes(channel.id)}"/>
                <c:if test="${not empty nodes}">
                    <tr>
                        <td><b>${channel.name}</b></td>
                    </tr>
                    <tr>
                        <td>
                            <c:forEach items="${nodes}" var="node">
                                <label> <form:checkbox path="nodeArray"  value="${node.id }" />${node.name}</label>
                            </c:forEach>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </table>
        <div class="user_query_btn">
        	<form:hidden path="id" />
            <form:input path="" type="submit" id="button" value="保存"/>
        </div>
    </form:form>
</div>
</body>
</html>
