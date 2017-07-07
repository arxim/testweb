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

function validateLogin() {
	if((!$("#txtEmailLogin").val() == "")&& (!$("#txtPwdLogin").val() == "")){
		return true;
	}else {
		if(($("#txtEmailLogin").val() == "")&& (!$("#txtPwdLogin").val() == "")){
			var ene="Please enter your e-mail !!";
			$("#msgModalLoginResult").text(ene);
			$("#msgModalLoginShowEmail").text("");
		    $("#msgModalLoginShowPwd").text("");
	    	$("#myModalLogin").modal("show");
	    	return false;
		}
		else if(($("#txtPwdLogin").val() == "")&& (!$("#txtEmailLogin").val() == "")){
			var enp="Please enter your password !!";
			$("#msgModalLoginResult").text(enp);
			$("#msgModalLoginShowEmail").text("");
		    $("#msgModalLoginShowPwd").text("");
	    	$("#myModalLogin").modal("show");
	    	return false;
		}
		else{
			var enep="Please enter your e-mail and password !!";
			$("#msgModalLoginResult").text(enep);
			$("#msgModalLoginShowEmail").text("");
		    $("#msgModalLoginShowPwd").text("");
	    	$("#myModalLogin").modal("show");
	    	return false;
		}
	}
}

$(document).ready(function() {
	if (msgLoginError) {
		$('#msg-modalLoginError').modal();
	}
});

function closeModalLoginError(){
	$.ajax({
	      type: 'POST',
	      url: ctx + '/ClearSession'
	});
}