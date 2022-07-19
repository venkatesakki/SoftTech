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
<style type="text/css">

.button{

width: 150px;
height: 70px;
border-radius: 10px;
color: white;
background-color: #4d79ff;
}

.tablecolour{

width: 100px;
height: 400px;
border-radius: 10px;
background-color:  #ffffff;
}
#font
{
text-shadow: 3px 2px 2px #4080bf;
color:white;
font-size: 3em;
}
#lout
{

background-color: #ffffff;
}
</style>
</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
	<div class="container-fluid" >
		<div class="row">
			<div class="col-md-2"  >
			</div>
			<div class="col-md-8" style="margin-top: 20px;" align="center">
				<h1 id="font">Employee Dashboard</h1>
				<h4 style="color:white;"><c:out value="${message}"></c:out></h4>
			</div>
			<div class="col-md-2" align="right" style="margin-top: 20px">
			<form method="post">
			<input type="submit" value="Log-out" id="lout" formaction="login.action">
			</form>
			
			</div>
		</div>


		<div class="row " >

			<div class="col-md-2"></div>
			
			<div class="col-md-8 tablecolour" style="margin-top: 50px">
			<form method="post">
				<input type="hidden" name="employeeId" value="${empId}" />
				
				<input type="submit" value="APPLY LEAVE" style="margin-bottom: 79px;margin-left: 155px;margin-top: 52px;" class="button" formaction="leave.action" />
				<input type="submit" value="PRINT PAY SLIP"
					style="margin-bottom: 71px;margin-left: 187px;margin-top: 49px;" class="button" formaction="paySlip.action"></input>
					<div><input type="submit" value="LEAVE STATUS"
					style="margin-bottom: 40px; margin-left: 325px; margin-top: -34px;" class="button" formaction="leaveStatus.in"></input></div>
				<input type="submit" value="BOOK" style="margin-right: 158px;margin-left: 157px;" class="button" formaction="book.in"></input>
				<input type="submit" value="VIDEOS" style="margin-left: 23px;" class="button" formaction="video.in"></input>
			</form>	
			</div>
			
			<div class="col-md-2"></div>
      


	</div>

	</div>
</body>
</html>