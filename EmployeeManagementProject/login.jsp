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
		<link rel="stylesheet" href="style/Style.css">


</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
	<div class="container-fluid">
		<div class="row" style="margin-top: 8%">
			<div class="col-md-4"></div>
			<div class="col-md-4 logincenter">
				<h1 style="color: White;font-style: italic;">Login</h1>
				<c:set var="message" value="${message}" scope="request"></c:set>
				<h4 style="color:red;text-align: center;">${message}</h4>
			</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 loginsize" style="margin-top: 20px">
				<form  method="post" class="loginside">
					<div>
						<img alt="Login Logo" src="images/images.png" class="loginimages">
					</div>
					<div class="form-group" >
						<label for="userName" class="loginfont" style="margin-top: 20px">UserName</label>
						<input type="text" name="employeeId" id="userName"
							placeholder="Enter Employee-Id" />
					</div>
					
					<div class="form-group">
						<label for="password" class="loginfont">Password</label> <input
							type="text" name="password" id="password"
							placeholder="Enter password"  />
					</div>
					<div class="logincenter form-group">
						<input type="submit" value="Login" formaction="login.in" class="btn btn-success">
					</div>
				</form>
				<div>
				<a href="welcome.in" ><button style="margin-right: 76px;margin-left: 159px;margin-top: 0px;">Go back!</button></a>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
</body>
</html>