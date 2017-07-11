<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <script type="text/javascript" src="resources/js/pages/login/forgotPwd.js"></script> -->
<title>Massage</title>
</head>
<div class="modal fade" id="myModalForgotPwd" role="dialog"><!-- modal box -->
    <div class="modal-dialog modal-md">
    	<!-- Modal content-->
        <div class="modal-content"> <!-- modal heading -->
        	<div class="modal-header bg-primary">
          		<button type="button" class="close" data-dismiss="modal">&times;</button>
          		<h3 id="modalTitleForgotPwdResult" class="modal-title text-center"><b>Warning !!!</b></h3>
        	</div>
        	<div class="modal-body text-center"> <!-- modal body -->
          		<h5 id="msgModalForgotPwdResult" class="text-center text-primary"></h5>
        	</div>
        	<div class="modal-footer bg-info"> 
          		<button type="button" class="btn btn-default" id="btnModalForgotPwdClose" data-dismiss="modal" onclick="checkResultClose()">Close</button>
        	</div>
      	</div>
    </div>
</div> 	
</html>