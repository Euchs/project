<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:20%;}
	
</style>
<title>SUBMITTED PROPOSALS</title>
</head>
<body>
	<jsp:include page="lecturer.html"/><br/><br/>
	<form action="SubmittedProposalsServlet" method="post">
		<h1>SUBMITTED PROPOSALS</h1>
		<input type="submit" name="proposals" value="See Submitted Proposals"/>
	</form>
</body>
</html>