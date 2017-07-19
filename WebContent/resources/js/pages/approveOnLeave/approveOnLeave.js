$(document).ready(function() {
	if(userLogin=="boss@gmail.com"){
		$('#textApproveUser').hide();
		$('#btnGoToRequest').hide();
	var table = $('#tableApprove').DataTable();
	renderDataTable();
	
	function renderDataTable() {
		var status = $('#status').val();
		$('#tableApprove').DataTable( {			
			"bProcessing": true,
		    "iDisplayLength": 10,
	        "serverSide": false,
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
	            { "data": "code", render: function ( data, type, row ) {
	            	if(status == "อนุมัติ"){
	            		return '<button type="button" value="ไม่อนุมัติ">ไม่อนุมัติ</button>';
	            	}
	            	else if(status == "รออนุมัติ"){
	            		return '<button type="button" value="อนุมัติ">อนุมัติ</button>';
	            	}
	            } }
	        ]
	       
	    } );
	}
	
	$(document).on('change','#status',function(){
		renderDataTable();
	});
	
	$('#tableApprove').on('click','tr > td',function(){
	
	});	
	$('#tableApprove').on('click', 'button', function () {
	    var dataRow = table.row($(this).closest('tr')).data();
	    
	    $('#tableApprove').DataTable( {	
	        "ajax": {
	            "url": ctx + "/ApproveButtonSrvl",
	            "type": "POST",
	            "data": {
	            	status: status,
	            	code: code,
	            	process: 'ajax'
	            }
	        },
  	      dataType: "text",
	      success: function(data) {
	    	 
	      }
	    } );
	    
	    
	    
	//	location.href = '/testweb/LoadRequestOnLeaveSrvl?userId=' + dataRow.userId;
	});	
  }
  else{
	$('#textApprove').hide();
	$('#statusname').hide();
	$('#status').hide();
	var table = $('#tableApprove').DataTable();

		$('#tableApprove').DataTable( {			
			"bProcessing": true,
		    "iDisplayLength": 10,
	        "serverSide": false,
	        "bDestroy": true,
	        "ajax": {
	            "url": ctx + "/ApproveUserSrvl",
	            "type": "POST",
	            "data": {
	            	userLogin: userLogin,
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
	            { "data": "code", render: function ( data, type, row ) {	
	               $('#tableApprove').on( 'click', 'button', function () {
	                    var dataRow = table.row( $(this).closest('button') ).data();
	                    location.href ='/testweb/LoadEditRequestOnLeaveSrvl?code='+data;
	                } );
	            	return '<button type="button" id="'+data+'" value="แก้ไข">แก้ไข</button>';
	            		
	            } } 
	        ]
	    } );
	/*	$('#tableApprove').on('click', 'button', function () {
		    var dataRow = table.row($(this).closest('code')).data();
			location.href = '/testweb/LoadEditRequestOnLeaveSrvl?code=' + dataRow;
		});	*/
	/*	$('#tableApprove').on('dblclick','tr > td',function(){
			console.log('click');
			location.href = "LoadEditRequestOnLeaveSrvl?code=' + code'";		
			if ($(this).hasClass('selected')) {
			    $(this).removeClass('selected');
			    location.href="LoadEditRequestOnLeaveSrvl?code=' + code'";
			}
			else {
			    table.$('tr.selected').removeClass('selected');
			    $(this).addClass('selected');
			}	
		});*/

	}
});

