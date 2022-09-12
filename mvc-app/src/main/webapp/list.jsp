<%@page import="com.demo.web.Emp"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Page</title>
</head>
<body>
<table>
	<c:forEach var="emp" items="${eList}">
	<tr>
		<td><c:out value="${emp.empId}" /> </td>
		<td><c:out value="${emp.name}" /></td>
		<td><c:out value="${emp.city}" /></td>
		<td><c:out value="${emp.salary}" /></td>
	</tr>
</c:forEach>
</table>
</body>
</html>