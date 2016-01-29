<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>评论页详情</title>
<link href="<c:url value="/resources/styles/admin/base.css" />" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<c:url value="/resources/js/jquery_1.7.2.js"/>"></script>
</head>
<body class="frame_right">
<div class="location">客服中心 &#8250;&#8250; 评论流水 &#8250;&#8250; 评论修改</div>
<div class="user_query">
  <form action="/admin/comment/save" method="post" id="addfrm" name="addfrm">
    <input type="hidden" name="id"  value="${comment.id }"/>
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
    	<tr>
        <th width="140">帖子作者</th>
        <td><label>
            <input type="text" value="${post.ownerId }" readonly="readonly"  size="40" maxlength="20" />
          </label>
        </td>
      </tr>
      <tr>
        <th width="140">帖子内容</th>
        <td><label>
            <input type="text" value="${post.content }" readonly="readonly"  size="40" maxlength="20" />
          </label>
        </td>
      </tr>
      <tr>
        <th>评论作者</th>
        <td><label>
            <input type="text" name="shortName" value="${comment.userid }"  size="40" maxlength="20" />
          </label>
        </td>
      </tr>
      <tr>
        <th>评论内容</th>
        <td><textarea rows="5" cols="36" name="content" >${comment.content}</textarea></td>
      </tr>
      <tr>
        <th>真实赞数量</th>
        <td><input type="text" disabled="disabled" value="${comment.countPraise}"  size="40" maxlength="20" /></td>
      </tr>
      <tr>
        <th>新加赞数量</th>
        <td><input type="text" name="praiseInitValue" value="${comment.praiseInitValue}"  size="40" maxlength="20" /></td>
      </tr>
      
    </table>
     <%-- <input type="hidden" name="url" value="${url }"></input> --%>
    <input type="button" name="button2" class="sub" id="sub" value="提交" />
  </form>
</div>
<script type="text/javascript">
$(function() {
	$("#sub").click(function(){
		var $frm = $("#addfrm");
		$.post("/admin/comment/save", $frm.serialize(), function(data) {
			if(data.result == 'success') {
				window.location.href = document.referrer;
			} else {
				alert("更新失败！");					
			}
		}, "json");
	});
});
</script>
</body>
</html>