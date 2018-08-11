<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>SEE LATEST COMMENT</title>
</head>
<body>
	<h1>SEE LATEST COMMENT ON MY PROJECT</h1>
	
	<form action="ViewCommentServlet" method="post">
	Enter ProjectID(Student's Registration Number)  <input type="text" name="theId"/><br/>
		<input type="submit" name="myCmments" value="See Latest Comment"/>
	</form>
</body>
</html>