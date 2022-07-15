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
	height: 525px;
	background-color: white;
	margin-top: 2%;
	border-radius: 10px;
}
#font{
color: white;
}
</style>
</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">


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
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="employeeid">Employee ID</label><input type="text"
							name="empid" id="employeeid" class="form-control" value=<c:out value="${empId}"/> readonly="readonly" />
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="empname">Employee Name</label><input type="text"
							name="empname" id="empname" class="form-control" />
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="frmdate">From-Date</label><input type="date"
							name="fromdate" id="frmdate" class="form-control" />
					</div>
					<div class="form-group" align="left" style="font-size: 1.2em">
						<label for="todate">To-Date</label><input type="date"
							name="ToDate" id="todate" class="form-control" />
					</div>
					<div>
						<label for="Notes" style="font-size: 1.2em;margin-right: 330px;">Reason</label>


						<textarea name="textarea"
							placeholder="enter a breif summary about you"
							class="form-control"></textarea>
					</div>


					<div style="margin-top: 20px;margin-left: 13px;margin-right: 35px;">
						<input type="button" value="Apply" class="btn btn-success"  /> <input
							type="button" value="clear" class="btn btn-warning" />



					</div>




				</form>

























			</div>



			<div class="col-md-4"></div>


		</div>














	</div>




</body>
</html>