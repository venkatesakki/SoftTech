<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>video</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<style>
.head{
text-align: center;
background-color:black;
}
.h3{
font-family: cursive;
font-size: 2.5em;
font-weight: bold;
color: white;
}
.tablecenter{
 margin-left: auto;
 margin-right: auto;
}
.h5{
font-family: cursive;
font-size: 1.7em;
font-weight: bold;
color: white;
}

</style>
<body style="background-image: url('images/bgdash1.jpg'); height: 100vh;">
<div class="container-fluid">
	<div class="row">
	  <div class="col-md-12"><div class="head"><h3 class="h3">Video Details</h3></div></div>
	</div>
	
	<div class="row">
	<div class="col-md-6">
	<table style="margin-top: 135px;" class="tablecenter">
	<tbody>
	<c:forEach items= "${list}" var="eachVideo">
	<tr class="h5"><td style="width:40%;"><label>Video Id</label> </td>
		<td><input type="text" name="videoId" value="${eachVideo.videoId}" style="width:150%;"  readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Video Name</label> </td>
		<td><input type="text" name="videoName" value="${eachVideo.videoName}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Duration-In-Min</label> </td>
		<td><input type="text" name="durationMin" value="${eachVideo.durationInMin}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>Duration-In-Sec</label> </td>
		<td><input type="text" name="durationSec" value="${eachVideo.durationInSec}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	
	<tr class="h5"><td style="width:40%;"><label>URL</label> </td>
		<td><input type="text" name="url" value="${eachVideo.url}" style="width:150%;" readonly="readonly"/></td>
	</tr>
	</c:forEach>
	</tbody>
	</table>
	
	</div>
	<div class="col-md-1"></div>
	<div class="col-md-5">
	<div style="text-align: center;">
	<img alt="sampleBookImg" src="images/videoImg.jpg" style="width: 55%; height: 443px; margin-top: 30px; border-radius: 15px">
	</div>
	</div>
	
</div>
</div>

</body>
</html>