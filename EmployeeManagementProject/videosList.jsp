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
<h1 style="text-align: center;" id="videoListfont">Videos List
</h1>
<table id="videoListtable" >
	<tr>
		<th>VideoName</th>
		<th>Duration In Min</th>
		<th>Duration In Sec</th>
		<th>Action</th>
	</tr>

<c:forEach items= "${list}" var="eachVideo">
	<tr>
		<td><c:out value="${eachVideo.videoName}" /></td>
		<td><c:out value="${eachVideo.durationInMin}" /></td>
		<td><c:out value="${eachVideo.durationInSec}" /></td>
		<td><a href="view-video.in?id=<c:out value='${eachVideo.videoId}'/>">Play</a></td>
		
	</tr>
</c:forEach>
</table>
<form>
<input type="button" id="videosListbackbtn" value="Go back!" onclick="history.back()"></form>
</body>
</html>