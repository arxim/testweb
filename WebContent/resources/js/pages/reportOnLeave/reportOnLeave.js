$(document).ready(function(){
	$('#datepicker1').datepicker({
		format : "dd/mm/yyyy",
		autoclose : true,
		todayHighlight : true
	});
	$('#datepicker1').datepicker('setDate','now');
	$('#datepicker2').datepicker({
		format : "dd/mm/yyyy",
		autoclose : true,
		todayHighlight : true
	});
	$('#datepicker2').datepicker('setDate','now');
	$('#reportTable').dataTable({
		 "autoWidth": false,
		 "searching": false,
		 "serverSide": false
	});
});

function searchEngine(){
	var nameEmployee=$("#txtNameEmployee").val();
	var surnameEmployee=$("#txtSurnameEmployee").val();
	var departmentEmployee=$("#txtDepartmentEmployee").val();
	var positionEmployee=$("#txtPositionEmployee").val();
	var minDay=$("#txtMinDay").val();
	var maxDay=$("#txtMaxDay").val();
	var leaveType=$("#txtLeaveType").val();
	$('#reportTable').DataTable( {
		"autoWidth": false,
		"searching": false,
		"bProcessing": true,
		"serverSide": false,
	    "iDisplayLength": 10,
        "bDestroy": true,
		"ajax":{
		      type: 'POST',
		      url: ctx + '/ShowListReportDBSrvl',
		      data: {
		    	  nameEmployee: nameEmployee,
		    	  surnameEmployee: surnameEmployee,
		    	  departmentEmployee: departmentEmployee,
		    	  positionEmployee: positionEmployee,
		    	  minDay: minDay,
		    	  maxDay: maxDay,
		    	  leaveType: leaveType,
		    	  process: 'ajax'
		      }
		},
		"columnDefs": [    
		               {"className": "dt-body-left", "targets": [1]},
		               {"className": "dt-center", "targets": [0,2,3,4,5,6,7]},
		               {"className": "dt-right", "targets": []},
		             ],
		"columns": [
		            { "data": "userNo" },
		            { "data": "firstandlastname" },
		            { "data": "department" },
		            { "data": "position" },
		            { "data": "leaveType" },
		            { "data": "startDate" },
		            { "data": "endDate" },
		            { "data": "clickhere", render: function ( data, type, row ) {
		                return '<a href="#">คลิกที่นี่</a>';
		            } }
		        ]
	});
}

