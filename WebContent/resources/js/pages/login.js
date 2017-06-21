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
