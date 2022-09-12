<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Finder Page</title>
</head>
<body>
	<form action="controller" method="get">
		<span>Emp ID</span><input type="text" name="empId"><br />
		<input type="hidden" name="operation" value="find">
		<input type="submit" value="Find">
	</form>
	
	<c:set var="emp" value="${e}"/>
	
	<c:out value="${emp.name}"></c:out>
	
</body>
</html>