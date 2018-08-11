<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import ="manageProjects.Plots" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Available plots</title>
</head>
<body>
<%

String p = (String)request.getAttribute("plots");
out.println(p);

%>

</body>
</html>