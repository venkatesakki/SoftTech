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
</head>
<body style="background-color: #ccddff">
<div class="container-fluid">
<div class="row">
<div class="col-md-12" align="center" style="margin-top: 10px;background-color: #0099e6"><h1 style="color: white;">REGISTER FORM</h1></div>

</div><br>
<div class="row">
<div class="col-md-4"></div>
<div class="col-md-4" style="background-color: #ccff99">
<form action="add.in">
<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">Employee-ID</label>
<input type="text" name="employeeId" class="form-control" placeholder="eg:STech-00" /></div>
<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">First Name</label>
<input type="text" name="firstName" class="form-control"/></div>
<div class="form-group"><label for="" style="font-size: 1.2em">Last Name</label>
<input type="text" name="lastName" class="form-control"/></div>

<div class="form-group"> <label for="" style="font-size: 1.2em">Gender:  </label><br>
<label for="" style="margin-left: 30px">Male</label>
<input type="radio" name="gender" value="male" />
<label for="" style="margin-left: 15px">Female</label>
<input type="radio" name="gender" value="female" />
<label for="" style="margin-left: 15px">Others</label>
<input type="radio" name="gender" value="others" /></div>

<div class="form-group"><label for="" style="font-size: 1.2em">Age</label>
<input type="text" name="age" class="form-control"/></div>

<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">Address_line_1</label>
<input type="text" name="address1" class="form-control"/></div>

<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">Address_line_2</label>
<input type="text" name="address2" class="form-control"/></div>

<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">City</label>
<input type="text" name="city" class="form-control"/></div>

<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">State</label>
<input type="text" name="state" class="form-control"/></div>

<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">Country</label>
<input type="text" name="country" class="form-control"/></div>

<div class="form-group"><label for="" style="margin-left: 0px;margin-top: 30px;font-size: 1.2em">pincode</label>
<input type="tel" name="pinCode" class="form-control" pattern="[0-9]{6}"/></div>


<div class="form-group"><label for="" style="font-size: 1.2em">Phone number</label>
<input type="tel" name="phoneNumber" class="form-control" pattern="[0-9]{10}"/></div>

<div class="form-group"><label for="" style="font-size: 1.2em">Email</label>
<input type="email" name="email" class="form-control"/></div>


<div class="form-group"><label for="" style="font-size: 1.2em">Password</label>
<input type="text" name="password" class="form-control"/></div>



<div class="form-group"><label for="" style="font-size: 1.2em">Role-Type : </label></div>
<div><label for="" style="margin-left: 30px">Employee</label>
<input type="radio" name="roleType" value="employee" /><br>

<label for="" style="margin-left: 30px">Manager</label>
<input type="radio" name="roleType" value="manager" /><br></div>

<div class="form-group"><label for="" style="font-size: 1.2em">Manager-Id</label>
<input type="text" name="managerId" class="form-control"/></div>


<input type="submit" value="ADD" class="btn btn-success"/>
<input type="reset" value="CLEAR" class="btn btn-warning"/>
</form>
</div>

<div class="col-md-4"></div>
</div>
</div>
</body>
</html>