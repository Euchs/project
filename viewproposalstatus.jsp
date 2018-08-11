<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<title>MY PROPOSAL STATUS</title>
</head>
<body>
	<h1>MY PROPOSAL STATUS</h1>
	<form action="ViewProposalStatusServlet" method="post">
		Enter Registration Number <input type="text" name="theNum"/><br/>
		<input type="submit" name="myProposalStatus" value="View Proposal Status"/>
	</form>
</body>
</html>