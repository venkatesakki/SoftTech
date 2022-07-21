<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="container-fluid"  >
		<div class="row" >
			<div class="col-md-2"  >
			</div>
			<div class="col-md-8" style="margin-top: 20px;" align="center">
				<h1 id="Managerdashfont">Manager Dashboard</h1>
				<%-- <h4 style="color:white;"><c:out value="${message}"></c:out></h4> --%>
				
			</div>
			<div class="col-md-2" align="right" style="margin-top: 20px">
			<form method="post">
			<input type="submit" value="Log-out" formaction="loginForm.in" style="background-color: #ffffff;border-radius: 5px;">
			</form>
			
			</div>
		</div>


		<div class="row ">

			<div class="col-md-2"></div>
			
			<div class="col-md-8 Managerdashtablecolour" style="margin-top: 50px">
				<form method="post">
				<input type="hidden" name="employeeId" value="${employeeId}" />
				<input type="submit" value="EMPLOYEE LIST" style="margin-right: 65px;margin-left: 100px; margin-top: 150px" class="Managerdashseperate-button" formaction="employeeList.in" ></input>
				<input type="submit" value="LEAVE FORMS"
					style="margin-bottom: 68px; margin-left: 91px;"  class="Managerdashseperate-button" formaction="leaveList.in"></input>	
				</form>
			</div>
			
			<div class="col-md-2"></div>
	</div>
	
</div>

</body>
</html>