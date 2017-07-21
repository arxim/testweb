<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	script-header import -->
<jsp:include page="/resources/template/script-header.jsp"></jsp:include>

<script type="text/javascript">
	var userLogin = '${sessionScope.userLogin}';
	
	var mailBoss = '${mailBoss}';
	var code = '${leaveCode}';
	var status = '${status}';
	var firstName = '${fName}';
	var lastName = '${lName}';
	var dpm = '${comboDepartment}';
	var pst = '${comboPosition}';
	var mail = '${txtemail}';
	var nameBoss = '${comboBoss}';
	var typeLeave = '${comboTypeLeave}';
	var start = '${startDate}';
	var end = '${endDate}';
	var diff = '${txtDateDiff}';
	var note = '${txtAreaNote}';
</script>
<script type="text/javascript" src="resources/js/pages/requestOnLeave/requestOnLeave.js"></script> 
<title>Request on leave</title>
</head>
<body class="bg-info">
	<form id="frmRequest" method="post">
		<div class="container" style="margin-top: 5%; margin-bottom: 12%;">
			<div class="panel panel-primary form-horizontal">
				<div class="panel-heading">
					<h2 class="panel-title" id="txtHead" align="center">
						<b>คำร้องขอลา</b>
					</h2>
				</div>
				<div class="panel-body">
				<br> <br>
					<div class="form-group">
						<h4 class="col-sm-offset-5 col-sm-1">สถานะ :</h4>
						<h4 class="col-sm-2" id="txtstatus">รออนุมัติ</h4>
					</div>
					<br> <br>
					<div class="form-group">
						<label class="col-sm-2 control-label">ชื่อ :</label>
						<div class="col-sm-3">
							<input type="text" value="$fName" class="form-control" id="fName" disabled>
						</div>
						<label class="col-sm-2 control-label">นามสกุล :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="lName" disabled>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">แผนก :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="comboDepartment" disabled>
						</div>
						<label class="col-sm-2 control-label">ตำแหน่ง :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="comboPosition" disabled>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">อีเมลล์ :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="txtemail" disabled>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">ชื่อหัวหน้า :</label>
						<div class="col-sm-3">
							<input type="text" class="form-control" id="comboBoss" disabled>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">ประเภทการลา :</label>
						<div class="col-sm-3">
							<select class="form-control" id="comboTypeLeave">
								<option value="ลาป่วย">ลาป่วย</option>
								<option value="ลากิจ">ลากิจ</option>
								<option value="ลาพักร้อน">ลาพักร้อน</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">วันที่เริ่ม :</label>
						<div class="col-sm-3">
							<div class="input-group date" data-provide="datepicker" id="datepickerStart">
								<input type="text" class="form-control" placeholder="วัน/เดือน/ปี" id="startDate" onchange="dateDiff();">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</div>
							</div>
						</div>
						<label class="col-sm-2 control-label">วันที่สิ้นสุด :</label>
						<div class="col-sm-3">
							<div class="input-group date" data-provide="datepicker" id="datepickerEnd">
								<input type="text" class="form-control" placeholder="วัน/เดือน/ปี" id="endDate" onchange="dateDiff();">
								<div class="input-group-addon">
									<span class="glyphicon glyphicon-calendar"></span>
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">จำนวนวัน :</label>
						<label class="col-sm-1 control-label" id="txtDateDiff"></label>
						<label class="col-sm-1 control-label" style=" text-align: left;">วัน</label>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">หมายเหตุ :</label>
						<div class="col-sm-5">
							<textarea class="form-control" rows="5" id="txtAreaNote"></textarea>
						</div>
					</div>
					<br>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-2">
							<button type="button" class="btn btn-primary btn-block"
								id="btnSubmit" onclick="sendRequest();">ส่ง</button>
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary btn-block"
								id="btnCancel" onclick="cancelRequest();">ยกเลิก</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-5  col-sm-2">
							<button type="button" class="btn btn-primary btn-block"
								id="btnBack" onclick="location.href='/testweb/ApproveSrvl'">กลับสู่หน้าหลัก
							</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-2">
							<button type="button" class="btn btn-primary btn-block"
								id="btnApprove" onclick="sendApprove();">อนุมัติ</button>
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary btn-block"
								id="btnNotAllowed" onclick="sendNotAllowed();">ไม่อนุมัติ</button>
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary btn-block"
								id="btnBackMainMenuBoss" onclick="location.href='/testweb/ApproveSrvl'">กลับหน้าอนุมัติคำร้องขอ
							</button>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</form>
	
	<div class="modal fade" id="myModalRequest" role="dialog">
			<div class="modal-dialog modal-sm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title text-center">
							<b>แจ้งเตือน!!</b>
						</h3>
					</div>
					<div class="modal-body">
						<h5 id="msgModalRequest" class="text-center text-primary"><b></b></h5>
					</div>
					<div class="modal-footer bg-info">
						<button type="button" class="btn btn-default" id="close-msg-modal" data-dismiss="modal" onclick="btnClose();">ปิด</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade" id="myModalCancelRequest" role="dialog">
			<div class="modal-dialog modal-sm">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title text-center">
							<b>ยกเลิก!!</b>
						</h3>
					</div>
					<div class="modal-body">
						<h5 id="msgModalCancelRequest" class="text-center text-primary"><b></b></h5>
					</div>
					<div class="modal-footer bg-info">
						<button type="button" class="btn btn-default" data-dismiss="modal">ปิด</button>
        				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="comfirm();">ยืนยัน</button>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" id="hdUserLogin" value='${sessionScope.userLogin}'>
</body>
</html>