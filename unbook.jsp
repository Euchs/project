<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UNBOOK A STUDENT</title>
<style type="text/css">
	body{text-align:center;}
	form{margin-top:10%;}
	
</style>

</head>
<body>
<jsp:include page="admin.html"/><br/><br/>

<form action="UnbookAstudentServlet" method="post">
    UNBOOK A STUDENT<br/><br/>
	Enter Registration Number <br/><br/><input type="text" name="theReg"/><br/><br/>
	<input type="submit" name="unbooking" value="Unbook A Student"/>
</form>
</body>
</html>