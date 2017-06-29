function logoutUser(){
	$.ajax
    ({
        url: ctx + '/LogoutSrvl',
        success: function(response){
        	location.href = ctx + '/index.jsp';
//        	if(response === "OK")
//        		location.href = ctx + '/index.jsp';  
//        	else{
//        		var msg = 'ERROR';
//  		  		$("#msgModalLoginResult").text(msg);
//  		  		$("#myModalLogin").modal("show");
//        	}
        	}
    });
}