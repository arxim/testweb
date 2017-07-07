<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<script type="text/javascript" src="resources/js/pages/requestOnLeave/requestOnLeave.js"></script>
<title>Request on leave</title>
</head>
<body class="bg-info">
	<form id="frmRequest" >
		<div class="container form-horizontal" style="margin-top: 10%; margin-bottom: 12%;">
			<div class="col-xs-12 col-sm-12">
				<h2>ยื่นคำร้องขอลา</h2>
				<br>
				<br>
				<div class="form-group">
				<label class="col-sm-2 control-label">ชื่อ :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="ชื่อ"  id="Fname">
				</div>
				<label class="col-sm-2 control-label">นามสกุล :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="นามสกุล"  id="Lname">
				</div>
				</div>
				<div class="form-group">
				<label class="col-sm-2 control-label">แผนก :</label>
				<div class="col-sm-4">
						<select class="col-sm-4">
							<option value="a">แผนก A</option>
							<option value="b">แผนก B</option>
							<option value="c">แผนก c</option>
							<option value="d">แผนก D</option>
						</select>
					</div>
				<label class="col-sm-2 control-label">ตำแหน่ง :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="ตำแหน่ง"  id="position">
				</div>
				</div>
				<div class="form-group">
				<label class="col-sm-2 control-label">อีเมลล์ :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="อีเมลล์"  id="email">
				</div>
				</div>
				<div class="form-group">
				<label class="col-sm-2 control-label">ชื่อหัวหน้า :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="ชื่อ"  id="email">
				</div>
				</div>
				<div class="form-group">
				<label class="col-sm-2 control-label">ประเภทการลา :</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" placeholder="ชื่อ"  id="email">
				</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>