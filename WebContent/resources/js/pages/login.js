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
    	var email=$("#txtEmailLogin").val();
    	var pwd=$("#txtPwdLogin").val();  
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
   	    	      	 location.href = ctx + '/mainMenu.jsp';
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