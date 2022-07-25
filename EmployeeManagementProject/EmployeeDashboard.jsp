<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
		<link rel="stylesheet" href="style/Style.css">


</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
	<div class="container-fluid" >
		<div class="row">
			<div class="col-md-2"  >
			</div>
			<div class="col-md-8" style="margin-top: 20px;" align="center">
				<h1 id="Employeefont">Employee Dashboard</h1>
				<c:set var="message" value="${message}" scope="page"></c:set>
				<h4 style="color:red;text-align: center;">${message}</h4>
				
			</div>
			<div class="col-md-2" align="right" style="margin-top: 20px">
			<form method="post">
			<input type="submit" value="Log-out" id="Employeelog-out" formaction="login-form.in">
			</form>
			
			</div>
		</div>


		<div class="row " >

			<div class="col-md-2"></div>
			
			<div class="col-md-8 Employeetablecolour" style="margin-top: 50px">
			<c:set var="name" value="${employeeName}" scope="session"></c:set>
			<c:set var="employeeId" value="${employeeId}" scope="session"></c:set>
			<c:set var="list" value="${list}" scope="session"></c:set>
			
			<form method="post">
			<c:set var="name" value="${employeeName}" scope="session"></c:set>
			<c:set var="empId" value="${employeeId}" scope="session"></c:set>
			<c:set var="list" value="${list}" scope="session"></c:set>
				<input type="hidden" name="employeeId" value="${empId}" />
				<input type="hidden" name="employeeName" value="${name}" />
				<input type="submit" value="APPLY LEAVE" style="margin-bottom: 79px;margin-left: 155px;margin-top: 52px;" class="Employeedash-seperatebutton" formaction="apply-leave.in" />
				<input type="submit" value="PRINT PAY SLIP"
					style="margin-bottom: 71px;margin-left: 187px;margin-top: 49px;" class="Employeedash-seperatebutton" formaction="pay-slip.in"></input>
					<div><input type="submit" value="LEAVE STATUS"
					style="margin-bottom: 40px; margin-left: 325px; margin-top: -34px;" class="Employeedash-seperatebutton" formaction="leave-status.in"></input></div>
				<input type="submit" value="BOOK" style="margin-right: 158px;margin-left: 157px;" class="Employeedash-seperatebutton" formaction="books.in"></input>
				<input type="submit" value="VIDEOS" style="margin-left: 23px;" class="Employeedash-seperatebutton" formaction="videos.in"></input>
			</form>	
			</div>
			<div class="col-md-2"></div>
	</div>
	</div>
</body>
</html>