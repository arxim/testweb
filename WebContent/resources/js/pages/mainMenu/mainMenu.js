$( document ).ready(function() {
	if (msgTimeout) {
		$('#msg-modal').modal();
	}
	
	if(userLogin == "boss@gmail.com"){
		$('#btnRequest').hide();
	}
	else
		$('#btnReport').hide();
});

function validateLogout() {
	return true
}
