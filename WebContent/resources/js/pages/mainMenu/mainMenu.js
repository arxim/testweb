$( document ).ready(function() {
	if (msgTimeout) {
		$('#msg-modal').modal();
	}
});

function validateLogout() {
	return true
}