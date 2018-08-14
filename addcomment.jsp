<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:17%;}
	
</style>
<title>COMMENT ON EXISTING PROJECT</title>
</head>
<body>
<jsp:include page="lecturer.html"/><br/><br/>
<form action="AddCommentServlet" method="post">
	<h1>COMMENT ON EXISTING PROJECT</h1><br/><br/>
	Enter ProjectID(Student's Registration Number)<br/><br/>  <input type="text" name="theId"/><br/><br/>
	Enter Your Comment Here<br/><br/><textarea name="theTitle" cols="25" rows="4"></textarea><br/><br/>
	<input type="submit" name="addplot" value="PLACE COMMENT"/>
</form>
</body>
</html>