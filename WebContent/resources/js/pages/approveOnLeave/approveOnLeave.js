$(document).ready(function() {
	if(userLogin=="boss@gmail.com"){
		$('#textApproveUser').hide();
		$('#btnGoToRequest').hide();
	var table = $('#tableApprove').DataTable();
	renderDataTable();
	function renderDataTable() {
		var status = $('#status').val();
		$('#tableApprove').DataTable( {	
			"searching": false,
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
	            { "data": "firstandlastname" },
	            { "data": "department" },
	            { "data": "position" },
	            { "data": "leaveType" },
	            { "data": "status" },
	            { "data": "requestDate" },
	            { "data": "approveDate" },
	            { "data": "code", render: function ( data, type, row ) {
	            	if(row.status == "อนุมัติ"){
	            		return '<button type="button" id="'+row.code+'" onclick="unApproveClick(this)" value="ไม่อนุมัติ">ไม่อนุมัติ</button>';
	            	}
	            	else if(row.status == "รออนุมัติ"){
	            		return '<button type="button" id="'+row.code+'" onclick="approveClick(this)" value="อนุมัติ">อนุมัติ</button>';
	            	}
	            } }
	        ],
	        "columnDefs": [{
	            "defaultContent": "-",
	            "targets": "_all"
	          }]
	       
	    } );
	}
	
	$(document).on('change','#status',function(){
		renderDataTable();
	});
	//click button
	function unapproveClick(obj){
		  var rowID = $(obj).attr('id');
		  var status = "อนุมัติ";
		  $('#tableApprove').DataTable( {	
		        "ajax": {
		        	type: 'POST',
		    	    url: ctx + "/ApproveButtonSrvl",
		    	    data: {
		    	    	status: status,
		            	rowID: rowID
		            }
		  
		      }
		    } );
		  $('#tableApprove').DataTable();
	}

	function approveClick(obj){
		var rowID = $(obj).attr('id');

		  $('#tableApprove').DataTable( {	
		        "ajax": {
		        	type: 'POST',
		    	    url: ctx + "/ApproveButtonSrvl",
		    	    data: {
		    	    	status: status,
		            	rowID: rowID
		            }
		  
		      }
		    } );
		  $('#tableApprove').DataTable();
		  
	}
/*	$('#tableApprove').on('click', 'button', function () {
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
	});		*/
  }
  else{
	$('#textApprove').hide();
	$('#statusname').hide();
	$('#status').hide();
	var table = $('#tableApprove').DataTable();

		$('#tableApprove').DataTable( {	
			"searching": false,
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
	            { "data": "firstandlastname" },
	            { "data": "department" },
	            { "data": "position" },
	            { "data": "leaveType" },
	            { "data": "status" },
	            { "data": "requestDate" },
	            { "data": "approveDate" },
	            { "data": "code", render: function ( data, type, row ) {
	               return '<button type="button" id="'+row.code+'" onclick="editClick(this)" value="แก้ไข">แก้ไข</button>';
	            } } 
	        ],
	        "columnDefs": [{
	            "defaultContent": "-",
	            "targets": "_all"
	          }]
	    } );
		
		
	/*      $('#tableApprove').on( 'click', 'button', function () {
	            //       var dataRow = table.row( $(this).closest('button') ).data();
	                   location.href ='/testweb/LoadEditRequestOnLeaveSrvl?code='+data;
	               } );	*/
	}
});

function editClick(obj){
	  var rowID = $(obj).attr('id');
	  location.href ='/testweb/LoadEditRequestOnLeaveSrvl?code='+rowID;
}

