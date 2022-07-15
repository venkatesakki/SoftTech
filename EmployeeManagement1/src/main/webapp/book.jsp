<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<style>
.head{
text-align: center;

}
.h3{
font-family: cursive;
font-size: 2.5em;
font-weight: bold;
}
.tablecenter{
 margin-left: auto;
 margin-right: auto;
}
.h5{
font-family: cursive;
font-size: 1.5em;
font-weight: bold;
}
#backimage
{
background-image: url("images/bookbg.jpg");
background-repeat: no-repeat;
background-size: cover;
height: 100vh;
}

</style>
<body>
<div class="container-fluid" id="backimage">
	<div class="row">
	  <div class="col-md-12"><div class="head"><h3 class="h3" style="margin-top:20px;">Book Details</h3></div></div>
	</div>
	
	<div class="row">
	<div class="col-md-6">
	<table style="margin-top: 90px; margin-top: 100px;" class="tablecenter" >
	<tbody>
	<c:forEach items= "${list}" var="eachBook">
	<tr class="h5"><td style="width:40%;"><label>Book Name</label> </td>
		<td><input type="text" name="bookName" value="${eachBook.bookName}" style="width:150%;" readonly="readonly"/></td>
		
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Author Name</label> </td>
		<td><input type="text" name="authorName" value="${eachBook.authourName}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Publisher Name</label> </td>
		<td><input type="text" name="publisherName" value="${eachBook.publisherName}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Total Pages</label> </td>
		<td><input type="text" name="totalPages" value="${eachBook.noOfPages}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Price</label> </td>
		<td><input type="text" name="price" value="${eachBook.price}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Language</label> </td>
		<td><input type="text" name="language" value="${eachBook.language}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Rating</label> </td>
		<td><input type="text" name="rating" value="${eachBook.rating}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	</div>

	<div class="col-md-6">
	<div style="text-align: center;margin-top: 30px;">
	<img alt="sampleBookImg" src="images/imgBook6.jpg" style="width: 60%; height: 503px;">
	</div>
	</div>
	
</div>
</div>

</body>
</html>