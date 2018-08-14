<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:20%;}
	
</style>

<title>MY PROPOSAL STATUS</title>
</head>
<body>
	<jsp:include page="student.html"/><br/><br/>
	
	<form action="ViewProposalStatusServlet" method="post">
		<h1>MY PROPOSAL STATUS</h1>
		
		<input type="submit" name="myProposalStatus" value="Check If My Proposal Has Been Approved"/>
	</form>
</body>
</html>