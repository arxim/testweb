<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Forgot Password</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	<jsp:include page="/resources/template/modalForgotPwdMessage.jsp"></jsp:include>
	<script type="text/javascript">
		var ctx = '${pageContext.request.contextPath}';
	</script>
	<script type="text/javascript" src="resources/js/pages/forgotPwd/forgotPwd.js"></script>

</head>
<body class="bg-info">
	<form id="frmChangePwd" action="/testweb/ChangePwdSrvl" method="post">
		<div class="container" style="margin-top:10%; margin-bottom:12%;">
			<div class="col-xs-6 col-sm-3">
			
			</div>
			<div class="col-xs-12 col-sm-6 text-center">
				<div class="panel panel-primary">
				    <div class="panel-heading">
				    	<h4 class="panel-title"><b>Forgot Password</b></h4>
				 	</div>
				    <div class="panel-body">
				    	<div class="enteredLogin-heading text-left">
				   		 	 <div class="row">
					   		 	 <div class="col-xs-24 col-sm-12">
							      	 <label><b>Email*</b></label>
									 <input id="txtEmailSendPwd" class="form-control" type="text" name="txtEmailSendPwd" placeholder="Send Email" maxlength="255">
						      	 </div>
						     </div>
					    </div>
					    <div class="button-heading">
				   		 	 <div class="row">
					   		 	 <div class="col-xs-24 col-sm-12 text-center">
					   		 	 	 <br>
							      	 	 <button type="button" class="btn btn-primary text-white" id="btnSendEmail" onclick="resultSendEmail()" >Send Email</button>
							      	 	 <button type="button" class="btn btn-primary text-white" id="btnBackToLogin" onclick="window.location.href='/testweb/LoginSrvl'" >Back</button>
						      	 </div>
						     </div>
					    </div>
				    </div>
				</div>
			</div>	
		    <div class="col-xs-6 col-sm-3">
		    	
			</div>	
		</div>
	</form> 
	<form id="frmLogin" action="/testweb/LoginSrvl" method="post">
	</form>  
</body>
</html>