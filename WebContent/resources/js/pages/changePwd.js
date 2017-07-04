function ConfirmNewPwd(){
	if(($("#txtConfirmPwd").val() == "")&&($("#txtNewPwd").val() == "")&&($("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your password, new password and repeat password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
	}
	else if(($("#txtConfirmPwd").val() == "")&&($("#txtNewPwd").val() == "")&&(!$("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your password and new password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
		}
	else if(($("#txtConfirmPwd").val() == "")&&(!$("#txtNewPwd").val() == "")&&($("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your password and repeat password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
		}
	else if((!$("#txtConfirmPwd").val() == "")&&($("#txtNewPwd").val() == "")&&($("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your new password and repeat password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
		}
	else if((!$("#txtConfirmPwd").val() == "")&&(!$("#txtNewPwd").val() == "")&&($("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your repeat password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
		}
	else if((!$("#txtConfirmPwd").val() == "")&&($("#txtNewPwd").val() == "")&&(!$("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your new password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
		}
	else if(($("#txtConfirmPwd").val() == "")&&(!$("#txtNewPwd").val() == "")&&(!$("#txtReNewPwd").val() == "")){	
		var allEn="Please enter your password!!";
		$("#msgModalChangePwd").text(allEn);
		$("#myModalChangePwd").modal("show");
		}
	else{
		if($("#txtNewPwd").val() == $("#txtReNewPwd").val()){
			
			var email=$("#txtEmailSignUp").val();
			var pwd=$("#txtConfirmPwd").val();
			var newpwd=$("#txtNewPwd").val();
			var renewpwd=$("#txtReNewPwd").val();
			
		$.ajax({
			type: 'POST',
			url: ctx + '/ChangePwdSrvl',
			data: {
				emailSignUp : email,
				pwdConfirm : pwd
			},
			dataType: "text",
			success: function(data) {
			var msgFlag;
				if(data == "true"){
 	    	  
				}
				else{
					msgFlag = "Password and email is not in the database.";
					$("#msgModalChangePwd").text(pwdNotMatch);
			    	$("#myModalChangePwd").modal("show");
				}
			}
	    	});
		}
		else{
			var pwdNotMatch="New/repeat password do not match!!";
			$("#msgModalChangePwd").text(pwdNotMatch);
	    	$("#myModalChangePwd").modal("show");
		}
	}
	
}