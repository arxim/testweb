
$(document).ready(function () {
//	$('#startDate').datepicker(); 
//	$('#stopDate').datepicker(); 
	$('#datepickerStart').datepicker({
		//format:"ddmmyyyy",
		autoclose: true
	});
	$('#datepickerStop').datepicker({
		//format:"ddmmyyyy",
		autoclose: true
	});

});
function sendRequest() {
	if((!$("#txtemail").val() == "")&& (!$("#comboBoss").val() == "")&& (!$("#comboLeave").val() == "")&& (!$("#startDate").val() == "")&& (!$("#stopDate").val() == "")&& (!$("#txtDateDiff").val() == "")){
		$("#frmRequest").ajaxSubmit({
    	      type: 'POST',
    	      url: ctx + '/RequestSrvl',
    	      success: function(data) {
    				$("#msgModalRequest").text("Complete!!");
    		    	$("#myModalRequest").modal("show");
    	      }
    	});
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

$(function (){
   // $('#datetimepickerStart').datetimepicker();
   /* $('#datetimepickerStop').datetimepicker({
        useCurrent: false //Important! See issue #1075
    });*/
    $("#datetimepickerStart").on("dp.change", function (e) {
        $('#datetimepickerStop').data("DateTimePicker").minDate(e.date);
    });
    $("#datetimepickerStop").on("dp.change", function (e) {
        $('#datetimepickerStart').data("DateTimePicker").maxDate(e.date);
    });
});

function dateDiff(){
	var strStart = $("#startDate").val();
	var strStop = $("#stopDate").val();
	
	var first_date = Date.parse(strStart);
	var last_date = Date.parse(strStop);
	var diff_date =  last_date - first_date;
	
	var num_years = diff_date/(365.25 * 24 * 60 * 60 * 1000);
	var num_months = (diff_date % (365.25 * 24 * 60 * 60 * 1000))/(365.25 / 12 * 24 * 60 * 60 * 1000);
	var num_days = ((diff_date % (365.25 * 24 * 60 * 60 * 1000)) % (365.25 / 12 * 24 * 60 * 60 * 1000))/86400000+1;
	
	var result ="";
	if (Math.floor(num_years) > 0)
		result += (" " + Math.floor(num_years) + " ปี\n");
	if (Math.floor(num_months) > 0)
		result += (" " + Math.floor(num_months) + " เดือน\n");
	if (Math.floor(num_days) > 0)
		result += (" " + Math.floor(num_days) + " วัน");
	$("#txtDateDiff").val(result);

}
