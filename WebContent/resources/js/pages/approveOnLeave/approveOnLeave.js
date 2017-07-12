$(document).ready(function() { 
    $('#tableApprove').dataTable({ 
    	"ajax": "resources/js/pages/approveOnLeave/arrays.txt", 
    	"columnDefs": [ 
    	{
            "targets": -1,
            "data": null,
            "defaultContent": "<button type='button'>คลิ๊ก</button>"
        	} 
    	]
    });
});


$(document).on('change','#status',function(){
	randerDataTable();
});
function randerDataTable(){
	var statusData = $('#status').val(); 
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
				dataType: "text",
				success: function(data) {
					
					}	      		
				}
	        
		});
      	
}
