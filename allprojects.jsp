<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:18%;}
	
</style>

<title>ALL PROJECTS</title>
</head>
<body>
	<jsp:include page="lecturer.html"/><br/><br/>
	
	<form action="AllProjectsServlet" method="post">
		<h1>SEE ALL PROJECTS</h1>
		<input type="submit" name="projectsAvailable" value="See The Available Projects"/>
	</form>
</body>
</html>