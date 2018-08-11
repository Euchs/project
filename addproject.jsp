<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD PROJECT</title>
</head>
<body>
<form action="AddProjectServlet" method="post">
	<h1>ADD PROJECT</h1><br/>
	Enter ProjectID(Student's Registration Number)  <input type="text" name="theId"/><br/>
	Enter The Project Title <input type="text" name="theTitle"/><br/>
	<input type="submit" name="addProject" value="ADD PROJECT"/>
</form>
</body>
</html>