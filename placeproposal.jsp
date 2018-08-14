<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
	h1{text-align:center;}
	form{text-align:center;margin-top:18%;}
	
</style>
<title>PLACE PROPOSAL</title>
</head>
<body>
<jsp:include page="student.html"/><br/><br/>

<form action="PlaceProposalServlet" method="post">
	<h1>PLACE PROPOSAL</h1>
	Enter The Path To Your Proposal File<br/><br/> <input type="text" name="thePath"/><br/><br/>
	
	<input type="submit" name="propose" value="Place Proposal"/>
</form>
</body>
</html>