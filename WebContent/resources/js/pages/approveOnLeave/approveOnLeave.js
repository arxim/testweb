$(document).ready(function() {
//  if(userLogin=="boss@gmail.com"){
	
	renderDataTable();
	function renderDataTable() {
		var status = $('#status').val();
		$('#tableApprove').DataTable( {
			"bProcessing": true,
		    "iDisplayLength": 10,
	        "serverSide": true,
	        "bDestroy": true,
	        "ajax": {
	            "url": ctx + "/ApproveSrvl",
	            "type": "POST",
	            "data": {
	            	status: status,
	            	process: 'ajax'
	            }
	        },
	        "columns": [
	            { "data": "requestDate" },
	            { "data": "firstname" },
	            { "data": "lastname" },
	            { "data": "department" },
	            { "data": "position" },
	            { "data": "leaveType" },
	            { "data": "status" },
	            { "data": "approveDate" },
	            { "data": "userId", render: function ( data, type, row ) {
	                return '<input type="button" class="btnApprove" value="อนุมัติ" />';
	            } }
	        ]
	    } );
	}
	
	
	$('#tableApprove').on('click','button',function(){
	     var data = $('#tableApprove').DataTable().row( $(this).parents('tr') ).data();
	     alert(data[1] +"'s salary is: "+ data[6]);
	});
	
	$(document).on('change','#status',function(){
//		var table = $('#tableApprove').DataTable();
//		var wantToSearch=$('#status').val();
//		table.search(wantToSearch).draw();
		renderDataTable();
	});
	
//	$('#tableApprove').on('dblclick','tr > td',function(){
//		console.log('click');
//		location.href = '/testweb/LoadRequestOnLeaveSrvl';
		
//		if ($(this).hasClass('selected')) {
//		    $(this).removeClass('selected');
//		    location.href='/testweb/LoadRequestOnLeaveSrvl';
//		}
//		else {
//		    table.$('tr.selected').removeClass('selected');
//		    $(this).addClass('selected');
//		}
//	});
	
	$('#tableApprove').on('dblclick', 'tbody tr', function () {
	    var dataRow = table.row($(this).closest('tr')).data();
		location.href = '/testweb/LoadRequestOnLeaveSrvl?userId=' + dataRow.userId;
	});
	
//  }
//  else{
//	$('#statusname').hide();
//	$('#status').hide();
//	$('#tableApprove').dataTable({ 
//		//user
//	});
//  }
});

function randerDataTable(){	
/*	var statusData = $('#status').val();
	if(statusData == ""){
		statusData = "pending";
	}
	else if(statusData == ""){
		statusData = "approve";
	}
		$('#tableApprove').dataTable({
			"iDisplayLength" : 10,
			"iDisplayStart" : 0,
			"sPaginationType" : "full_numbers",
			"bLengthChange" : true,
			"bProcessing" : true,
			"bDestroy" : true,
			"scrollX" : false, 
	        "ajax" : {
				type : "POST",
				url : ctx + "/ApproveSrvl",
				dataSrc : "data",
				data : {
					status : statusData
				},
				success: function(status) {
					var msg = status;
					}	      		
				}
		});*/
      	
}