<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<style>
.images {
	height: 50px;
	width: 50px;
	margin-left: 35%;
	margin-top: 10px;
}

.center {
	text-align: center;
	margin-top: 15px;
}

.font {
	font-size: 1.3em;
}

.side {
	margin: auto;
	width: 220px;
}

.size {
	height: 330px;
	width: 50px;
	background-color: white;
	border-radius: 10px;
}
</style>
</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
	<div class="container-fluid">
		<div class="row" style="margin-top: 8%">
			<div class="col-md-4"></div>
			<div class="col-md-4 center">
				<h1 style="color: White;font-style: italic;">Login</h1>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 size" style="margin-top: 20px">
				<form action="welcome.in" method="post" class="side">
					<div>
						<img alt="Login Logo" src="images/images.png" class="images">
					</div>
					<div class="form-group" >
						<label for="userName" class="font" style="margin-top: 20px">UserName</label>
						<input type="text" name="employeeId" id="userName"
							placeholder="Enter Employee-Id" required="required" />
					</div>
					<c:set var = "userName" scope = "session" value ="${employeeId}" ></c:set>
					<div class="form-group">
						<label for="password" class="font">Password</label> <input
							type="text" name="password" id="password"
							placeholder="Enter password" required="required" />
					</div>
					<div class="center form-group">
						<input type="submit" value="Login" class="btn btn-success">
					</div>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>