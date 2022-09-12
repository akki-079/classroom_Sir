<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	<h1>Register Employee</h1>
	<hr>
	<form action="controller" method="get">
	<span>Emp ID</span><input type="text" name="empId"><br/>
	<span>Name</span><input type="text" name="name"><br/>
	<span>City</span><input type="text" name="city"><br/>
	<span>Salary</span><input type="text" name="salary"><br/>
	<input type="hidden" name="operation" value="register">
	<input type="submit" value="Register"><br/>
	
	</form>
</body>
</html>