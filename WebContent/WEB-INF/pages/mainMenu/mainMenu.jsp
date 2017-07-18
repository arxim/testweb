<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		var userLogin = '${sessionScope.userLogin}';
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
		<div class="col-xs-12 col-sm-6 col-sm-offset-3 text-center">
			<div class="panel panel-primary form-horizontal">
				<div class="panel-heading">
					<h2 class="panel-title" align="center">
						<b>Welcome : ${sessionScope.userLogin}</b>
					</h2>
				</div>
				<div class="panel-body">
					<br>
					<div class="form-group">
					<div class="col-xs-12 col-sm-4 col-sm-offset-4  text-center">
						<button type="submit" class="btn btn-primary btn-block"
							id="btnRequest" formaction="/testweb/LoadRequestOnLeaveSrvl">request</button>
					</div>
					</div>
					<div class="form-group">
					<div class="col-xs-12 col-sm-4 col-sm-offset-4 text-center">
						<button type="submit" class="btn btn-primary btn-block"
							id="btnRequest" formaction="/testweb/LoadEditRequestOnLeaveSrvl">Edit
							request</button>
					</div>
					</div>
					<div class="form-group">
					<div class="col-xs-12 col-sm-4 col-sm-offset-4 text-center">
						<button type="submit" class="btn btn-primary btn-block"
							id="btnApprove" formaction="/testweb/ApproveSrvl">approve</button>
					</div>
					</div>
					<div class="form-group">
					<div class="col-xs-12 col-sm-4 col-sm-offset-4 text-center">
						<button type="button" class="btn btn-primary btn-block"
							id="btnReport"
							onclick="location.href='/testweb/LoadReportOnLeaveSrvl'">report</button>
					</div>
					</div>
					<div class="form-group">
					<div class="col-xs-12 col-sm-4 col-sm-offset-4 text-center">
							<button type="submit" class="btn btn-primary btn-block btn-danger"
							id="btnLogout" formaction="/testweb/LogoutSrvl">Logout</button>
					</div>
					</div>
				</div>
			</div>
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