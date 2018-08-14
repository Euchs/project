<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:20%;}
	
</style>

<title>ALL BOOKERS</title>
</head>
<body>
	<jsp:include page="lecturer.html"/><br/><br/>
	<form action="AllBookersServlet" method="post">
		<h1>ALL BOOKERS</h1>
		<input type="submit" name="bookers" value="See The Students Who have booked"/>
	</form>
</body>
</html>