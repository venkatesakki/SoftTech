<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="add.in">
<h1>Hello</h1>
<label for="">first Name</label>
<input type="text" name="firstName" />
<label for="">Last Name</label>
<input type="text" name="lastName"/>

<label for="">Gender</label>
<label for="">Male</label>
<input type="radio" name="gender" value="male"/>
<label for="">Female</label>
<input type="radio" name="gender" value="female"/>
<label for="">Others</label>
<input type="radio" name="gender" value="others"/>

<label for="">Age</label>
<input type="text" name="age"/>
<label for="">Phn num</label>
<input type="text" name="phoneNumber"/>
<label for="">Email</label>
<input type="email" name="email"/>
<label for="">UserName</label>
<input type="text" name="userName"/>
<label for="">Password</label>
<input type="text" name="password"/>
<label for="">Employee Head</label>
<input type="text" name="employeehead"/>
<input type="submit" value="ADD"/>
</form>

</body>
</html>