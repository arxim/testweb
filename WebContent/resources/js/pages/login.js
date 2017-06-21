$(document).ready(function(){   
	
});

//function changeTabColor1(){
//	$("#login").style.backgroundcolor = "#ffffff";
//	$("#sign-up").style.backgroundcolor = "blue";
//}
//
//function changeTabColor2(){
//	$("#sign-up").style.backgroundcolor = "#ffffff";
//	$("#login").style.backgroundcolor = "blue";
//}


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
