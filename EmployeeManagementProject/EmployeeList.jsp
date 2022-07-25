<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="style/Style.css">
<style type="text/css">
#employeeList {
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  
}

#employeeList td, #employeeList th {
  border: 1px solid #ddd;
  padding: 8px;
  background-color: white;
}



#employeeList th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: black;
}
#employeeListfont
{
text-shadow: 3px 2px 2px #4080bf;
color:white;
font-size: 3em;
}
#employeeListbackbtn {
	width: 80px;
	height: 40px;
	font-size: 1em;
	color: black;
	background-color: white;
}

</style>
</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
<h1 style="text-align: center;" id="employeeListfont">Employee List
</h1>
<table id="employeeList">
	<tr>
		<th>Employee Id</th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Gender</th>
		<th>Age</th>
		<th>Address line-1</th>
		<th>Address line-2</th>
		<th>City</th>
		<th>State</th>
		<th>Country</th>
		<th>Pin Code</th>
		<th>Phone Number</th>
		<th>Email Id</th>
		<th>Password</th>
		<th>Role Type</th>
		<th>Manager Id</th>
		<th>Action</th>
		<th>Action</th>
		
	</tr>

<c:forEach items= "${list}" var="eachBook">
	<tr>
		<td><c:out value="${eachBook.employeeId}" /></td>
		<td><c:out value="${eachBook.firstName}" /></td>
		<td><c:out value="${eachBook.lastName}" /></td>
		<td><c:out value="${eachBook.gender}" /></td>
		<td><c:out value="${eachBook.age}" /></td>
		<td><c:out value="${eachBook.address1}" /></td>
		<td><c:out value="${eachBook.address2}" /></td>
		<td><c:out value="${eachBook.city}" /></td>
		<td><c:out value="${eachBook.state}" /></td>
		<td><c:out value="${eachBook.country}" /></td>
		<td><c:out value="${eachBook.pinCode}" /></td>
		<td><c:out value="${eachBook.phoneNumber}" /></td>
		<td><c:out value="${eachBook.email}" /></td>
		<td><c:out value="${eachBook.password}" /></td>
		<td><c:out value="${eachBook.roleType}" /></td>
		<td><c:out value="${eachBook.managerId}" /></td>
		
		<td><a href="edit.in?id=<c:out value='${eachBook.employeeId}'/>">Edit</a></td>
		<td><a href="delete.in?id=<c:out value='${eachBook.employeeId}'/>">Delete</a></td>
	</tr>
</c:forEach>
</table>
<form>
	<input type="button" id="employeeListbackbtn" value="Go back!" onclick="history.back()"></form>
</body>
</html>