<%@ taglib uri="http://www.workmate.com/pager" prefix="pager" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.workmate.com/workmodel" prefix="md" %> 
<%@ page isELIgnored="false" %>

<c:if test="${currentUser != null && currentUser.id == 9}">
	<c:set var="submitUserId" value="100665"></c:set>
</c:if>
<c:if test="${currentUser != null && currentUser.id == 12}">
	<c:set var="submitUserId" value="116037"></c:set>
</c:if>