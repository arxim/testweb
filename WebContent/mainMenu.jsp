<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	<jsp:include page="resources/template/modalLoginMessage.jsp"></jsp:include>
	<script type="text/javascript">
		var ctx = '${pageContext.request.contextPath}';
	</script>
	<script type="text/javascript" src="resources/js/pages/logout.js"></script>
<title>Main menu</title>
</head>
<body class="bg-info">
	<c:if test="${empty sessionScope.userLogin}">
		<c:redirect url = "/"/>
	</c:if>
	<div class="container" style="margin-top:10%; margin-bottom:12%;">
	<div class="col-xs-12 col-sm-12 text-center">
	<h2>Welcome : ${sessionScope.userLogin}</h2>
	<button type="button" class="btn btn-primary btn-block btn-lg" id="btnLogout" onclick="logoutUser();">Logout</button>
	</div>
	</div> 
</body>
</html>