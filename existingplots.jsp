<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	form{text-align:center;margin-top:20%;}

</style>
<title>ALL PLOTS</title>
</head>
<body>
	<jsp:include page="lecturer.html"/><br/><br/>
	<form action="AllPlotsServlet" method="post">
		<h1>ALL PLOTS</h1>
		<input type="submit" name="allPlots" value="See All Existing Plots"/>
	</form>
</body>
</html>