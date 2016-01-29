<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@include file="/common/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>功能版块管理</title>
<link href="<c:url value="/resources/styles/admin/base.css" />" rel="stylesheet" type="text/css" />
</head>
<body class="frame_right">
<div class="location">账号与权限管理 &#8250;&#8250; 功能版块管理 <a href="/admin/managechannel/add">添加功能版块</a></div>
<div class="user_query">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <th>ID</th>
        <th>版块名称</th>
        <th>管理</th>
      </tr>
     <c:forEach items="${channels}" var="item">
	      <tr>
	        <td>${item.id}</td>
	        <td>${item.name}</td>
	        <td><a href="/admin/managenode/edit?id=${item.id }">【修改】</a></td>
	      </tr>
     </c:forEach>
    </table>
</div>
</body>
</html>
