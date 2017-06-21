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
<body class="bg-info">
		<div class="col hidden-xs">
		    <br>
		    <br>
		    <br>
		    <br>
		    <br>
	    </div>
	    <br>
		<br>
		<div class="container">
			<div class="col-xs-6 col-sm-2">
			
			</div>
			<div class="col-xs-12 col-sm-8 text-center">
		    	<ul id="LSTab" class="nav nav-tabs nav-default nav-justified" >
				   <li class="active">
				   		<a href="#login" data-toggle="tab" onclick="changeTabColor1()">
				   			<b>LOGIN</b>
				   		</a>
				   	</li>
				   <li class="">
				   		<a href="#sign-up" data-toggle="tab" onclick="changeTabColor2()">
				   			<b>SIGN UP</b>
				   		</a>
				   	</li>
				</ul>
				<div class="tab-content tab-default" id="LSTab" style="background-color:#ffffff;" >
				   <div class="tab-pane fade active in" id="login">
				   		 <div class="enteredLogin-heading text-center" style="border-bottom: 1px solid #E5E5E5;">
				   		 	 <div class="row container-fluid">
					   		 	 <div class="col-xs-24 col-sm-12">
						   		 	 <br>
							      	 Enter your email and password to 
							      	 <b class="text-primary">
							      	 	sign in
							      	 </b>
							      	 <br>
							      	 <br>
						      	 </div>
						     </div>
					     </div>
				      	 <div class="email-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
							<div class="row container-fluid">
								<div class="col-xs-24 col-sm-12" id="LSTab">
						      	 	<br>
								      	 <label><b>Email*</b></label><br>
									     <input id="txtEmail" class="form-control" type="text" name="txtEmail" placeholder="Email" maxlength="255">
			  	 					<br>
		  	 					</div>
	  	 					</div>
					     </div>
					     <div class="pw-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
					     	<div class="row container-fluid">
						      	<div class="col-xs-20 col-sm-10" id="LSTab" style="border-right: 1px solid #E5E5E5;">
						      		<br>
									<label><b>Password*</b></label><br>
									<input id="txtPw" type="text" class="form-control" name="txtPw" placeholder="Password" maxlength="255">
									<br>
								</div>
								<div class="col-xs-12 col-sm-2 text-white" id="LSTab">
									<div class="col hidden-xs">	
										<br>
										<br>
									</div>
									<button type="button" class="btn btn-warning btn-block form-control text-white" id="btnpw" onclick="hidePassword()">Show</button>
									<br>
								</div>
								<br>
							</div>
						</div>
						<div class="signIn-heading" style="border-bottom: 1px solid #E5E5E5;">
							<div class="row container-fluid">
								<div class="col-xs-12 col-sm-6 text-center text-danger" id="LSTab">
						   		 	 <br>
										Forgot your password?<br><a href="#" class="text-danger" >Click here</a>
							      	 <br>
						      	</div>
						      	<div class="col-xs-12 col-sm-6 text-center" id="LSTab">
						      		<br>
									<button type="button" class="btn btn-success btn-block btn-lg text-white" id="btnLogin">Login</button> 	 
						      		<br>
						      	</div>
					      	</div>
					     </div>
				   </div>
			   <div class="tab-pane fade" id="sign-up">
			      	  <div class="enteredSignup-heading text-center" style="border-bottom: 1px solid #E5E5E5;">
			      	  	 <div class="row container-fluid">
			      	  	 	 <div class="col-xs-24 col-sm-12">
					   		 	 <br>
						      	 Enter your personal details 
						      	 <b class="text-primary">
						      	 	to create an acount
						      	 </b>
						      	 <br>
						      	 <br>
					      	 </div>
					      </div>
				     </div>
				     <div class="email-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
			      	 	<div class="row container-fluid">
			      	 		<div class="col-xs-24 col-sm-12" id="LSTab">
				      	 	<br>
						      	<label><b>Email*</b></label><br>
						      	<input id="txtEmail" class="form-control" type="text" name="txtEmail" placeholder="Email" maxlength="255">
					      	<br>
					      	</div>
					    </div>  	
				     </div>
				     <div class="pw-heading text-left" style="border-bottom: 1px solid #E5E5E5;">
				     	<div class="row container-fluid">
					      	<div class="col-xs-12 col-sm-6 text-left" id="LSTab" style="border-right: 1px solid #E5E5E5;">
					      		<br>
								<label><b>Password*</b></label><br>
								<input id="txtPw" class="form-control" type="text" name="txtPw" placeholder="Password" maxlength="255">
								<div class="col hidden-xs">	
									<br>
								</div>
							</div>
							<div class="col-xs-12 col-sm-6 text-left" id="LSTab">
					      		<br>
								<label><b>Repeat Password*</b></label><br>
								<input id="txtPw" class="form-control" type="text" name="txtRepw" placeholder="Repeat Password" maxlength="255">
								<br>
							</div>
						</div>
					</div>
					<div class="creteAccount-heading" style="border-bottom: 1px solid #E5E5E5;">
						<div class="row container-fluid">
							<div class="col-xs-12 col-sm-6 text-center text-danger" id="LSTab">
					   		 	 <br>
									By creating an account you agree to our 
									<br><a href="#" class="text-danger">Terms & Privacy</a>
						      	 <br>
					      	</div>
					      	<div class="col-xs-12 col-sm-6 text-center" id="LSTab">
					      		<br>
								<button type="button" class="btn btn-success btn-block btn-lg" id="btnLogin">Create Account</button> 	 
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
	<div class="col hidden-sm">
    	<br>
   		<br>
	</div>		   
</body>
</html>