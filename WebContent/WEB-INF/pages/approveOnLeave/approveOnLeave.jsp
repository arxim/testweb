<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
	<script type="text/javascript" src="resources/libraries/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="resources/libraries/datatables-1.10.13/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="resources/js/pages/approveOnLeave/approveOnLeave.js"></script>
	<script type="text/javascript">
		var userLogin = '${sessionScope.userLogin}';
	</script>
<title>อนุมัติคำร้องขอลา</title>
</head>
<body class="bg-info">
	<form id="approve" method="post" action="">
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
			<div class="col-sm-12">
				<h5>Welcome : ${sessionScope.userLogin}</h5>
				<div align="right">
					<button type="button" class="btn btn-primary text-white" id="btnGoToRequest" onclick="location.href='/testweb/LoadRequestOnLeaveSrvl'">บันทึกคำร้องขอลา</button> &nbsp;
				</div>
			</div>
		<div class="panel-body">
				<div class="form-group">
						<label id="statusname" class="col-sm-offset-4 col-sm-1 control-label">สถานะ : </label>
					<div class="col-sm-3">
						<select id="status" class="form-control">
							<option value="รออนุมัติ" selected="selected">รออนุมัติ</option>
							<option value="อนุมัติ">อนุมัติ</option>
						</select>
					</div>
					<br>
					<br>
				</div>
			
	
    <table id="tableApprove" class="display" cellspacing="0" border="1" bordercolor="#CCCCCC" width="100%">
	 <thead> 
            <tr> 
                <th class="text-center" width="8%">วันที่</th> 
                <th class="text-center" width="13%">ชื่อ</th>
                <th class="text-center" width="13%">นามสกุล</th>
                <th class="text-center" width="12%">แผนก</th> 
                <th class="text-center" width="12%">ตำแหน่ง</th> 
                <th class="text-center" width="13%">ประเภทการลา</th> 
                <th class="text-center" width="9%">สถานะ</th> 
                <th class="text-center" width="10%">วันที่อนุมัติ</th> 
                <th class="text-center" width="10%">เลือก</th>
            </tr> 
      </thead>
    </table>
			
		<div class="button-heading">
			<div class="row">
				<div class="col-xs-12 col-sm-12 text-center">
				<br>
					<button type="button" class="btn btn-primary text-white" id="btnBackToMainMenu" onclick="location.href='/testweb/LoadMainMenuSrvl'">กลับหน้าหลัก</button> &nbsp;
					<button type="button" class="btn btn-primary text-white" id="btnGoToReport" onclick="location.href='/testweb/LoadReportOnLeaveSrvl'">รายงานการลา</button>
				</div>
			</div>
		</div>
	  </div>	
	</div>
  </div>
</div>
</form>
</body>
</html>