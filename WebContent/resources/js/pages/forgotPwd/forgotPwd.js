$(document).ready(function(){   
	
});

function resultSendEmail(){
	if($("#txtEmailSendPwd").val()==""){
		var pse="Please enter your send to e-mail !!"
		$("#msgModalForgotPwdResult").text(pse);
  	    $("#myModalForgotPwd").modal("show");	    	  
	}
	else{
		var emailForSend=$("#txtEmailSendPwd").val();  	
		$.ajax({
		      type: 'POST',
		      url: ctx + '/ChkEmailForSendSrvl',
		      data: {
		    	  	emailSend : emailForSend,
		      },
		      dataType: "text",
		      success: function(data) {
		    	  $("#modalTitleForgotPwdResult").text("Success!!!");
		    	  $("#msgModalForgotPwdResult").text(data);
		    	  $("#myModalForgotPwd").modal("show");
	    	  }
		});
	}
}