$(document).ready(function(){   
	
});

function checkResultClose(){
	if($("#msgModalForgotPwdResult").text()=="Send Email : "+$("#txtEmailSendPwd").val()+" Success !!"){
		location.href='/testweb/LoadLoginSrvl';
	}
	else{
		location.href='/testweb/ForgotPwdSrvl';
	}
}

function resultSendEmail(){  // respond massage
	if($("#txtEmailSendPwd").val()==""){  // if email is null
		var pse="Please enter your send to e-mail !!";
		$("#msgModalForgotPwdResult").text(pse);
  	    $("#myModalForgotPwd").modal("show");
	}
	else{  // if email is not null
		var emailForSend=$("#txtEmailSendPwd").val();  // ajax get Email to ChkEmailForSendSrvl for check email in DB
		$.ajax({
		      type: 'POST',
		      url: ctx + '/ChkEmailForSendSrvl',
		      data: {
		    	  	emailSend : emailForSend,
		      },
		      dataType: "text",
		      success: function(data) { // found Email and send success
		    	  if(data=="Send Email fail !!"){
		    		  $("#modalTitleForgotPwdResult").text("Warning!!!");
		    		  $("#msgModalForgotPwdResult").text(data);
			    	  $("#myModalForgotPwd").modal("show");
		    	  }
		    	  else{
		    		  $("#modalTitleForgotPwdResult").text("Success!!!");
			    	  $("#msgModalForgotPwdResult").text(data);
			    	  $("#myModalForgotPwd").modal("show");
		    	  }
	    	  }
		});
	}
}