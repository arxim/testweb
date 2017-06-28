$(document).ready(function(){   
	
});

function hidePassword(){
	if($("#txtPwdLogin").attr("type") == "password") {
		 $("#txtPwdLogin").attr("type", "text");
		 $("#btnPwdHide").text("Hide");
	}
	else{
		 $("#txtPwdLogin").attr("type", "password");
		 $("#btnPwdHide").text("Show");
	}
}

function checkLogin(){
    if((!$("#txtEmailLogin").val() == "")&& (!$("#txtPwdLogin").val() == "")){
//    	console.log(ctx);
    	var email=$("#txtEmailLogin").val();
    	var pwd=$("#txtPwdLogin").val();   	
//    	console.log('Send ajax request');
    	$.ajax({
    	      type: 'POST',
    	      url: ctx + '/LoginSrvl',
    	      data: {
    	    	  	emailLogin : email,
              		pwdLogin : pwd
    	      },
    	      dataType: "text",
    	      success: function(data) {
    	    	  var msgFlag;
    	    	  if (data === 'success') {
    	    		 /*msgFlag = 'Redirect to home page.';
    	    		 $("#msgModalLoginResult").text(msgFlag);
   	    	      	 $("#myModalLogin").modal("show");*/
   	    	      	 location.href='home.jsp';
    	    	  }else {
    	    		  msgFlag = 'Email and/or Password not found - database';
    	    		  $("#msgModalLoginResult").text(msgFlag);
    	    	      $("#myModalLogin").modal("show");
    	    	  }
	    	  }
    	});
	}
	else{
		if(($("#txtEmailLogin").val() == "")&& (!$("#txtPwdLogin").val() == "")){
			var ene="Please enter your e-mail !!";
			$("#msgModalLoginResult").text(ene);
			$("#msgModalLoginShowEmail").text("");
  	      	$("#msgModalLoginShowPwd").text("");
	    	$("#myModalLogin").modal("show");
		}
		else if(($("#txtPwdLogin").val() == "")&& (!$("#txtEmailLogin").val() == "")){
			var enp="Please enter your password !!";
			$("#msgModalLoginResult").text(enp);
			$("#msgModalLoginShowEmail").text("");
  	      	$("#msgModalLoginShowPwd").text("");
	    	$("#myModalLogin").modal("show");
		}
		else{
			var enep="Please enter your e-mail and password !!";
			$("#msgModalLoginResult").text(enep);
			$("#msgModalLoginShowEmail").text("");
  	      	$("#msgModalLoginShowPwd").text("");
	    	$("#myModalLogin").modal("show");
		}
	}
}

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
			var success="Sign up success!!";
			$("#msgModalSignUp").text(success);
	    	$("#myModalSignUp").modal("show");
		}
		else{
			var pwdNotMatch="Passwords do not match!!";
			$("#msgModalSignUp").text(pwdNotMatch);
	    	$("#myModalSignUp").modal("show");
		}
	}
}