
$(document).ready(function () {
	if(pst == "หัวหน้าพนักงาน"){
		$("#fName").val(firstName);
		$("#lName").val(lastName);
		$("#comboDepartment").val(dpm);
		$("#comboPosition").val(pst);
		$("#txtemail").val(mail);
		$("#comboBoss").val(nameBoss);
		$("#comboTypeLeave").val(typeLeave);
		$("#startDate").val(start);
		$("#endDate").val(end);
		$("#txtDateDiff").val(diff);
		$("#txtAreaNote").val(note);
		
		$("#comboTypeLeave").prop('disabled', true);
		$("#startDate").prop('disabled', true);
		$("#endDate").prop('disabled', true);
		$("#txtAreaNote").prop('disabled', true);
		
		$('#btnSubmit').hide();
		$('#btnCancel').hide();
		$('#btnBackMainMenuUser').hide();
	}
	else{
		$("#fName").val(firstName);
		$("#lName").val(lastName);
		$("#comboDepartment").val(dpm);
		$("#comboPosition").val(pst);
		$("#txtemail").val(mail);
		$("#comboBoss").val(nameBoss);
		
		$('#btnApprove').hide();
		$('#btnNotAllowed').hide();
		$('#btnBackMainMenuBoss').hide();
	}
	
	$('#datepickerStart').datepicker({
		format:"yyyy/mm/dd",
		autoclose: true,
		todayHighlight : true
	});
	$('#datepickerEnd').datepicker({
		format:"yyyy/mm/dd",
		autoclose: true,
		todayHighlight : true
	});
	
});

function sendRequest() {
	if((!$("#txtemail").val() == "")&& (!$("#comboBoss").val() == "")&& (!$("#comboTypeLeave").val() == "")&& (!$("#startDate").val() == "")&& (!$("#endDate").val() == "")&& (!$("#txtDateDiff").val() == "")){
		var fName = $("#fName").val();
		var lName = $("#lName").val();
		var epyDepartment = $("#comboDepartment").val();
		var epyPosition = $("#comboPosition").val();
		var email = $("#txtemail").val(); 
		var nameBoss = $("#comboBoss").val(); 
		var typeLeave = $("#comboTypeLeave").val(); 
		var startDate = $("#startDate").val(); 
		var endDate = $("#endDate").val(); 
		var dateDiff = $("#txtDateDiff").val(); 
		var note = $("#txtAreaNote").val(); 
		$.ajax({
    	      type: 'POST',
    	      url: ctx + '/RequestOnLeaveSrvl',
    	      data: {
    	    	  fristName : fName,
    	    	  lastName : lName,
    	    	  comboDepartment : epyDepartment,
    	    	  comboPosition : epyPosition,
    	    	  txtemail : email,
    	    	  comboBoss : nameBoss,
    	    	  comboTypeLeave : typeLeave,
    	    	  startDate : startDate,
    	    	  endDate : endDate,
    	    	  txtDateDiff : dateDiff,
    	    	  txtAreaNote : note
    	      },
    	      success: function(data) {
    				$("#msgModalRequest").text("สำเร็จ!!");
    		    	$("#myModalRequest").modal("show");
    				$("#comboTypeLeave").val(""); 
    				$("#startDate").val(""); 
    				$("#endDate").val(""); 
    				$("#txtDateDiff").val(""); 
    				$("#txtAreaNote").val("");
    	      }
		});
	}else {
			$("#msgModalRequest").text("กรุณากรอกแบบฟอร์มให้ครบถ้วน");
	    	$("#myModalRequest").modal("show");
		}
}

function sendApprove(){
	var approve = "อนุมัติ";
	$.ajax({
	      type: 'POST',
	      url: ctx + '/RequestOnLeaveSrvl',
	      data: {
	    	  sendApprove : approve
	      },
	      success: function(data) {
	    	  if(data === "true"){
					$("#msgModalRequest").text("อนุมัติคำร้องขอสำเร็จ");
			    	$("#myModalRequest").modal("show");
		    	  }
		    	  else{
		    		$("#msgModalRequest").text("ERROR!!");
				    $("#myModalRequest").modal("show");  
		    	  }
	      }
	});
}

function sendNotAllowed(){
	var notAllowed = "ไม่อนุมัติ";
	$.ajax({
	      type: 'POST',
	      url: ctx + '/RequestOnLeaveSrvl',
	      data: {
	    	  sendNotAllowed : notAllowed
	      },
	      success: function(data) {
	    	  if(data === "true"){
				$("#msgModalRequest").text("คำร้องขอไม่ถูกอนุมัติ");
		    	$("#myModalRequest").modal("show");
	    	  }
	    	  else{
	    		$("#msgModalRequest").text("ERROR!!");
			    $("#myModalRequest").modal("show");  
	    	  }
	      }
	});
}

function cancelRequest(){
	$("#msgModalCancelRequest").text("คุณต้องการยกเลิกการกรอกแบบฟอร์มใช่หรือไม่");
	$("#myModalCancelRequest").modal("show");
}

function comfirm(){
	location.reload();
}

function dateDiff(){
	var strStart = $("#startDate").val();
	var strStop = $("#endDate").val();
	
	var first_date = Date.parse(strStart);
	var last_date = Date.parse(strStop);
	var diff_date =  last_date - first_date;
	
//	var num_years = diff_date/(365.25 * 24 * 60 * 60 * 1000);
//	var num_months = (diff_date % (365.25 * 24 * 60 * 60 * 1000))/(365.25 / 12 * 24 * 60 * 60 * 1000);
//	var num_days = ((diff_date % (365.25 * 24 * 60 * 60 * 1000)) % (365.25 / 12 * 24 * 60 * 60 * 1000))/86400000+1;
	
	var num_days = diff_date/86400000+1;
	
	var result ="";
//	if (Math.floor(num_years) > 0)
//		result += (" " + Math.floor(num_years) + " ปี\n");
//	if (Math.floor(num_months) > 0)
//		result += (" " + Math.floor(num_months) + " เดือน\n");
	if (Math.floor(num_days) > 0)
		result += Math.floor(num_days);
	$("#txtDateDiff").val(result);

}
