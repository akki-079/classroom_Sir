<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Input Page</title>
</head>
<body>
<form action="">
<span>Num1</span><input name="num1" type="text"><br/>
<input type="submit" value="Add"><br/>
</form>
<%
String num1= request.getParameter("num1");
if(num1!=null && !num1.equals("")){
	int num= Integer.parseInt(num1);
	for(int i=0;i<num;i++){%>
	<h1>Hello World</h1>
	<%}
}
%>
</body>
</html>