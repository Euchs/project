<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:20%;}
	
</style>

<title>SEE LATEST COMMENT</title>
</head>
<body>
	<jsp:include page="lecturer.html"/><br/><br/>
	
	<form action="ViewCommentlServlet" method="post">
	<h1>SEE LATEST COMMENT ON A PROJECT</h1>
	Enter ProjectID(Student's Registration Number) <br/><br/> <input type="text" name="theId"/><br/><br/>
		<input type="submit" name="myCmments" value="See Latest Comment"/>
	</form>
</body>
</html>