<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link rel="stylesheet" href="style/Style.css">

</head>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
<h1 style="text-align: center;" id="bookListfont">Books List
</h1>
<table id="booklisttable" >
	<tr>
		
		<th>Book Name</th>
		<th>Author Name</th>
		<th>Action</th>
		
		
	</tr>

<c:forEach items= "${list}" var="eachBook">
	<tr>
		
		<td><c:out value="${eachBook.bookName}" /></td>
		<td><c:out value="${eachBook.authourName}" /></td>
		<td><a href="view-book.in?id=<c:out value='${eachBook.bookId}'/>">Open</a></td>
	</tr>
</c:forEach>
</table>
<form>
<input type="button" id="bookListbackbtn" value="Go back!" onclick="history.back()"></form>
</body>
</html>