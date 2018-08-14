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
	<jsp:include page="lecturer.html"/><br/><br/>
	
	<form action="ViewProposallServlet" method="post">
		<h1>THE PROPOSAL</h1>
		Enter Registration Number<br/><br/> <input type="text" name="theNum"/><br/><br/>
		<input type="submit" name="myProposal" value="View Proposal"/>
	</form>
</body>
</html>