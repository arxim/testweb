function createAccount(){
	if(($("#txtEmailSignUp").val() == "")&&($("#txtPwdSignUp").val() == "")&&($("#txtRePwdSignUp").val() == "")){	
		var allEn="Please enter your e-mail, password and repeat password!!";
		$("#msgModalSignUp").text(allEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtEmailSignUp").val() == "")&&($("#txtPwdSignUp").val() == "")&&(!$("#txtRePwdSignUp").val() == "")){	
		var emailPwdEn="Please enter your e-mail and password!!";
		$("#msgModalSignUp").text(emailPwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtEmailSignUp").val() == "")&&($("#txtRePwdSignUp").val() == "")&&(!$("#txtPwdSignUp").val() == "")){	
		var emailRePwdEn="Please enter your e-mail and repeat password!!";
		$("#msgModalSignUp").text(emailRePwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtPwdSignUp").val() == "")&&($("#txtRePwdSignUp").val() == "")&&(!$("#txtEmailSignUp").val() == "")){	
		var pwdRePwdEn="Please enter your password and repeat password!!";
		$("#msgModalSignUp").text(pwdRePwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtEmailSignUp").val() == "")&&(!$("#txtPwdSignUp").val() == "")&&(!$("#txtRePwdSignUp").val() == "")){	
		var emailEn="Please enter your e-mail!!";
		$("#msgModalSignUp").text(emailEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtPwdSignUp").val() == "")&&(!$("#txtEmailSignUp").val() == "")&&(!$("#txtRePwdSignUp").val() == "")){
		var pwdEn="Please enter your password!!";
		$("#msgModalSignUp").text(pwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtRePwdSignUp").val() == "")&&(!$("#txtEmailSignUp").val() == "")&&(!$("#txtPwdSignUp").val() == "")){
		var rePwdEn="Please enter your repeat password!!";
		$("#msgModalSignUp").text(rePwdEn);
    	$("#myModalSignUp").modal("show");
	}
	
	else{
		if($("#txtPwdSignUp").val() == $("#txtRePwdSignUp").val()){
		/*	var success="Sign up success!!";
			$("#msgModalSignUp").text(success);
	    	$("#myModalSignUp").modal("show");		*/
	    	
//	    	console.log('Send ajax request');
			var email=$("#txtEmailLogin").val();
	    	var pwd=$("#txtPwdLogin").val();
	    	$.ajax({
	    	      type: 'POST',
	    	      url: ctx + '/SignUpSrvl',
	    	      data: {
	    	    	  emailSignUp : email,
	    	    	  pwdSignUp : pwd
	    	      },
	    	      dataType: "text",
	    	      success: function(data) {
	    	    	  var msgFlag;
	    	    	  if (data === "Success") {
	    	    		 /*msgFlag = "Redirect to home page.";
	    	    		 $("#msgModalLoginResult").text(msgFlag);
	   	    	      	 $("#myModalLogin").modal("show");*/
	   	    	      	 location.href='mainMenu.jsp';
	    	    	  }
	    	    	  else if(data === "Failed"){
	    	    		  msgFlag = 'Sign up failed!!';
	    	    		  $("#msgModalLoginResult").text(msgFlag);
	    	    	      $("#myModalLogin").modal("show");
	    	    	  }
	    	    	  else if(data === "Please change e-mail"){
	    	    		  msgFlag = "Please change e-mail";
	    	    		  $("#msgModalLoginResult").text(msgFlag);
	    	    	      $("#myModalLogin").modal("show");
	    	    	  }
	    	    	  else if(data === "Please change password"){
	    	    		  msgFlag = "Please change password";
	    	    		  $("#msgModalLoginResult").text(msgFlag);
	    	    	      $("#myModalLogin").modal("show");
	    	    	  }
	    	    	  else{
	    	    		  msgFlag = 'Email and/or Password not found';
	    	    		  $("#msgModalLoginResult").text(msgFlag);
	    	    	      $("#myModalLogin").modal("show");
	    	    	  }
		    	  }
	    	});
		}
		else{
			var pwdNotMatch="Passwords do not match!!";
			$("#msgModalSignUp").text(pwdNotMatch);
	    	$("#myModalSignUp").modal("show");
		}
	}
}