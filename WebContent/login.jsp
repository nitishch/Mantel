<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "pikachu" method = "GET">
<center>
Username:
<input type = "text" name = "userName" size = "30%"><br>
Password:
<input type = "password" name = "password" size = "30%"><br>
<input type = "submit" value = "Log in" onclick = "al()">
<input type = "hidden" name = "type" value = "login">
<p>
	Not yet joined us? <a href = "signup.jsp"> Join now </a>
</p>
<p <%if((request.getParameter("registered") == null) || (!request.getParameter("registered").equals("false"))){%> hidden <%}%> style = "color: red"> User not registered </p>
<p <%if((request.getParameter("wrong") == null) || (!request.getParameter("wrong").equals("true"))){%> hidden <%}%> style = "color: red"> Wrong password </p>

</center>
</form>
</body>
</html>