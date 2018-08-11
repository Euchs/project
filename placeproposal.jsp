<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PLACE PROPOSAL</title>
</head>
<body>
<h1>PLACE PROPOSAL</h1>
<form action="PlaceProposalServlet" method="post">
	Enter The Path To Your Proposal File <input type="text" name="thePath"/><br/>
	Enter Registration Number <input type="text" name="theReg"/><br/>
	<input type="submit" name="propose" value="Place Proposal"/>
</form>
</body>
</html>