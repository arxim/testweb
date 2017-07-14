$(document).ready(function() {
  if(userLogin=="boss@gmail.com"){
	$(document).on('change','#status',function(){
		var table = $('#tableApprove').DataTable();
		var wantToSearch=$('#status').val();
		table.search(wantToSearch).draw();
	});
		var table = $('#tableApprove').dataTable({
			//boss
			"ajax": "resources/js/pages/approveOnLeave/arrays.txt", 
			"columnDefs": 
				[{
					targets: -1,
					data: null,
					defaultContent: "<button id='btnStatus' type='button'>คลิ๊ก</button>"
				}]
		});
	
	$('#tableApprove').on('click','button',function(){
	     var data = table.row( $(this).parents('tr') ).data();
	     alert(data[1] +"'s salary is: "+ data[6]);
	});
	$('#tableApprove').on('click','tr',function(){
		if ($(this).hasClass('selected')) {
		    $(this).removeClass('selected');
		    location.href='/testweb/LoadRequestOnLeaveSrvl';
		}
		else {
		    table.$('tr.selected').removeClass('selected');
		    $(this).addClass('selected');
		}
	});
  }
  else{
	$('#statusname').hide();
	$('#status').hide();
	$('#tableApprove').dataTable({ 
		//user
	});
  }
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