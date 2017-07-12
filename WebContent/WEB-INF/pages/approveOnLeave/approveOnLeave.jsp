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
<title>อนุมัติคำร้องขอลา</title>
</head>
<body class="bg-info">
	<form id="approve" method="post" action="">
		<div class="container" style="margin-top: 5%; margin-bottom: 12%;">
			<div class="panel panel-primary form-horizontal">
				<div class="panel-heading">
					<h2 class="panel-title">
						<b>อนุมัติคำร้องขอลา</b>
					</h2>
				</div>
		<div class="panel-body">
				<div class="form-group">
						<label class="col-sm-offset-4 col-sm-1 control-label">สถานะ : </label>
					<div class="col-sm-3">
						<select id="status" class="form-control">
							<option value="" disabled="disabled" selected="selected">-----------</option>
							<option value="Pending">รออนุมัติ</option>
							<option value="Approve">อนุมัติ</option>
						</select>
					</div>
					<br>
					<br>
				</div>
		
	
    <table id="tableApprove" class="display" cellspacing="0" width="100%" align="center">
	 <thead> 
            <tr> 
                <th width="10%">วันที่</th> 
                <th width="18%">ชื่อ-นามสกุล</th> 
                <th width="15%">แผนก</th> 
                <th width="15%">ตำแหน่ง</th> 
                <th width="13%">ประเภทการลา</th> 
                <th width="10%">สถานะ</th> 
                <th width="10%">วันที่อนุมัติ</th> 
                <th width="9%">เลือก</th>
            </tr> 
      </thead>
	
      <tfoot> 
            <tr> 
                <th>วันที่</th> 
                <th>ชื่อ-นามสกุล</th> 
                <th>แผนก</th> 
                <th>ตำแหน่ง</th> 
                <th>ประเภทการลา</th> 
                <th>สถานะ</th> 
                <th>วันที่อนุมัติ</th>
                <th>เลือก</th>
            </tr> 
        </tfoot>
    </table>
			
		<div class="button-heading">
			<div class="row">
				<div class="col-xs-24 col-sm-12 text-center">
				<br>
					<button type="button" class="btn btn-primary text-white" style="width: 12%;" id="btnGoToRequest" onclick="location.href='/testweb/RequestSrvl'">บันทึกคำร้องขอลา</button> &nbsp;
					<button type="button" class="btn btn-primary text-white" style="width: 12%;" id="btnBackToMainMenu" onclick="location.href=">กลับหน้าหลัก</button> &nbsp;
					<button type="button" class="btn btn-primary text-white" style="width: 12%;" id="btnGoToReport" onclick="location.href='/testweb/LoadReportOnLeaveSrvl'">ประวัติการลา</button>
				</div>
			</div>
		</div>
	</div>	
</div>
</div>

</form>
</body>
</html>