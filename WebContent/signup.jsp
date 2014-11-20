<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title> Sign up!</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "pikachu" method = "GET">
<center>
Username:
<input type = "text" placeholder = "Enter a Username" name = "newUserName" size = "30%"></br>
Password:
<input type = "password" placeholder = "Enter a Password" name = "password1" size = "30%"></br>
Password:
<input type = "password" placeholder = "Re-enter the Password" name = "password2" size = "30%"></br>
<input type = "submit" value = "Sign Up" onclick = "al()">
<p <%if((request.getParameter("match") == null) || (!request.getParameter("match").equals("false"))) {%> hidden <%} %> style = "color:red"> Passwords don't match </p>
<p <%if((request.getParameter("taken") == null) || (!request.getParameter("taken").equals("true"))) {%> hidden <%} %> style = "color:red"> Username taken </p>
<input type = "hidden" name = "type" value = "signup">
</center>
</form>
</body>
</html>
<!-- yep it is working -->