<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BOOK A PLOT</title>
</head>
<body>
<h1>BOOK A PLOT</h1>
<form action="BookPlotServlet" method="post">
	Enter Plot Label <input type="text" name="theLabel"/><br/>
	Enter Registration Number <input type="text" name="theReg"/><br/>
	<input type="submit" name="booking" value="Book Plot"/>
</form>
</body>
</html>