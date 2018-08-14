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
	<jsp:include page="lecturer.html"/><br/><br/>
	
	<form action="ViewProposalStatuslServlet" method="post">
		<h1>THE PROPOSAL STATUS</h1>
		Enter Registration Number<br/><br/> <input type="text" name="theNum"/><br><br/>
		<input type="submit" name="myProposalStatus" value="View Proposal Status"/>
	</form>
</body>
</html>