$(document).ready(function(){   
	
});

function hidePassword(){
	if($("#txtPw").attr("type") == "password") {
		 $("#txtPw").attr("type", "text");
		 $("#btnpw").text("Hide");
	}
	else{
		 $("#txtPw").attr("type", "password");
		 $("#btnpw").text("Show");
	}
}

function checkLogin(){
    if((!$("#txtEmail").val() == "")&& (!$("#txtPw").val() == "")){
    	
//    	var email=$("#txtEmail").val();
//    	var pw=$("#txtPw").val();
//    	$("#msgModal").text("Email: "+email+"\n"+"Password: "+pw);
    	var ls="Login Success !!";
    	$("#msgModal").text(ls);
    	$("#myModal").modal("show");

	}
	else{
		if(($("#txtEmail").val() == "")&& (!$("#txtPw").val() == "")){
			var ene="Please enter your e-mail !!";
			$("#msgModal").text(ene);
	    	$("#myModal").modal("show");
		}
		else if(($("#txtPw").val() == "")&& (!$("#txtEmail").val() == "")){
			var enp="Please enter your password !!";
			$("#msgModal").text(enp);
	    	$("#myModal").modal("show");
		}
		else{
			var enep="Please enter your e-mail and password !!";
			$("#msgModal").text(enep);
	    	$("#myModal").modal("show");
		}
	}
}