<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>后台管理</title> 
    <link href="<%=basePath %>/resources/styles/admin/base.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath %>/resources/styles/admin/base.css" rel="stylesheet" type="text/css"/>
</head>
<frameset cols="200,*" style="">
    <frame frameborder="0"  src="<%=basePath %>/admin/index/left.do" name="leftFrame" scrolling="auto" noresize="noresize" id="leftFrame" title="leftFrame"
           scrolling="auto"/>
    <frame frameborder="0"  src="<%=basePath %>/admin/index/center.do" name="mainFrame" id="mainFrame" title="mainFrame" scrolling="auto"/>
</frameset>
<frameset>
	<noframes>
	<body></body>
	</noframes>
</frameset>
</html>