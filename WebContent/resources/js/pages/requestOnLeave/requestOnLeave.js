
$(document).ready(function () {
	if(userLogin == mailBoss){
		$("#txtstatus").text(status);
		$("#fName").val(firstName);
		$("#lName").val(lastName);
		$("#comboDepartment").val(dpm);
		$("#comboPosition").val(pst);
		$("#txtemail").val(mail);
		$("#comboBoss").val(nameBoss);
		$("#comboTypeLeave").val(typeLeave);
		$("#startDate").val(start);
		$("#endDate").val(end);
		$("#txtDateDiff").text(diff);
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
		$("#txtstatus").text(status);
		$("#fName").val(firstName);
		$("#lName").val(lastName);
		$("#comboDepartment").val(dpm);
		$("#comboPosition").val(pst);
		$("#txtemail").val(mail);
		$("#comboBoss").val(nameBoss);
		
		$("#comboTypeLeave").val(typeLeave);
		$("#startDate").val(start);
		$("#endDate").val(end);
		$("#txtDateDiff").text(diff);
		$("#txtAreaNote").val(note);
		
		$('#btnApprove').hide();
		$('#btnNotAllowed').hide();
		$('#btnBackMainMenuBoss').hide();
		
	}
	
	if($('#txtstatus').text() == 'อนุมัติ')
		$('#txtstatus').css('color', 'green');
	else if($('#txtstatus').text() == 'ไม่อนุมัติ')
		$('#txtstatus').css('color', 'red');
	else
		$('#txtstatus').css('color', 'black');
	
	$('#datepickerStart').datepicker({
		format:"dd MM yyyy",
		autoclose: true,
		todayHighlight : true
	});
	$('#datepickerEnd').datepicker({
		format:"dd MM yyyy",
		autoclose: true,
		todayHighlight : true
	});
	
	
	
});

function sendRequest() {
	if((!$("#txtemail").val() == "")&& (!$("#comboBoss").val() == "")&& (!$("#comboTypeLeave").val() == "")&& (!$("#startDate").val() == "")&& (!$("#endDate").val() == "")&& (!$("#txtDateDiff").text() == "")){
		var fName = $("#fName").val();
		var lName = $("#lName").val();
		var epyDepartment = $("#comboDepartment").val();
		var epyPosition = $("#comboPosition").val();
		var email = $("#txtemail").val(); 
		var nameBoss = $("#comboBoss").val(); 
		var typeLeave = $("#comboTypeLeave").val(); 
		var startDate = $("#startDate").val(); 
		var endDate = $("#endDate").val(); 
		var dateDiff = $("#txtDateDiff").text(); 
		var note = $("#txtAreaNote").val(); 
		if(code == ""){
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
    				$("#msgModalRequest").text("สำเร็จ");
    		    	$("#myModalRequest").modal("show");
    	      }
		});
		}
		else{
			$.ajax({
	    	      type: 'POST',
	    	      url: ctx + '/EditRequestOnLeaveSrvl',
	    	      data: {
	    	    	  sendCode : code,
	    	    	  comboTypeLeave : typeLeave,
	    	    	  startDate : startDate,
	    	    	  endDate : endDate,
	    	    	  txtDateDiff : dateDiff,
	    	    	  txtAreaNote : note
	    	      },
	    	      success: function(data) {
	    				$("#msgModalRequest").text("แก้ไขแบบคำร้องสำเร็จ");
	    		    	$("#myModalRequest").modal("show");
	    	      }
		});
		}
	}else {
			$("#msgModalRequest").text("กรุณากรอกแบบฟอร์มให้ครบถ้วน");
	    	$("#myModalRequest").modal("show");
		}
	
}

function sendApprove(){
	var approve = "อนุมัติ";
	$.ajax({
	      type: 'POST',
	      url: ctx + '/EditRequestOnLeaveSrvl',
	      data: {
	    	  sendCode : code,
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
	      url: ctx + '/EditRequestOnLeaveSrvl',
	      data: {
	    	  sendCode : code,
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

function btnClose(){
	if($("#msgModalRequest").text()=="สำเร็จ")
		location.href="/testweb/ApproveSrvl";
	else if($("#msgModalRequest").text()=="แก้ไขแบบคำร้องสำเร็จ")
		location.href="/testweb/ApproveSrvl";
	else if($("#msgModalRequest").text()=="อนุมัติคำร้องขอสำเร็จ")
		location.href="/testweb/ApproveSrvl";
	else if($("#msgModalRequest").text()=="คำร้องขอไม่ถูกอนุมัติ")
		location.href="/testweb/ApproveSrvl";
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
	
	var num_days = diff_date/86400000+1;
	
	var result ="";
	if (Math.floor(num_days) > 0)
		result += Math.floor(num_days);
	$("#txtDateDiff").text(result);

}
