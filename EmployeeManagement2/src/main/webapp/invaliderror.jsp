<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
	<style type="text/css">
	#invalid
	{
	color: white;
	text-align: center;
	
	}
	#invalidimage
	{
	margin-left: 100px;
	}
	
	</style>
</head>
<body  style="background-color: #ffad99">


<div class="container-fluid" style="margin-top:20%">

<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4"><img alt="error" src="images/invalid.png" width="200px" height="200px" id="invalidimage" style="background-color: red ;border-radius: 20px;"></div>
<div class="col-md-4"></div></div></div>
<div class="container-fluid" style="margin-top: 20px">
<div class="row">
<div class="col-md-2"></div>
<div class="col-md-8"><h3 id="invalid">invalid user name or password</h3></div>
<div class="col-md-2"></div>
</div></div>





</body>
</html>