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
		
		$('#btnBack').hide();
		$('#btnSubmit').hide();
		$('#btnCancel').hide();
		
		if( $('#txtstatus').text() == 'อนุมัติ')
			$('#txtstatus').css('color', 'green');
		else if($('#txtstatus').text() == 'ไม่อนุมัติ')
			$('#txtstatus').css('color', 'red');
		else
			$('#txtstatus').css('color', 'blue');
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
		
		$('#btnBack').hide();
		$('#btnApprove').hide();
		$('#btnNotAllowed').hide();
		$('#btnBackMainMenuBoss').hide();
		
		if(!$("#comboTypeLeave").val()==""){
			$("#txtHead").text("แก้ไขคำร้องรอลา");
			$('#btnSubmit').text("แก้ไขข้อมูล");
		}
		else
			$("#txtstatus").text("ระหว่างดำเนินการ");
		
		if( $('#txtstatus').text() == 'อนุมัติ'){
			$('#txtstatus').css('color', 'green');
			$("#comboTypeLeave").prop('disabled', true);
			$("#startDate").prop('disabled', true);
			$("#endDate").prop('disabled', true);
			$("#txtAreaNote").prop('disabled', true);
			$('#btnSubmit').hide();
			$('#btnCancel').hide();
			$('#btnBack').show();
		}
		else if($('#txtstatus').text() == 'ไม่อนุมัติ'){
			$('#txtstatus').css('color', 'red');
			$("#comboTypeLeave").prop('disabled', true);
			$("#startDate").prop('disabled', true);
			$("#endDate").prop('disabled', true);
			$("#txtAreaNote").prop('disabled', true);
			$('#btnSubmit').hide();
			$('#btnCancel').hide();
			$('#btnBack').show();
		}
		else
			$('#txtstatus').css('color', 'blue');
	}
	
	$('#datepickerStart').datepicker({
		format:"dd/mm/yyyy",
		autoclose: true,
		todayHighlight : true
	});
	$('#datepickerEnd').datepicker({
		format:"dd/mm/yyyy",
		autoclose: true,
		todayHighlight : true
	});
});

function sendRequest() {
	if((!$("#txtemail").val() == "")&& (!$("#comboBoss").val() == "")&& (!$("#comboTypeLeave").val() == "")&& (!$("#startDate").val() == "")&& (!$("#endDate").val() == "")&& (!$("#txtDateDiff").text() == "")){
		$("#comboTypeLeave").prop('disabled', true);
		$("#startDate").prop('disabled', true);
		$("#endDate").prop('disabled', true);
		$("#txtAreaNote").prop('disabled', true);
		$('#btnSubmit').prop('disabled', true);
		$('#btnCancel').prop('disabled', true);
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
    	    	  firstName : fName,
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
    	    	  if(data === "true"){
    				$("#msgModalRequest").text("สำเร็จ");
    		    	$("#myModalRequest").modal("show");
    	    	  }
    	    	  else{
    	    		  $("#msgModalRequest").text(data);
      		    	$("#myModalRequest").modal("show");
    	    	  }
    	      }
		});
		}
		else{
			$.ajax({
	    	      type: 'POST',
	    	      url: ctx + '/EditRequestOnLeaveSrvl',
	    	      data: {
	    	    	  sendCode : code,
	    	    	  firstName : fName,
	    	    	  lastName : lName,
	    	    	  comboTypeLeave : typeLeave,
	    	    	  startDate : startDate,
	    	    	  endDate : endDate,
	    	    	  txtDateDiff : dateDiff,
	    	    	  txtAreaNote : note
	    	      },
	    	      success: function(data) {
	    	    	  if(data === "true"){
	    				$("#msgModalRequest").text("แก้ไขแบบคำร้องสำเร็จ");
	    		    	$("#myModalRequest").modal("show");
	    	    	  }
	    	    	  else{
	    	    		  $("#msgModalRequest").text(data);
		    		      $("#myModalRequest").modal("show");
	    	    	  }
	    	      }
		});
		}
	}else {
			$("#msgModalRequest").text("กรุณากรอกแบบฟอร์มให้ครบถ้วน");
	    	$("#myModalRequest").modal("show");
		}
}

function sendApprove(){
	$('#btnApprove').prop('disabled', true);
	$('#btnNotAllowed').prop('disabled', true);
	$('#btnBackMainMenuBoss').prop('disabled', true);
	var approve = "อนุมัติ";
	var email = $("#txtemail").val(); 
	$.ajax({
	      type: 'POST',
	      url: ctx + '/EditRequestOnLeaveSrvl',
	      data: {
	    	  sendCode : code,
	    	  sendApprove : approve,
	    	  email : email
	      },
	      success: function(data) {
	    	  if(data === "true"){
					$("#msgModalRequest").text("อนุมัติคำร้องขอสำเร็จ");
			    	$("#myModalRequest").modal("show");
		    	  }
		    	  else{
		    		$("#msgModalRequest").text(data);
				    $("#myModalRequest").modal("show"); 
				    $('#btnApprove').prop('disabled', false);
					$('#btnNotAllowed').prop('disabled', false);
					$('#btnBackMainMenuBoss').prop('disabled', false);
		    	  }
	      }
	});
}

function sendNotAllowed(){
	$('#btnApprove').prop('disabled', true);
	$('#btnNotAllowed').prop('disabled', true);
	$('#btnBackMainMenuBoss').prop('disabled', true);
	var notAllowed = "ไม่อนุมัติ";
	var email = $("#txtemail").val();
	$.ajax({
	      type: 'POST',
	      url: ctx + '/EditRequestOnLeaveSrvl',
	      data: {
	    	  sendCode : code,
	    	  sendNotAllowed : notAllowed,
	    	  email : email
	      },
	      success: function(data) {
	    	  if(data === "true"){
				$("#msgModalRequest").text("ไม่อนุมัติคำร้องขอ");
		    	$("#myModalRequest").modal("show");
	    	  }
	    	  else{
	    		$("#msgModalRequest").text(data);
			    $("#myModalRequest").modal("show"); 
			    $('#btnApprove').prop('disabled', false);
				$('#btnNotAllowed').prop('disabled', false);
				$('#btnBackMainMenuBoss').prop('disabled', false);
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
	else if($("#msgModalRequest").text()=="ไม่อนุมัติคำร้องขอ")
		location.href="/testweb/ApproveSrvl";
}

function dateDiff(){
	var strStart = $("#startDate").val();
	var strStop = $("#endDate").val();
	
	strStart = strStart.substr(3,2)+"/"+strStart.substr(0,2)+"/"+strStart.substr(6,9);
	strStop = strStop.substr(3,2)+"/"+strStop.substr(0,2)+"/"+strStop.substr(6,9);

	var first_date = Date.parse(strStart);
	var last_date = Date.parse(strStop);
	var diff_date =  last_date - first_date;
	
	var num_days = diff_date/86400000+1;
	
	var result ="";
	if (Math.floor(num_days) > 0)
		result += Math.floor(num_days);
	$("#txtDateDiff").text(result);
}
