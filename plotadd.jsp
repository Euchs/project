<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:20%;}
	
</style>
<title>ADD PLOT</title>
</head>
<body>
<jsp:include page="lecturer.html"/><br/><br/>
<form action="AddPlot" method="post">
	<h1>ADD PLOT</h1><br/>
	Enter Plot Label As an Alphabet <br/><br/>
	<input type="text" name="theLabel"/><br/><br/>
	<input type="submit" name="addplot" value="ADD PLOT"/>
</form>
</body>
</html>