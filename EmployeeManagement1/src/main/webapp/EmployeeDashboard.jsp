<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<div class="row" ">
			<div class="col-md-2"  >
			</div>
			<div class="col-md-8" style="margin-top: 20px;" align="center">
				<h1 id="font">Employee Dashboard</h1>
			</div>
			<div class="col-md-2" align="right" style="margin-top: 20px">
			<form>
			<input type="submit" value="Log-out" id="lout" formaction="login.in">
			</form>
			
			</div>
		</div>


		<div class="row " >

			<div class="col-md-2"></div>
			
			<div class="col-md-8 tablecolour" style="margin-top: 50px">
			<form>
				<input type="hidden" name="employeeId" value="${empId}" />
				
				<input type="submit" value="APPLY LEAVE" style="margin-right: 65px;margin-left: 100px;" class="button" formaction="leave.in" />
				<input type="submit" value="PRINT PAY SLIP"
					style="margin-bottom: 68px; margin-left: 91px; margin-top: 60px" class="button" formaction="paySlip.in"></input>
				<input type="submit" value="BOOK" style="margin-right: 158px;margin-left: 98px;" class="button" formaction="book.in"></input>
				<input type="submit" value="VIDEOS" style="margin-left: 11px" class="button" formaction="video.in"></input>
			</form>	
			</div>
			
			<div class="col-md-2"></div>
      


	</div>
	
	
	
	</div>
</div>

</body>
</html>