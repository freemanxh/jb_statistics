<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<%
	response.setHeader("Pragma","No-cache");    
	response.setHeader("Cache-Control","no-cache");    
	response.setDateHeader("Expires", -10);   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>圈子流水</title>
<link href="<c:url value="/resources/styles/admin/base.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/styles/jquery-ui.css"/>" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
<script type="text/javascript" src="<c:url value="/resources/js/calendar.js"/>"></script>

</head>
<body class="frame_right">
	信息:${msg}<br/>
</body>
</html>