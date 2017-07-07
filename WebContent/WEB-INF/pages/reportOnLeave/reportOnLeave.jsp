<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Report</title>
	<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	<jsp:include page="/resources/js/pages/reportOnLeave/reportTable.jsp"></jsp:include>
	<script type="text/javascript">
		var ctx = '${pageContext.request.contextPath}';
	</script>
	<script type="text/javascript" src="resources/js/pages/reportOnLeave/reportOnLeave.js"></script>
</head>
<body class="bg-info">
	<div class="container" style="margin-top:10%; margin-bottom:12%;">
			<div class="col-xs-12 col-sm-12">
				<div class="panel panel-primary text-center">
				    <div class="panel-heading">
				    	<h4 class="panel-title"><b>à¸£à¸²à¸¢à¸à¸²à¸à¸à¸²à¸£à¸à¸³à¹à¸£à¸·à¹à¸­à¸à¸¥à¸²à¸à¸­à¸à¸à¸¸à¸à¸¥à¸²à¸à¸£</b></h4>
				 	</div>
				    <div class="panel-body">
				    	<div class="dataSearch-heading text-center">
				   		 	 <div class="form-group">
					   		 	 <div class="col-xs-4 col-sm-2">
					   		 	 	 <p class="text-center">
					   		 	 	 	 <b>à¸à¸·à¹à¸­</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-4">
						      	 	 <input id="txtNameEmployee" class="form-control" type="text" name="txtNameEmployee" placeholder="à¸à¸·à¹à¸­" maxlength="50">
						      	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						      	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>à¸à¸²à¸¡à¸ªà¸à¸¸à¸¥</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-4">
									 <input id="txtSurnameEmployee" class="form-control" type="text" name="txtSurnameEmployee" placeholder="à¸à¸²à¸¡à¸ªà¸à¸¸à¸¥" maxlength="50">
						      		 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						     </div>
						     <br>
						     <br>
						     <br>
						     <div class="form-group">
					   		 	 <div class="col-xs-4 col-sm-2">
					   		 	 	 <p class="text-center">
					   		 	 	 	 <b>à¹à¸à¸à¸</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-4">
						      	 	 <select id="txtDepartment" name="txtDepartment" class="form-control">
										<option value="departmentA">à¹à¸à¸à¸ A</option>
										<option value="departmentB">à¹à¸à¸à¸ B</option>
										<option value="departmentC">à¹à¸à¸à¸ C</option>
									 </select>
									 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						      	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>à¸à¸³à¹à¸«à¸à¹à¸</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-4">
						      	 	 <select id="txtPosition" name="txtPosition" class="form-control">
										<option value="positionA">à¸à¸³à¹à¸«à¸à¹à¸ A</option>
										<option value="positionB">à¸à¸³à¹à¸«à¸à¹à¸ B</option>
										<option value="positionC">à¸à¸³à¹à¸«à¸à¹à¸ C</option>
									 </select>
									 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
					   		 	 <div class="col-xs-4 col-sm-2">
					   		 	 	 <p class="text-center">
					   		 	 	 	 <b>à¸à¸£à¸°à¹à¸ à¸</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-4">
						      	 	 <select id="txtLeaveType" name="txtLeaveType" class="form-control">
										<option value="sickLeave">à¸¥à¸²à¸à¹à¸§à¸¢</option>
										<option value="à¸³rrand">à¸¥à¸²à¸à¸´à¸</option>
										<option value="positionC">à¸¥à¸²à¸à¸±à¸à¸£à¹à¸­à¸</option>
									 </select>
									 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
						     	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>à¸§à¸±à¸à¸à¸µà¹</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-4">
									 <input id="txtStartDay" class="form-control" type="text" name="txtStartDay" placeholder="à¸§à¸±à¸à¸à¸µà¹" maxlength="50">
						      	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						      	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>à¸à¸¶à¸</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-4">
									 <input id="txtFinishDay" class="form-control" type="text" name="txtFinishDay" placeholder="à¸à¸¶à¸" maxlength="50">
						      	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						     </div>
						     <br>
						     <br>
						     <div class="form-group">
						     	 <div class="col-xs-12 col-sm-12 text-center">
							     	 <button type="button" class="btn btn-primary text-white" id="btnSearchReport" onclick="" >à¸à¹à¸à¸«à¸²</button>&nbsp
							     	 <button type="button" class="btn btn-primary text-white" id="btnCancelSearchReport" onclick="location.href='/testweb/LoadReportOnLeaveSrvl'" >à¸¢à¸à¹à¸¥à¸´à¸</button>
						     	 </div>
						     </div>
						    
					    </div>
				    </div>
				</div>
			</div>	
		</div>
</body>
</html>