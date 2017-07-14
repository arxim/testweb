$(document).ready(function(){
	$('#datepicker1').datepicker({
		format : "yyyy/mm/dd",
		autoclose : true,
		todayHighlight : true
	});
	$('#datepicker1').datepicker('setDate', 'now');
	$('#datepicker2').datepicker({
		format : "yyyy/mm/dd",
		autoclose : true,
		todayHighlight : true
	});
	$('#datepicker2').datepicker('setDate', 'now');
	$('#reportTable').dataTable({
		 "autoWidth": false
	});
	var table = $('#reportTable').DataTable();
	table.row.add( {
      "0":"1",
      "1":"อภิสิทธิ์",
      "2":"โชติรัตนอมรกิจ",
      "3":"แผนกA",
      "4":"ตำแหน่งB",
      "5":"ลาป่วย",
      "6":"2017/07/14",
      "7":"2017/07/15",
      "8":"<a href='#'>คลิกที่นี่</a>",
    } ).draw();
	table.row.add( {
      "0":"2",
      "1":"อุฟวย",
      "2":"โอซาส",
      "3":"แผนกC",
      "4":"ตำแหน่งA",
      "5":"ลาพักร้อน",
      "6":"2017/07/14",
      "7":"2017/07/18",
      "8":"<a href='#'>คลิกที่นี่</a>",
    } ).draw();
	table.row.add( {
      "0":"3",
      "1":"วอทด๊าส",
      "2":"เดอะฟ็อกเซย์",
      "3":"แผนกB",
      "4":"ตำแหน่งB",
      "5":"ลากิจ",
      "6":"2017/07/12",
      "7":"2017/07/13",
      "8":"<a href='#'>คลิกที่นี่</a>",
    } ).draw();
	table.row.add( {
      "0":"4",
      "1":"เช",
      "2":"สิบล้อ",
      "3":"แผนกC",
      "4":"ตำแหน่งA",
      "5":"ลาป่วย",
      "6":"2017/07/11",
      "7":"2017/07/13",
      "8":"<a href='#'>คลิกที่นี่</a>",
    } ).draw();
	table.row.add( {
      "0":"5",
      "1":"ดอท",
      "2":"ท๊อปมายซ่า",
      "3":"แผนกB",
      "4":"ตำแหน่งC",
      "5":"ลาพักร้อน",
      "6":"2017/07/12",
      "7":"2017/07/16",
      "8":"<a href='#'>คลิกที่นี่</a>",
    } ).draw();
//	$.fn.dataTableExt.afnFiltering.push(
//		    function( oSettings, aData, iDataIndex ) {
//		        var min = $('#datepicker1').val();
//		        var max = $('#datepicker2').val();
//		        var startDateCol = 6;
//		        var endDateCol = 7;
//		 
//		        min=min.substring(3,5) + min.substring(0,2)+ min.substring(6,10);
//		        max=max.substring(3,5) + max.substring(0,2)+ max.substring(6,10);
//		 
//		        var dataStartDate=aData[startDateCol].substring(3,5) + aData[startDateCol].substring(0,2)+ aData[startDateCol].substring(6,10);
//		        var dataEndDate=aData[endDateCol].substring(3,5) + aData[endDateCol].substring(0,2)+ aData[endDateCol].substring(6,10);
//		 
//		        if ( min === "" && max === "" ){
//		            return true;
//		        }
//		        else if ( min <= dataStartDate && max === ""){
//		            return true;
//		        }
//		        else if ( max >= dataEndDate && min === ""){
//		            return true;
//		        }
//		        else if ( min <= dataStartDate && max >= dataEndDate){
//		            return true;
//		        }
//		        return false;
//		    }
//		);
//	$('.date-range-filter').change( function() {
//		table.draw();
//	} );
});

function searchEngine(){
	var nameEmployee=$("#txtNameEmployee").val();
	var surnameEmployee=$("#txtSurnameEmployee").val();
	var departmentEmployee=$("#txtDepartmentEmployee").val();
	var positionEmployee=$("#txtPositionEmployee").val();
	var minDay=$("#txtMinDay").val();
	var maxDay=$("#txtMaxDay").val();
	var leaveType=$("#txtLeaveType").val();
	$.ajax({
	      type: 'POST',
	      url: ctx + '/ShowListReportDBSrvl',
	      data: {
	    	  nameEmployee: nameEmployee,
	    	  surnameEmployee: surnameEmployee,
	    	  departmentEmployee: departmentEmployee,
	    	  positionEmployee: positionEmployee,
	    	  minDay: minDay,
	    	  maxDay: maxDay,
	    	  leaveType: leaveType
	      },
	      dataType: "text",
	      success: function(data) { // found Email and send success
	    	  if(data=="true"){
//	    		  alert("true");
	    	  }
	    	  else{
//	    		  alert("false");
	    	  }
	  }
	});
	var table = $('#reportTable').DataTable();
	var wantToSearch=$("#txtNameEmployee").val()+" "+$("#txtSurnameEmployee").val()+" "+$("#txtDepartment").val()+" "+$("#txtPosition").val()+" "+$("#txtLeaveType").val();
	table.search(wantToSearch).draw();
}

