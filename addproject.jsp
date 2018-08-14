<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:18%;}
	
</style>
<title>ADD PROJECT</title>
</head>
<body>
<jsp:include page="lecturer.html"/><br/><br/>
<form action="AddProjectServlet" method="post">
	<h1>ADD PROJECT</h1><br/>
	Enter ProjectID(Student's Registration Number)<br/><br/>  <input type="text" name="theId"/><br/><br>
	Enter The Project Title<br/><br/> <textarea name="theTitle" cols="25" rows="4"></textarea><br/><br/>
	<input type="submit" name="addProject" value="ADD PROJECT"/>
</form>
</body>
</html>