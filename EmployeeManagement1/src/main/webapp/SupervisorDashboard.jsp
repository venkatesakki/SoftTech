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
<style type="text/css">

.button{

width: 250px;
height: 100px;
border-radius: 10px;
color: white;
background-color: #4d79ff;
}

.tablecolour{

width: 1px;
height: 400px;
border-radius: 10px;
background-color: #ffffff;
}
#font
{
text-shadow: 3px 2px 2px #4080bf;
color:white;
font-size: 3em;
}





</style>


</head>

<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">

	<div class="container-fluid"  >
		<div class="row" >
			<div class="col-md-2"  >
			</div>
			<div class="col-md-8" style="margin-top: 20px;" align="center">
				<h1 id="font">Manager Dashboard</h1>
				
			</div>
			<div class="col-md-2" align="right" style="margin-top: 20px">
			<form>
			<input type="submit" value="Log-out" formaction="login.in" style="background-color: #ffffff;border-radius: 5px;">
			</form>
			
			</div>
		</div>


		<div class="row ">

			<div class="col-md-2"></div>
			
			<div class="col-md-8 tablecolour" style="margin-top: 50px">
				<form>
				<input type="hidden" name="employeeId" value="${empId}" />
				<input type="submit" value="EMPLOYEE LIST" style="margin-right: 65px;margin-left: 100px; margin-top: 150px" class="button" formaction="empList.in" ></input>
				<input type="submit" value="APPLY LEAVE"
					style="margin-bottom: 68px; margin-left: 91px;"  class="button" formaction="leave.in"></input>
				</form>
			</div>
			
			<div class="col-md-2"></div>
      


	</div>
	
</div>

</body>
</html>