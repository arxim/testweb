<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 	script-header import -->
	<jsp:include page="resources/template/script-header.jsp"></jsp:include>
	<script type="text/javascript" src="resources/js/pages/login.js"></script>
	<title>login</title>
	<!-- 	css using -->
	<link rel="stylesheet" type="text/css" href="resources/css/login.css" media="all" /> 
	

</head>
<body>
	<div class="container">
		<br>
		<br>
		<a href="#" class="btn-close" id="btn-close" onclick="">
			<span><img src="resources/images/icon-close.png" class="img-responsive center-block" alt="icon payment" width="60" height=""></span>
		</a>
		<br>
		<br>
		<div class="col-sm-3">
		
		</div>
		<div class="col-sm-6 text-center">
	    	<ul id="LSTab" class="nav nav-tabs nav-justified">
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
			<div id="LSTab" class="tab-content">
			   <div class="tab-pane fade active in" id="login">
			   		 <div class="enteredLogin-heading" style="border-bottom: 1px solid #E5E5E5;">
			   		 	 <br>
				      	 Enter your email and password to <b>sign in</b>
				      	 <br>
				      	 <br>
				     </div>
			      	 <div class="email-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
			      	 	<br>
			      	 	<div class="container-fluid">
					      	 <label><b>Email*</b></label><br>
					      	 <input id="txtEmail" type="text" name="txtEmail" placeholder="Email" maxlength="255" size="66">
				      	 </div>
				      	 <br>
				     </div>
				     <div class="pw-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
				     	<div class="row container-fluid">
					      	<div class="col-sm-10" id="LSTab" style="border-right: 1px solid #E5E5E5;">
					      		<br>
								<label><b>Password*</b></label><br>
								<input id="txtPw" type="text" name="txtPw" placeholder="Password" maxlength="255" size="53">
								<br>
								<br>
							</div>
							<div class="col-sm-2" id="LSTab">
								<label></label>
								<label></label>
								<button type="button" class="btn btn-default btn-block" id="btnpw" onclick="hidePassword()">Show</button>
								<br>
							</div>
							<br>
						</div>
					</div>
					<div class="signIn-heading" style="border-bottom: 1px solid #E5E5E5;">
						<div class="row container-fluid">
							<div class="col-sm-6 text-center" id="LSTab" style="color:red;">
					   		 	 <br>
									Forgot your password?<br><a href="#" style="color:red;">Click here</a>
						      	 <br>
					      	</div>
					      	<div class="col-sm-6 text-center" id="LSTab">
					      		<br>
								<button type="button" class="btn btn-success btn-block btn-lg" id="btnLogin">Login</button> 	 
					      		<br>
					      	</div>
				      	</div>
				     </div>
			   </div>
			   <div class="tab-pane fade" id="sign-up">
			      	  <div class="enteredSignup-heading" style="border-bottom: 1px solid #E5E5E5;">
			   		 	 <br>
				      	 Enter your personal details <b>to create an acount</b>
				      	 <br>
				      	 <br>
				     </div>
				     <div class="email-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
			      	 	<br>
			      	 	<div class="container-fluid">
					      	 <label><b>Email*</b></label><br>
					      	 <input id="txtEmail" type="text" name="txtEmail" placeholder="Email" maxlength="255" size="66">
				      	 </div>
				      	 <br>
				     </div>
				     <div class="pw-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
				     	<div class="row container-fluid">
					      	<div class="col-sm-6 text-left" id="LSTab" style="border-right: 1px solid #E5E5E5;">
					      		<br>
								<label><b>Password*</b></label><br>
								<input id="txtPw" type="text" name="txtPw" placeholder="Password" maxlength="255" size="28.7">
								<br>
								<br>
							</div>
							<div class="col-sm-6 text-left" id="LSTab">
					      		<br>
								<label><b>Repeat Password*</b></label><br>
								<input id="txtPw" type="text" name="txtRepw" placeholder="Repeat Password" maxlength="255" size="28.7">
								<br>
								<br>
							</div>
						</div>
					</div>
					<div class="creteAccount-heading" style="border-bottom: 1px solid #E5E5E5;">
						<div class="row container-fluid">
							<div class="col-sm-6 text-center" id="LSTab">
					   		 	 <br>
									By creating an account you agree to our 
									<br><a href="#" style="color:red;">Terms & Privacy</a>
						      	 <br>
					      	</div>
					      	<div class="col-sm-6 text-center" id="LSTab">
					      		<br>
								<button type="button" class="btn btn-success btn-block btn-lg" id="btnLogin">Create Account</button> 	 
					      		<br>
					      	</div>
				      	</div>
				     </div>
			   </div>
			</div>
	    </div>
	    <div class="col-sm-3">
	    
		</div>
	</div>
</body>
</html>