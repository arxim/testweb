<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
	
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	
	<script type="text/javascript">
		var ctx = '${pageContext.request.contextPath}';
		var msgTimeout = '${sessionScope.msgTimeout}';
	</script>
	<script type="text/javascript" src="resources/js/pages/mainMenu/mainMenu.js"></script>
	<title>Main menu</title>
</head>
<body class="bg-info">
	<form id="frmMainMenu" method="post">
		<c:if test="${empty sessionScope.userLogin}">
			<c:redirect url="/" />
		</c:if>
		<div class="container" style="margin-top: 10%; margin-bottom: 12%;">
			<div class="col-xs-12 col-sm-12 text-center">
				<h2>Welcome : ${sessionScope.userLogin}</h2>
				<br>
				<br>
				<div class="col-xs-12 col-sm-offset-5 col-sm-2 text-center">
					<button type="submit" class="btn btn-primary btn-block btn-lg"
						id="btnLogout" formaction="/testweb/LogoutSrvl">Logout</button>
				</div>
			</div>
			<br>
			<div class="col-xs-12 col-sm-4  text-center">
				<button type="submit" class="btn btn-primary btn-block btn-lg"
					id="btnRequest" formaction="/testweb/RequestSrvl">request</button>
			</div>
			<div class="col-xs-12 col-sm-4  text-center">
				<button type="submit" class="btn btn-primary btn-block btn-lg"
					id="btnLogout">approve</button>
			</div>
			<div class="col-xs-12 col-sm-4  text-center">
				<button type="submit" class="btn btn-primary btn-block btn-lg"
					id="btnLogout">report</button>
			</div>
		</div>
	</form>
	<c:if test="${not empty sessionScope.msgTimeout}">
		<div class="modal fade" id="msg-modal" role="dialog">
			<div class="modal-dialog modal-sm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title text-center">
							<b>Password !!!</b>
						</h3>
					</div>
					<div class="modal-body">
						<p>${sessionScope.msgTimeout}</p>
					</div>
					<div class="modal-footer bg-info">
						<button type="button" class="btn btn-default" id="close-msg-modal" data-dismiss="modal">Close</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>