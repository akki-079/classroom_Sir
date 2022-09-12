<%@page import="com.demo.web.util.Authenticator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="controller.jsp">
		<span>User Name</span><input name="username" type="text"><br />
		<span>Password</span><input name="password" type="text"><br />
		<input type="submit" value="Login"><br />
	</form>

	
</body>
</html>