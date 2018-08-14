<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:20%;}
	
</style>

<title>MY PROPOSAL</title>
</head>
<body>
	<jsp:include page="student.html"/><br/><br/>
	
	<form action="ViewProposalServlet" method="post">
		<h1>MY PROPOSAL</h1>
		
		<input type="submit" name="myProposal" value="View Proposal"/>
	</form>
</body>
</html>