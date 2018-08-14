<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Crops Hort and Soils</title>
<style type="text/css">
	form{position:absolute;left:35%;margin-top:10%;border:solid DarkGray 3px;padding:20px;border-radius:10px;}
</style>
</head>

<body>
	<jsp:include page="admin.html"/><br/><br/>
	
	<form action="RegisterLecturerServlet" method="post">
		ADD A LECTURER<br/><br/>
		Enter Employee Number<br/><br/> <input type="text" name="empnumber"><br/><br/>
		Enter Lecturer's Name<br/><br/> <input type="text" name="empname"><br/><br/>
		Enter Password <br/><br/> <input type="password" name="emppass"><br/><br/>
		<input type="submit" name="submitemp" value="ADD LECTURER">
		
		
	</form>

</body>
    
</html>