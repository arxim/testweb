<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 	script-header import -->
<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/libraries/datatables-1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/pages/approveOnLeave/approveOnLeave.js"></script>
<script type="text/javascript">
	var ctx = '${pageContext.request.contextPath}';
	var msgTimeout = '${sessionScope.msgTimeout}';
	var userLogin = '${sessionScope.userLogin}';
</script>
<title>หน้าหลัก</title>
</head>
<body class="bg-info">
	<form id="approve" method="post" action="">
		<c:if test="${empty sessionScope.userLogin}">
			<c:redirect url="/" />
		</c:if>
		<div class="container" style="margin-top: 5%; margin-bottom: 12%;">
			<div class="col-xs-12 col-sm-12">
				<div class="panel panel-primary form-horizontal">
					<div class="panel-heading">
						<h2 class="panel-title text-center" id="textApprove">
							<b>อนุมัติคำร้องขอลา</b>
						</h2>
						<h2 class="panel-title text-center" id="textApproveUser">
							<b>ประวัติการลา</b>
						</h2>
					</div>
					<div class="panel-body">
						<div class="form-group">
							<div class="col-sm-5">
								<h5>Welcome : ${sessionScope.userLogin}</h5>
							</div>
							<div class="col-xs-5 col-xs-offset-7 col-sm-2 col-sm-offset-5">
								<button type="submit" class="btn btn-block btn-danger"
									id="btnLogout" formaction="/testweb/LogoutSrvl">Logout</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-xs-5 col-xs-offset-7 col-sm-2 col-sm-offset-10">
								<button type="button"
									class="btn btn-block btn-primary text-white"
									id="btnGoToRequest"
									onclick="addRequest();">+เพิ่มคำร้องขอลา</button>
								<button type="button"
									class="btn btn-block btn-primary text-white" id="btnGoToReport"
									onclick="location.href='/testweb/LoadReportOnLeaveSrvl'">ไปหน้ารายงานการลา</button>							</div>
						</div>
						<div class="form-group">
							<label id="statusname"
								class="col-xs-3 col-sm-offset-3 col-sm-2 control-label">สถานะ : </label>
							<div class="col-sm-3">
								<select id="status" class="form-control">
									<option value="รออนุมัติ" selected="selected">รออนุมัติ</option>
									<option value="อนุมัติ">อนุมัติ</option>
									<option value="ไม่อนุมัติ">ไม่อนุมัติ</option>
								</select>
							</div>
						</div>
						<table id="tableApprove" class="display table table-responsive table-bordered dt-responsive nowrap table-hover" 
						style="width: 100%" cellspacing="0"
							border="1" bordercolor="#CCCCCC" width="100%">
							<thead>
								<tr>
									<th class="text-center">ชื่อ-นามสกุล</th>
									<th class="text-center">แผนก</th>
									<th class="text-center">ตำแหน่ง</th>
									<th class="text-center">ประเภทการลา</th>
									<th class="text-center">สถานะ</th>
									<th class="text-center">วันที่ขออนุมัติ</th>
									<th class="text-center">วันที่อนุมัติ</th>
									<th class="text-center">เพิ่มเติม</th>
									<th class="text-center">เลือก</th>
								</tr>
							</thead>
						</table>
						<table id="tableEdit" class="display table table-responsive table-bordered dt-responsive nowrap table-hover" 
						style="width: 100%" cellspacing="0"
							border="1" bordercolor="#CCCCCC" width="100%">
							<thead>
								<tr>
									<th class="text-center">ชื่อ-นามสกุล</th>
									<th class="text-center">แผนก</th>
									<th class="text-center">ตำแหน่ง</th>
									<th class="text-center">ประเภทการลา</th>
									<th class="text-center">สถานะ</th>
									<th class="text-center">วันที่ขออนุมัติ</th>
									<th class="text-center">วันที่อนุมัติ</th>
									<th class="text-center">เลือก</th>
								</tr>
							</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</form>
	<c:if test="${not empty sessionScope.msgTimeout}">
		<div class="modal fade" id="msg-modal" role="dialog">
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
						<p>${sessionScope.msgTimeout}</p>
					</div>
					<div class="modal-footer bg-info">
						<button type="button" class="btn btn-default" id="close-msg-modal"
							data-dismiss="modal">ปิด</button>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>