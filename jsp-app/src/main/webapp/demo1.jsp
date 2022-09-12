<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>my first JSP</title>
</head>
<body>
	<h1>Hello from JSP</h1>
	<%=new java.util.Date()%>
	<!-- Scripting element -->
	<br />
	<%!int add(int a, int b) {
		return a + b;
	}%>

	<hr>
	<%
	String num1=request.getParameter("num1");
	String num2=request.getParameter("num2");
	
	if(num1!=null&&num2!=null&&!num1.equals("")&&!num2.equals("")){
		
		out.print(add(Integer.parseInt(num1), Integer.parseInt(num2)));
	}
	
	%>
	<hr>
	<br />
	<%
	out.println(add(4, 8));
	%>
	<br />
	<%=add(5, 9)%>
</body>
</html>