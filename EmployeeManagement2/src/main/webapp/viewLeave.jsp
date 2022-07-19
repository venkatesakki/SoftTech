<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style type="text/css">
.box {
	width: 150px;
	height: 700px;
	background-color: white;
	margin-top: 2%;
	border-radius: 10px;
}
#font {
	color: white;
}
#back{
	width: 80px;
	height: 40px;
	margin-left:58.75%;
	margin-top: 2%;
    font-size: 1em;
}
</style>
</head>
<body
	style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12" align="center" style="margin-top: 60px">
				<div>
					<h2 id="font">APPLY-LEAVE FORM</h2>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 box" align="center" style="margin-top: 30px">
				<form action="">
				
						<label for="employeeid"></label><input type="hidden"
							name="serialNo" id="serialNo" class="form-control"
							value="${leave.serialNo}" readonly="readonly"/>
					
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="employeeid">Employee ID</label><input type="text"
							name="employeeId" id="employeeid" class="form-control"
							value="${leave.employeeId}" readonly="readonly"/>
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="empname">Employee Name</label><input type="text"
							name="employeeName" id="empname" value="${leave.employeeName}" 
							class="form-control"  readonly="readonly"/>
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="frmdate">From-Date</label><input type="date"
							name="fromDate" id="frmdate" value="${leave.fromDate}" class="form-control" readonly="readonly" />
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="toDate">To-Date</label><input type="date"
							name="toDate" id="todate" value="${leave.toDate}" class="form-control"  readonly="readonly"/>
					</div>
					<div>
						<label for="Notes" style="font-size: 1.2em; margin-right: 330px;">Reason</label>
						<input type="text" name="reason" value="${leave.reason}"
							placeholder="enter a breif summary about you"
							class="form-control"  readonly="readonly"/>
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em;margin-top: 4%">
						<label for="employeeid">Manager ID</label><input type="text"
							name="managerId" id="managerId" value="${leave.managerId}" class="form-control" readonly="readonly"/>
					</div>
					<div>
					<label for="status" style="font-size:1.2em;margin-right:350px;margin-top:10px;">Status</label>
					</div>
					<div style="margin-top: -36px;">
					<input type="radio" name="status" id="status" value="Approved" />
					<label for="approved" style="font-size: 1.2em;margin-right:18px;">Approved</label>
					<input type="radio" name="status" id="status" value="Rejected" />
					<label for="rerjected" style="font-size: 1.2em;">Rejected</label>
					</div>
					<div
						style="margin-top: 20px; margin-left: 13px; margin-right: 35px;">
						<input type="submit" value="Submit" class="btn btn-success" formaction="LeaveUpdate.in" />
						<input type="reset" value="clear" class="btn btn-warning" />
					</div>
				</form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
</body>
</html>