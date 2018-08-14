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
<title>BOOK A PLOT</title>
</head>
<body>
<jsp:include page="student.html"/><br/><br/>

<form action="BookPlotServlet" method="post">
	<h1>BOOK A PLOT</h1>
	Enter Plot Label<br/><br/> <input type="text" name="theLabel"/><br/><br/>
	
	<input type="submit" name="booking" value="Book Plot"/>
</form>
</body>
</html>