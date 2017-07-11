<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	script-header import -->
	<jsp:include page="/resources/template/script-header.jsp"></jsp:include>
<!-- <script type="text/javascript" src="resources/js/pages/approveOnLeave/approveOnLeave.js"></script> -->
<title>Approve</title>
</head>
<body class="bg-info">
<form id="approve">
<div class="container" style="margin-top:10%; margin-bottom:12%; background-color:#ffffff; box-shadow:0 0 18px rgba(6, 0, 255, 0.3);">
  <div class="col-sm-12">
	<div class="panel panel-primary form-horizontal">
			<div class="panel-heading">
				<h4 class="panel-title"><b>Approve</b></h4>
			</div>
		</div>
				<div class="form-group">
						<label class="col-sm-offset-4 col-sm-1 control-label"><b>สถานะ : </b></label>
					<div class="col-sm-3">
						<select name="comboStatus" class="form-control" onChange="comboStatus()">
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
                <th>วันที่</th>
                <th>ชื่อ-นามสกุล</th>
                <th>แผนก</th>
                <th>ตำแหน่ง</th>
                <th>ประเภทการลา</th>
                <th>สถานะ</th>
                <th>วันที่อนุมัติ<th>
           </tr>
        </thead>
    </table>
			
		<div class="button-heading">
			<div class="row">
				<div class="col-xs-24 col-sm-12 text-center">
				<br>
					<button type="button" class="btn btn-primary text-white" id="btnGoToReport" onclick="" >Go to report</button>
					<button type="button" class="btn btn-primary text-white" id="btnBackToMainMenu" onclick="" >Go to main menu</button>
				</div>
			</div>
		</div>
	</div>		
</div>
</form>
</body>
</html>