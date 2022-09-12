<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="auth" class="com.demo.web.util.Authenticator"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login Success for <jsp:getProperty name="auth" property="username"/></h1>
</body>
</html>