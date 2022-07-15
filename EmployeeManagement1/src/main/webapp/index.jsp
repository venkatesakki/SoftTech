<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>softtech</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<style>
.dropbtn {
	background-color: #3498DB;
	color: black;
	
	font-size: 20px;
	width: 90px;
	height: 40px;
	background-color: white;
	margin-left:100px;
	margin-top:50px;
	
	
	
}

.dropbtn:hover {
	background-color: #ccffe6;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	overflow: auto;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
	margin-left:100px;
	margin-top:5px;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.show {
	display: block;
}

#soft {
	text-align: center;
	background-color: #1ac6ff;
	color: white;
	margin-top: 5%;
	font-size: 4.8em;
	font-family:"Brush Script MT", cursive;
	text-shadow: 5px 7px 3px gray;
	
}




.h1 {
	margin-top: auto;
}


.sideshow{

text-align: center;
margin-top: 20px;

}

.fixed-footer{
       
       text-align: center;
    }
       
</style>
<script type="text/javascript">
	function myFunction() {
		document.getElementById("myDropdown").classList.toggle("show");
	}

	// Close the dropdown if the user clicks outside of it
	window.onclick = function(event) {
		if (!event.target.matches('.dropbtn')) {
			var dropdowns = document.getElementsByClassName("dropdown-content");
			var i;
			for (i = 0; i < dropdowns.length; i++) {
				var openDropdown = dropdowns[i];
				if (openDropdown.classList.contains('show')) {
					openDropdown.classList.remove('show');
				}
			}
		}
	}
</script>
<body style="background-color: #99ddff">

	<div class="container-fluid">
		<div class="row" style="background-color: #0099cc">
			<div class="col-md-3">
				<img alt="sample" src="images/soft1.png" width="100%" style="margin-top: 5px;">
			</div>
			<div class="col-md-6" style="background: #1ac6ff;">
				<h1 id="soft" >Softech pvt Limited</h1>
			</div>
			<div class="col-md-2 ">

				
					<button onclick="myFunction()" class="dropbtn" >Menu</button>
					<div id="myDropdown" class="dropdown-content">
						<a href="register.in">Register</a>
						 <a href="login.in">Log-in</a>

					</div>
				</div>

			



		</div>
<div class="row">

<div class="col-md-3"></div>
<div class="col-md-6 clr-1" >


<marquee width="100%" direction="left" height="100px" class="sideshow">
<img alt="flow" src="images/slideflow.jpeg" height="70px"/><h3 style="color: blue ;font-family: cursive;">Welcome to Softech pvt limited</h3>
</marquee></div>
<div class="col-md-3"></div>

</div>
<div class="row" style="margin: 50px">
<div class="col-md-5"><img alt="softimage" src="images/bgpro1.jpeg" width="500px" height="400px"></div>
<div class="col-md-2"></div>
<div class="col-md-5"><img alt="softimage" src="images/bgpro2.png" width="500px" height="400px"></div>
</div>
<div class="row " style="background-color: #66c2ff">

<div class="col-md-2"></div>
<div class="col-md-8">
<div class="fixed-footer" style="margin: 15px">

 <div ><b>Email</b> : <h5>softech@gmail.com</h5></div>
  <div >Address : Vinayagar Street,Chennai 600120</div>   
   <div >Copyright &copy; 2018-2022 Softech pvt Limited</div> 
  </div>        
</div>
<div class="col-md-2"></div>
	
</div>

	</div>
	
	
	
</body>


</html>