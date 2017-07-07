function sendRequest() {
	if((!$("#txtemail").val() == "")&& (!$("#comboBoss").val() == "")&& (!$("#comboLeave").val() == "")&& (!$("#txtStartDate").val() == "")&& (!$("#txtStopDate").val() == "")&& (!$("#txtCountDay").val() == "")&& (!$("#txtArea").val() == "")){
		$("#frmRequest").ajaxSubmit({
    	      type: 'POST',
    	      url: ctx + '/RequestSrvl',
    	      success: function(data) {
    				$("#msgModalRequest").text("Complete!!");
    		    	$("#myModalRequest").modal("show");
    	      }
    	})
	}else {
			$("#msgModalRequest").text("Please enter your form completely.!!");
	    	$("#myModalRequest").modal("show");
		}
}

function cancelRequest(){
	$("#msgModalCancelRequest").text("Are you sure!!");
	$("#myModalCancelRequest").modal("show");
}

function comfirm(){
	location.reload();
}