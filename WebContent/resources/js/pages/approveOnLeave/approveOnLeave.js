$(document).ready(function() {

	if(userLogin == mailBoss){
		$('#tableEdit').hide();
		$('#textApproveUser').hide();
		$('#btnGoToRequest').hide();
		var table = $('#tableApprove').DataTable();

		renderDataTable();
	
		$(document).on('change','#status',function(){
			renderDataTable();
		});
				
		$(document).on('click','.btn-approve',function(){
			var rowID = $(this).attr('id');
			var status = "อนุมัติ";
			console.log(rowID, status);
			$.ajax({
				url: ctx + '/ApproveButtonSrvl',
				data: {
					status: status,
					rowID: rowID
				}
			});
			renderDataTable();
		});
		
		$(document).on('click','.btn-unapprove',function(){
			var rowID = $(this).attr('id');
			var status = "ไม่อนุมัติ";
			console.log(rowID, status);
			$.ajax({
				url: ctx + '/ApproveButtonSrvl',
				data: {
					status: status,
					rowID: rowID
				}
			});
			renderDataTable();
		});
		
		function renderDataTable() {
			var status = $('#status').val();
			var table = $('#tableApprove').DataTable();
			$('#tableApprove').DataTable( {	
				"order": [[5,'asc']],
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
		            { "data": "leaveType","className": "text-center" },
		            { "data": "status","className": "text-center" },
		            { "data": "requestDate","className": "text-center" },
		            { "data": "approveDate","className": "text-center" },
		            {
					    "orderable": false,
					    "data":		"code",
					    "className": "text-center",
					    render: function ( data, type, row ) { 
					    	return '<button class="btn-link" id="'+row.code+'" type="button" value="ดูเพิ่มเติม" onclick="dataFull(this);">คลิก</button>'
					    }
					},
		            {  	"orderable": false,
		            	"data": "code",
		            	"className": "text-center",
		            	render: function ( data, type, row ) {
		            		if(row.status == "อนุมัติ"){
		            			return '<button class="btn btn-xs btn-danger btn-unapprove" type="button" id="'+row.code+'" value="ไม่อนุมัติ">ไม่อนุมัติ</button>';
		            		}else if(row.status == "รออนุมัติ"){
		            			return '<button class="btn btn-xs btn-success btn-approve" type="button" id="'+row.code+'" value="อนุมัติ">อนุมัติ</button>&nbsp;&nbsp;<button class="btn btn-xs btn-danger btn-unapprove" type="button" id="'+row.code+'" value="ไม่อนุมัติ">ไม่อนุมัติ</button>';
		            		}else if(row.status == "ไม่อนุมัติ"){
		            			return '<button class="btn btn-xs btn-success btn-approve" type="button" id="'+row.code+'" value="อนุมัติ">อนุมัติ</button>';
		            		}
		            	} 
		            }
		        ],
		        "columnDefs": [{
		            "defaultContent": "-",
		            "targets": "_all"
		          }]
		       
		    } );
		}
	} else{
		$('#tableApprove').hide();
		$('#btnGoToReport').hide();
		$('#textApprove').hide();
		$('#statusname').hide();
		$('#status').hide();
		var table = $('#tableEdit').DataTable();
			$('#tableEdit').DataTable( {
				"order": [[5,'desc']],
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
				    { 
				    	"orderable": false,
				    	"data": "firstandlastname",
				    	"className": "text-center" 
				    },
				    { 
				    	"orderable": false,
				    	"data": "department",
				    	"className": "text-center" 
				    },
				    { 
				    	"orderable": false,
				    	"data": "position",
				    	"className": "text-center" 
				    },
				    { "data": "leaveType","className": "text-center" },
				    { "data": "status","className": "text-center" },
				    { "data": "requestDate","className": "text-center", "id": "+row.code+" },
				    { "data": "approveDate","className": "text-center" },
				    { 
				    	"orderable": false,
				    	"data": "code",
				    	"className": "text-center", 
				    	render: function ( data, type, row ) {
				    		if(row.status == "รออนุมัติ"){
				    			return '<button class="btn btn-xs btn-warning btn-block" type="button" id="'+row.code+'" onclick="editClick(this)" value="แก้ไข">แก้ไข</button>';
				    		}else{
				    			return '<button class="btn btn-xs btn-primary btn-block" type="button" id="'+row.code+'" onclick="editClick(this)" value="รายละเอียด">รายละเอียด</button>';
				    		}
				    	} 
				    } 
				  ],
				  "columnDefs": [{
					  "defaultContent": "-",
					  "targets": "_all"
				  }]
			} );
		}
	if (msgTimeout) {
		$('#msg-modal').modal();
	}
});
function editClick(obj){
	var rowID = $(obj).attr('id');
	location.href ='/testweb/LoadEditRequestOnLeaveSrvl?code='+rowID;
}
function dataFull(obj){
	var rowID = $(obj).attr('id');
	location.href ='/testweb/LoadEditRequestOnLeaveSrvl?code='+rowID;
}