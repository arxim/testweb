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
    	
//    	var email=$("#txtEmail").val();
//    	var pw=$("#txtPw").val();
//    	$("#msgModal").text("Email: "+email+"\n"+"Password: "+pw);
    	var ls="Login Success !!";
    	$("#msgModalLogin").text(ls);
    	$("#myModalLogin").modal("show");

	}
	else{
		if(($("#txtEmailLogin").val() == "")&& (!$("#txtPwdLogin").val() == "")){
			var ene="Please enter your e-mail !!";
			$("#msgModalLogin").text(ene);
	    	$("#myModalLogin").modal("show");
		}
		else if(($("#txtPwdLogin").val() == "")&& (!$("#txtEmailLogin").val() == "")){
			var enp="Please enter your password !!";
			$("#msgModalLogin").text(enp);
	    	$("#myModalLogin").modal("show");
		}
		else{
			var enep="Please enter your e-mail and password !!";
			$("#msgModalLogin").text(enep);
	    	$("#myModalLogin").modal("show");
		}
	}
}

function createAccount(){
	if(($("#txtEmailSignUp").val() == "")&&($("#txtPwdSignUp").val() == "")&&($("#txtRePwdSignUp").val() == "")){	
		var allEn="Please Enter Email, Password and Repeat Password!!";
		$("#msgModalSignUp").text(allEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtEmailSignUp").val() == "")&&($("#txtPwdSignUp").val() == "")&&(!$("#txtRePwdSignUp").val() == "")){	
		var emailPwdEn="Please Enter Email and Password!!";
		$("#msgModalSignUp").text(emailPwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtEmailSignUp").val() == "")&&($("#txtRePwdSignUp").val() == "")&&(!$("#txtPwdSignUp").val() == "")){	
		var emailRePwdEn="Please Enter Email and Repeat Password!!";
		$("#msgModalSignUp").text(emailRePwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtPwdSignUp").val() == "")&&($("#txtRePwdSignUp").val() == "")&&(!$("#txtEmailSignUp").val() == "")){	
		var pwdRePwdEn="Please Enter Password and Repeat Password!!";
		$("#msgModalSignUp").text(pwdRePwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtEmailSignUp").val() == "")&&(!$("#txtPwdSignUp").val() == "")&&(!$("#txtRePwdSignUp").val() == "")){	
		var emailEn="Please Enter Email!!";
		$("#msgModalSignUp").text(emailEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtPwdSignUp").val() == "")&&(!$("#txtEmailSignUp").val() == "")&&(!$("#txtRePwdSignUp").val() == "")){
		var pwdEn="Please Enter Password!!";
		$("#msgModalSignUp").text(pwdEn);
    	$("#myModalSignUp").modal("show");
	}
	else if(($("#txtRePwdSignUp").val() == "")&&(!$("#txtEmailSignUp").val() == "")&&(!$("#txtPwdSignUp").val() == "")){
		var rePwdEn="Please Enter Repeat Password!!";
		$("#msgModalSignUp").text(rePwdEn);
    	$("#myModalSignUp").modal("show");
	}
	
	else{
		if($("#txtPwdSignUp").val() == $("#txtRePwdSignUp").val()){
			var success="Sign up Success!!";
			$("#msgModalSignUp").text(success);
	    	$("#myModalSignUp").modal("show");
			
			// Send data to server side
			/*
			$.ajax({
			  method: "POST",
			  url: "",
			  data: { name: "John", location: "Boston" }
			})
			*/
		}
		else{
			var pwdNotMatch="Passwords do not match!!";
			$("#msgModalSignUp").text(pwdNotMatch);
	    	$("#myModalSignUp").modal("show");
		}
	}
}