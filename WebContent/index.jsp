<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Index</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 	script-header import -->
	<jsp:include page="resources/template/script-header.jsp"></jsp:include>
	<jsp:include page="resources/template/modalLoginMessage.jsp"></jsp:include>
	<jsp:include page="resources/template/modalSignUpMessage.jsp"></jsp:include>
	<script type="text/javascript">
		var ctx = '${pageContext.request.contextPath}';
	</script>
	<script type="text/javascript" src="resources/js/pages/login.js"></script>
	<title>login</title>
	<!-- 	css using -->

</head>
<body class="bg-info">
	<form id="frmLogin" action="/testweb/LoginSrvl" method="post">
		<div class="container" style="margin-top:10%;margin-bottom:12%;">
			<div class="col-xs-6 col-sm-2">
			
			</div>
			<div class="col-xs-12 col-sm-8 text-center" >
		    	<ul id="LSTab" class="nav nav-tabs nav-default nav-justified" style="box-shadow:0 0 18px rgba(6, 0, 255, 0.3);">
				   <li class="active">
				   		<a href="#login" data-toggle="tab">
				   			<b>LOGIN</b>
				   		</a>
				   	</li>
				   <li class="">
				   		<a href="#sign-up" data-toggle="tab">
				   			<b>SIGN UP</b>
				   		</a>
				   	</li>
				</ul>
				<div class="tab-content tab-default" id="LSTab" style="background-color:#ffffff;box-shadow:0 0 18px rgba(6, 0, 255, 0.3);" >
				   <div class="tab-pane fade active in" id="login">
				   		 <div class="enteredLogin-heading text-center">
				   		 	 <div class="row container-fluid">
					   		 	 <div class="col-xs-24 col-sm-12">
						   		 	 <br>
							      	 Enter your email and password to 
							      	 <b class="text-primary">
							      	 	sign in
							      	 </b>
						      	 </div>
						     </div>
					     </div>
					     <hr>
				      	 <div class="email-heading text-left">
							<div class="row container-fluid">
								<div class="col-xs-24 col-sm-12" id="LSTab">
								     <label><b>Email*</b></label><br>
									 <input id="txtEmailLogin" class="form-control" type="text" name="txtEmailLogin" placeholder="Email" maxlength="255">
		  	 					</div>
	  	 					</div>
					     </div>
					     <hr>
					     <div class="pw-heading text-left">
					     	<div class="row container-fluid">
								<div class="col-xs-24 col-sm-12" id="LSTab">
									<label><b>Password*</b></label><br>
									<div class="input-group">
								    	<input id="txtPwdLogin" type="text" class="form-control" name="txtPwdLogin" placeholder="Password" maxlength="255">
								        <span class="input-group-btn">
								        	<button class="btn btn-default" type="button" id="btnPwdHide" onclick="hidePassword()">Show</button>
								      	</span>
								    </div>								
								</div>
							</div>
						</div>
						<hr>
						<div class="signIn-heading" style="border-bottom: 1px solid #E5E5E5;">
							<div class="row container-fluid">
								<div class="col-xs-12 col-sm-6 text-center text-danger" id="LSTab">
									 Forgot your password?<br><a href="/testweb/ForgotPwdSrvl"  class="text-danger" >Click here</a>
							      	 <br>
							      	 <div class="col hidden-sm">
							      	 	<br>
							      	 </div>
						      	</div>
						      	<div class="col-xs-12 col-sm-6 text-center" id="LSTab">
									<button type="button" class="btn btn-primary btn-block btn-lg text-white" id="btnLogin" onclick="checkLogin()" >Login</button>
											
						      		<br>
						      	</div>
					      	</div>
					     </div>
				   </div>
			   <div class="tab-pane fade" id="sign-up">
			      	  <div class="enteredSignup-heading text-center">
			      	  	 <div class="row container-fluid">
			      	  	 	 <div class="col-xs-24 col-sm-12">
			      	  	 	 	 <br>
						      	 Enter your personal details 
						      	 <b class="text-primary">
						      	 	to create an account
						      	 </b>
					      	 </div>
					      </div>
				     </div>
				     <hr>
				     <div class="email-heading text-left">
			      	 	<div class="row container-fluid">
			      	 		<div class="col-xs-24 col-sm-12" id="LSTab">
						      	<label><b>Email*</b></label><br>
						      	<input id="txtEmailSignUp" class="form-control" type="text" name="txtEmailSignUp" placeholder="Email" maxlength="255">
					      	</div>
					    </div>  	
				     </div>
				     <hr>
				     <div class="pw-heading text-left">
				     	<div class="row container-fluid">
					      	<div class="col-xs-12 col-sm-6 text-left" id="LSTab">
								<label><b>Password*</b></label><br>
								<input id="txtPwdSignUp" class="form-control" type="password" name="txtPwdSignUp" placeholder="Password" maxlength="255">
							</div>
							<div class="col-xs-12 col-sm-6 text-left" id="LSTab">
								<div class="col hidden-sm col visible-xs">
								    <br>  	 
								</div>
								<label><b>Repeat Password*</b></label><br>
								<input id="txtRePwdSignUp" class="form-control" type="password" name="txtRePwdSignUp" placeholder="Repeat Password" maxlength="255">
							</div>
						</div>
					</div>
					<hr>
					<div class="creteAccount-heading">
						<div class="row container-fluid">
							<div class="col-xs-12 col-sm-6 text-center text-danger" id="LSTab">
								 By creating an account you agree to our 
								 <div class="col hidden-xs">
							      	 
							    </div>
								 <a href="#" class="text-danger">Terms & Privacy</a>
								 <div class="col hidden-sm">
							      	 <br>
							     </div>
					      	</div>
					      	<div class="col-xs-12 col-sm-6 text-center" id="LSTab">
								<button type="button" class="btn btn-primary btn-block btn-lg" id="btnSignUp" onclick="createAccount();">Create Account</button> 	 
					      		<br>
					      	</div>
				      	</div>
				     </div>
			     </div>
	    	</div>
	    </div>
	    <div class="col-xs-6 col-sm-2">
	    
		</div>	
		</div>
	</form> 
	<form id="frmChangePwd" action="/testweb/ChangePwdSrvl" method="post">
	</form>  
</body>
</html>