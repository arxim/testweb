<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>ประวัติการลา</title>
	<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	<script type="text/javascript">
		var ctx = '${pageContext.request.contextPath}';
	</script>
	<script type="text/javascript" src="resources/js/pages/reportOnLeave/reportOnLeave.js"></script>
</head>
<body class="bg-info">
	<div class="container" style="margin-top:10%; margin-bottom:12%;">
			<div class="col-xs-12 col-sm-12 text-right">
				<h5>Welcome : ${sessionScope.userLogin}</h5>
			</div>
			<div class="col-xs-12 col-sm-12">			
				<div class="panel panel-primary text-center">
				    <div class="panel-heading">
				    	<h5 class="panel-title"><b>ประวัติการลาของพนักงาน</b></h5>
				 	</div>
				    <div class="panel-body">
				    	<div class="dataSearch-heading form-horizontal">
							<div class="row container">
								<div class="col-xs-4 col-sm-2 control-label">
									 <p class="text-right">
					   		 	 	 	 <b>ชื่อพนักงาน</b>
					   		 	 	 </p>
								</div>
								<div class="col-xs-8 col-sm-3">
									<input id="txtNameEmployee" class="form-control" type="text" name="txtNameEmployee" placeholder="ชื่อ" maxlength="50">
									<div class="visible-xs">
										<br>
									</div>
								</div>
								<div class="col-xs-4 col-sm-2 control-label">
						      	     <p class="text-right">
					   		 	 	 	 <b>นามสกุล</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-3">
									 <input id="txtSurnameEmployee" class="form-control" type="text" name="txtSurnameEmployee" placeholder="นามสกุล" maxlength="50">
						      	 </div>
							</div>
							<br>
							<div class="row container">
								<div class="col-xs-4 col-sm-2 control-label">
					   		 	 	 <p class="text-right">
					   		 	 	 	 <b>แผนก</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-3">
						      	 	 <select id="txtDepartmentEmployee" name="txtDepartmentEmployee" class="form-control">
						      	 	    <option value="">ทั้งหมด</option>
										<option value="บริหารจัดการ">บริหารจัดการ</option>
										<option value="พัฒนาผลงาน">พัฒนาผลงาน</option>
										<option value="บัญชีและการเงิน">บัญชีและการเงิน</option>
										<option value="บุคคล">บุคคล</option>
										<option value="ประชาสัมพันธ์">ประชาสัมพันธ์</option>
										<option value="การตลาด">การตลาด</option>
									 </select>
									 <div class="visible-xs">
										 <br>
									 </div>
						      	 </div>
						      	 
						      	 <div class="col-xs-4 col-sm-2 control-label">
						      	     <p class="text-right">
					   		 	 	 	 <b>ตำแหน่ง</b>
					   		 	 	 </p>
						      	 </div>
							     <div class="col-xs-8 col-sm-3">
						      	 	 <select id="txtPositionEmployee" name="txtPositionEmployee" class="form-control">
						      	 	    <option value="">ทั้งหมด</option>
										<option value="ลูกจ้างชั่วคราว">ลูกจ้างชั่วคราว</option>
										<option value="พนักงานทั่วไป">พนักงานทั่วไป</option>
										<option value="หัวหน้าพนักงาน">หัวหน้าพนักงาน</option>
									 </select>
						      	 </div>
							</div>
							<br>
							<div class="row container">
								<div class="col-xs-4 col-sm-2 control-label">
						      	     <p class="text-right">
					   		 	 	 	 <b>วันเริ่มต้น</b>
					   		 	 	 </p>
						      	</div>
						     	<div class="col-xs-8 col-sm-3">
					                <div class='input-group date' id='datepicker1'>
					                    <input id="txtMinDay" class="form-control date-range-filter" type="text" name="txtMinDay" maxlength="50">
					                    <span class="input-group-addon" id="iconDate1">
					                        <span class="glyphicon glyphicon-calendar"></span>
					                    </span>
					                </div>
					              	<div class="visible-xs">
										<br>
									</div>
						      	</div>
						      	<div class="col-xs-4 col-sm-2 control-label">
						      	     <p class="text-right">
					   		 	 	 	 <b>วันสิ้นสุด</b>
					   		 	 	 </p>
						      	</div>
						     	<div class="col-xs-8 col-sm-3">
					                <div class='input-group date' id='datepicker2'>
					                    <input id="txtMaxDay" class="form-control date-range-filter" type="text" name="txtMaxDay" maxlength="50">
					                    <span class="input-group-addon" id="iconDate2">
					                        <span class="glyphicon glyphicon-calendar"></span>
					                    </span>
					                </div>
						      	</div>
							</div>
							<br>
							<div class="row container">
								<div class="col-xs-4 col-sm-2 control-label">
					   		 	 	 <p class="text-right">
					   		 	 	 	 <b>ประเภทการลา</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-3">
						      	 	 <select id="txtLeaveType" name="txtLeaveType" class="form-control">
						      	 	    <option value="">ทั้งหมด</option>
										<option value="ลาป่วย">ลาป่วย</option>
										<option value="ลากิจ">ลากิจ</option>
										<option value="ลาพักร้อน">ลาพักร้อน</option>
									 </select>	
									 <div class="visible-xs">
										 <br>
									 </div>								 
						      	</div>
								<div class="col-xs-4 col-sm-2 control-label">
					   		 	 	 <p class="text-right">
					   		 	 	 	 <b>สถานะ</b>
					   		 	 	 </p>
						      	 </div>
						      	 <div class="col-xs-8 col-sm-3">
						      	 	 <select id="txtStatusType" name="txtStatusType" class="form-control">
						      	 	    <option value="">ทั้งหมด</option>
										<option value="รออนุมัติ">รออนุมัติ</option>
										<option value="อนุมัติ">อนุมัติ</option>
										<option value="ไม่อนุมัติ">ไม่อนุมัติ</option>
									 </select>									 
						      	</div>
							</div>
							<br>
							<div class="row container">
								<div class="col-xs-12 col-sm-12 text-center">					     		 
							     	 <button type="button" class="btn btn-primary text-white" id="btnSearchReport" onclick="searchEngine()" >ค้นหา</button>&nbsp;
							     	 <button type="button" class="btn btn-primary text-white" id="btnCancelSearchReport" onclick="location.href='/testweb/LoadReportOnLeaveSrvl'" >ยกเลิก</button>&nbsp
						     	</div>
							</div>
							<div class="visible-xs">
								<br>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 text-center">
						     		<table id="reportTable" class="table table-responsive table-bordered dt-responsive nowrap table-hover" style="width: 100%">
							     		<thead>
							     			 <tr>
								                <th class="text-center">ลำดับ</th>
								                <th class="text-center">ชื่อ - นามสกุล</th>		               
								                <th class="text-center">แผนก</th>
								                <th class="text-center">ตำแหน่ง</th>
								                <th class="text-center">ประเภทการลา</th>
								                <th class="text-center">วันเริ่มต้นลา</th>
								                <th class="text-center">วันสิ้นสุดลา</th>
								                <th class="text-center">สถานะ</th>
								                <th class="text-center">รายละเอียด</th>
								             </tr>
								         </thead>
						     		</table>
						        </div>
							</div>
				
							<div class="row container">
							    <button type="button" class="btn btn-primary text-white" id="btnGoToApprove" onclick="location.href='/testweb/ApproveSrvl'" >กลับหน้าอนุมัติคำร้อง</button>
							</div>
						</div>
				    </div>
				</div>
			</div>	
		</div>
</body>
</html>