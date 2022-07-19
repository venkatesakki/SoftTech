<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Leaveform</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
	
#back {
	width: 80px;
	height: 40px;
	font-size: 1em;
	color: white;
	background-color: black;
	margin-left: 75%;
	margin-top: 1%;
}
</style>
</head>
<body>
<div class="row">
		<div class="col-md-3"></div>
			<div class="col-md-2" align="right">
			<img style="height: 100px; width: 150px; margin-top: 10px;"
						alt="Logo" src="images/logo.png">
			
			</div>
			<div class="col-md-6">
					<h1 align="left" style="color:  #0040ff; margin-top: 30px;" >Softech Private
						Limited</h1>
				

			</div>
		<div class="col-md-1"></div>
		</div>

<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8">
<h2 align="center" style="margin-top: 35px;"><u>Leave Forms</u></h2>
<table class="table table-striped table-bordered table-hover" style="margin-top: 30px;">
	<tr>
		<th>Serial no</th>
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>From-Date</th>
		<th>To-Date</th>
		<th>Reason</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach items= "${list}" var="eachleave">
	<tr>
	<td><c:out value="${eachleave.serialNo}" /></td>
	<td><c:out value="${eachleave.employeeId}" /></td>
	<td><c:out value="${eachleave.employeeName}" /></td>
	<td><c:out value="${eachleave.fromDate}" /></td>
	<td><c:out value="${eachleave.toDate}" /></td>
	<td><c:out value="${eachleave.reason}" /></td>
	<td><c:out value="${eachleave.status}" /></td>
	<td><a href="viewLeave.in?serialNo=<c:out value='${eachleave.serialNo}'/>">View</a></td>
	</tr>
	</c:forEach>
	
</table>
<form>
	<input type="submit" id="back" value="Back" class="btn btn-clear" formaction="SupervisorDashboard.action" /></form>
</div>

<div class="col-md-2"></div>
</div>

</body>
</html>