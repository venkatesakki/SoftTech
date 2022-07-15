<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#book {
margin-left:35%;
  font-family: Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 30%;
  
}

#book td, th {
  border: 1px solid #ddd;
  padding: 8px;
  background-color: white;
}

#book tr:hover {background-color: #ddd;}

#book th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #04AA6D;
  color: white;
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
<h1 style="text-align: center;" id="font">Books List
</h1>
<table id="book" >
	<tr>
		
		<th>Book Name</th>
		<th>Author Name</th>
		<th>Action</th>
		
		
	</tr>

<c:forEach items= "${list}" var="eachBook">
	<tr>
		
		<td><c:out value="${eachBook.bookName}" /></td>
		<td><c:out value="${eachBook.authourName}" /></td>
		<td><a href="viewBook.in?id=<c:out value='${eachBook.bookId}'/>">Open</a></td>
	</tr>
</c:forEach>
</table>

</body>
</html>