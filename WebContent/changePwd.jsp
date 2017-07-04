<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	<jsp:include page="resources/template/modalChangePwd.jsp"></jsp:include>
	<script type="text/javascript" src="resources/js/pages/changePwd.js"></script>
<title>Change Password</title>
</head>
<body class="bg-info">
	<div class="container" style="margin-top:10%; margin-bottom:12%;">
		<div class="col-xs-12 col-sm-12 text-center">
			<h2><strong>Change Password</strong></h2>
			  <br>
		</div>
				<div class="email-heading text-left">
					<div class="row container-fluid">
						<div class="col-xs-12 col-sm-offset-3 col-sm-6" id="LSTab">
			  				<label><b>Password*</b></label>
							<input id="txtConfirmPwd" class="form-control" type="password" name="txtConfirmPwd" placeholder="Password" maxlength="255">
			  			</div>
			  		</div>
			  	</div>
			  <br>
				<div class="pw-heading text-left">
					<div class="col-xs-12 col-sm-offset-3 col-sm-6 text-left" id="LSTab">
						<label><b>New Password*</b></label>
						<input id="txtNewPwd" class="form-control" type="password" name="txtNewPwd" placeholder="New Password" maxlength="255">
					</div>
				</div>
			<br><br><br><br>	
				<div class="pw-heading text-left">
					<div class="col-xs-12 col-sm-offset-3 col-sm-6 text-left" id="LSTab">
						<label><b>Repeat Password*</b></label>
						<input id="txtReNewPwd" class="form-control" type="password" name="txtReNewPwd" placeholder="Repeat New Password" maxlength="255">
					</div>
				</div>
			<br><br><br><br>
				<div class="col-xs-6 col-sm-offset-4 col-sm-2 text-center" id="LSTab">
					<button type="button" class="btn btn-primary btn-block btn-lg" id="ConfirmNewPwd" onclick="ConfirmNewPwd();">Confirm</button>
				</div>
				<div class="col-xs-6 col-sm-2 text-center" id="LSTab">
					<button type="button" class="btn btn-primary btn-block btn-lg" id="gotoMainMenu" onclick="location.href='mainMenu.jsp'">Main Menu</button>
				</div>
	</div>
</body>
</html>