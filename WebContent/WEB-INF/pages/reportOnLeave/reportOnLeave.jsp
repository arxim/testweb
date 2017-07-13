<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Report</title>
	<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
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
				    	<h4 class="panel-title"><b>รายงานแสดงการลาของพนักงาน</b></h4>
				 	</div>
				    <div class="panel-body">
				    	<div class="dataSearch-heading text-center">
				   		 	 <div class="form-group">
					   		 	 <div class="col-xs-4 col-sm-2">
					   		 	 	 <p class="text-center">
					   		 	 	 	 <b>ชื่อ</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-4">
						      	 	 <input id="txtNameEmployee" class="form-control" type="text" name="txtNameEmployee" placeholder="ชื่อ" maxlength="50">
						      	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						      	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>นามสกุล</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-4">
									 <input id="txtSurnameEmployee" class="form-control" type="text" name="txtSurnameEmployee" placeholder="นามสกุล" maxlength="50">
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
					   		 	 	 	 <b>แผนก</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-4">
						      	 	 <select id="txtDepartment" name="txtDepartment" class="form-control">
										<option value="แผนกA">แผนกA</option>
										<option value="แผนกB">แผนกB</option>
										<option value="แผนกC">แผนกC</option>
									 </select>
									 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						      	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>ตำแหน่ง</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-4">
						      	 	 <select id="txtPosition" name="txtPosition" class="form-control">
										<option value="ตำแหน่งA">ตำแหน่งA</option>
										<option value="ตำแหน่งB">ตำแหน่งB</option>
										<option value="ตำแหน่งC">ตำแหน่งC</option>
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
					   		 	 	 	 <b>ประเภทลา</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-4">
						      	 	 <select id="txtLeaveType" name="txtLeaveType" class="form-control">
										<option value="ลาป่วย">ลาป่วย</option>
										<option value="ลากิจ">ลากิจ</option>
										<option value="ลาพักร้อน">ลาพักร้อน</option>
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
					   		 	 	 	 <b>วันที่</b>
					   		 	 	 </p>
						      	</div>
						     	<div class="col-xs-8 col-sm-4">
							     	 <div class="form-group">
						                <div class='input-group date' id='datepicker1'>
						                    <input id="txtMinDay" class="form-control date-range-filter" type="text" name="txtMinDay" maxlength="50">
						                    <span class="input-group-addon" id="iconDate1">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						             </div>
						      	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						      	 <div class="col-xs-4 col-sm-2">
						      	     <p class="text-center">
					   		 	 	 	 <b>ถึง</b>
					   		 	 	 </p>
						      	</div>
						     	<div class="col-xs-8 col-sm-4">
							     	 <div class="form-group">
						                <div class='input-group date' id='datepicker2'>
						                    <input id="txtMaxDay" class="form-control date-range-filter" type="text" name="txtMaxDay" maxlength="50">
						                    <span class="input-group-addon" id="iconDate2">
						                        <span class="glyphicon glyphicon-calendar"></span>
						                    </span>
						                </div>
						             </div>
						      	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						      	 </div>
						     </div>
						     <div class="form-group">
						     	 <div class="col-xs-12 col-sm-12 text-center">
							     	 <button type="button" class="btn btn-primary text-white" id="btnSearchReport" onclick="searchEngine()" >ค้นหา</button>&nbsp
							     	 <button type="button" class="btn btn-primary text-white" id="btnCancelSearchReport" onclick="location.href='/testweb/LoadReportOnLeaveSrvl'" >ยกเลิก</button>&nbsp
							     	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
							     	 <button type="button" class="btn btn-primary text-white" id="btnGoToMain" onclick="location.href='/testweb/LoadMainMenuSrvl'" >กลับสู่หน้าหลัก</button>
						     	 	 <div class="visible-xs">
						      	 		<br>
						      	 	 </div>
						     	 </div>
						     </div>
						     <div class="form-group">
						     	<div class="col-xs-12 col-sm-12 text-center">
						     		<table id="reportTable" class="table table-responsive table-bordered dt-responsive nowrap table-hover" style="width: 100%">
							     		<thead>
							     			 <tr>
								                <th class="text-center">ลำดับ</th>
								                <th class="text-center">ชื่อ</th>
								                <th class="text-center">นามสกุล</th>
								                <th class="text-center">แผนก</th>
								                <th class="text-center">ตำแหน่ง</th>
								                <th class="text-center">ประเภทการลา</th>
								                <th class="text-center">วันเริ่มต้นลา</th>
								                <th class="text-center">วันสิ้นสุดลา</th>
								                <th class="text-center">ใบลา</th>
								             </tr>
								         </thead>
						     		</table>
						        </div>
						     </div>
					    </div>
				    </div>
				</div>
			</div>	
		</div>
</body>
</html>