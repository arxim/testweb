<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	script-header import -->
<jsp:include page="/resources/template/script-header.jsp"></jsp:include>

<script type="text/javascript">
	var ctx = '${pageContext.request.contextPath}';
	//var msgTimeout = '${sessionScope.msgTimeout}';
</script>
<script type="text/javascript"
	src="resources/js/pages/requestOnLeave/requestOnLeave.js"></script>
<title>Request on leave</title>
</head>
<body class="bg-info">
	<form id="frmRequest" method="post" action="">
		<div class="container" style="margin-top: 5%; margin-bottom: 12%;">
			<div class="panel panel-primary form-horizontal">
				<div class="panel-heading">
					<h2 class="panel-title">
						<b>คำร้องขอลา</b>
					</h2>
				</div>
				<div class="panel-body">
					<h4 align="right">สถานะ : รออนุมัติ</h4>
					<br> <br>
					<div class="form-group">
						<label class="col-sm-2 control-label">ชื่อ :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" placeholder="ชื่อ" id="Fname" disabled>
						</div>
						<label class="col-sm-2 control-label">นามสกุล :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" placeholder="นามสกุล" id="Lname" disabled>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">แผนก :</label>
						<div class="col-sm-4">
							<select class="form-control" id="comboDepartment"ห>
								<option value="departmentA">แผนก A</option>
								<option value="departmentB">แผนก B</option>
								<option value="departmentC">แผนก C</option>
							</select>
						</div>
						<label class="col-sm-2 control-label">ตำแหน่ง :</label>
						<div class="col-sm-4">
							<select class="form-control" id="comboPosition">
								<option value="positionA">ตำแหน่ง A</option>
								<option value="positionB">ตำแหน่ง B</option>
								<option value="positionC">ตำแหน่ง C</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">อีเมลล์ :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" placeholder="อีเมลล์" id="txtemail">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">ชื่อหัวหน้า :</label>
						<div class="col-sm-4">
							<select class="form-control" id="comboBoss">
								<option value="bossA">นาย A</option>
								<option value="bossB">นาย B</option>
								<option value="bossC">นาย C</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">ประเภทการลา :</label>
						<div class="col-sm-4">
							<select class="form-control" id="comboLeave">
								<option value="sickLeave">ลาป่วย</option>
								<option value="errandLeave">ลากิจ</option>
								<option value="holidayLeave">ลาพักร้อน</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">เวลาเริ่ม :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" placeholder="ว/ด/ป" id="txtStartDate">
						</div>
						<label class="col-sm-2 control-label">เวลาสิ้นสุด :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" placeholder="ว/ด/ป" id="txtStopDate">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">จำนวนวัน :</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="txtCountDay">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">หมายเหตุ :</label>
						<div class="col-sm-7">
							<textarea class="form-control" rows="5" id="txtArea"></textarea>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-2">
							<button type="button" class="btn btn-primary btn-block btn-lg"
								id="btnSubmit" onclick="sendRequest();">ส่ง</button>
						</div>
						<div class="col-sm-2">
							<button type="button" class="btn btn-primary btn-block btn-lg"
								id="btnCancel"onclick="cancelRequest();">ยกเลิก</button>
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
							<b>Password !!!</b>
						</h3>
					</div>
					<div class="modal-body">
						<h5 id="msgModalRequest" class="text-center text-primary"><b></b></h5>
					</div>
					<div class="modal-footer bg-info">
						<button type="button" class="btn btn-default" id="close-msg-modal" data-dismiss="modal">Close</button>
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
							<b>Password !!!</b>
						</h3>
					</div>
					<div class="modal-body">
						<h5 id="msgModalCancelRequest" class="text-center text-primary"><b></b></h5>
					</div>
					<div class="modal-footer bg-info">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        				<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="comfirm();">Confirm</button>
					</div>
				</div>
			</div>
		</div>
	
</body>
</html>