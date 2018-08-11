<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COMMENT ON EXISTING PROJECT</title>
</head>
<body>
<form action="AddCommentServlet" method="post">
	<h1>COMMENT ON EXISTING PROJECT</h1><br/>
	Enter ProjectID(Student's Registration Number)  <input type="text" name="theId"/><br/>
	Enter Your Comment Here <input type="text" name="theTitle"/><br/>
	<input type="submit" name="addplot" value="PLACE COMMENT"/>
</form>
</body>
</html>