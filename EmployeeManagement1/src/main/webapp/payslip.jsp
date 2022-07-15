<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAYSLIP</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

</head>
<body>



	<div >
		<div class="row">
		<div class="col-md-2"></div>
			<div class="col-md-2" align="right">
			<img style="height: 100px; width: 150px; margin-top: 10px;"
						alt="Logo" src="images/logo.png">
			
			</div>
			<div class="col-md-6">

				

					
					<h1 align="left" style="color:  #0040ff; margin-top: 30px;" >Softech Private
						Limited</h1>
				

			</div>
		<div class="col-md-2"></div>
		</div>

		<div class="row" style="margin-top: 30px;">
			<div class="col-md-2"></div>
			<div class="col-md-8">

				<table class="table">

					<tr>
					</tr>


					<tr>
						<th>Employee Id:</th>
						<td><c:out value="${empId}"/></td>
					</tr>

					<tr>
						<th>Employee Name:</th>
						<td></td>
					</tr>

					<tr>
						<th>Month & Year:</th>
						<td>July-2022</td>
					</tr>

				</table>



			</div>
			<div class="col-md-2"></div>

		</div>
		<div class="row" style="margin-top: 30px;">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table border="1" class="table " style="text-align: center;">

					<tr style="background-color: gray">

						<th>Salary</th>
						<th>Amount</th>

					</tr>


					<tr>

						<td>Basic</td>
						<td>12000.0</td>

					</tr>

					<tr style="background-color: gray">

						<td>HRA</td>
						<td>1000.0</td>


					</tr>
					<tr>


						<td>PF</td>
						<td>2000.0</td>


					</tr>
					<tr style="background-color: gray">

						<th>Total</th>
						<th>15000.0</th>
					</tr>

				</table>
				<div style="text-align: end;">
					<a href="" class="btn btn-outline-primary">Print</a> 
					<a href="EmployeeDashboard.action"
						class="btn btn-outline-danger">Cancel</a>


				</div>



			</div>
			<div class="col-md-2"></div>


</div>

		</div>
	


</body>
</html>