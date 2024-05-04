<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./SudentStylish.css">
</head>
<body>
<% String msg=(String) request.getAttribute("msg"); 
if(msg!=null){
	%>
	<h3><%= msg%></h3>
<%}%>
<h1 id="h1">Welcome to Login page</h1>

<form action="login" method="post">
<label>Phone : </label>
<input type="tel" placeholder="Please Enter Your Phone number" name="phone"><br><br>
<% String phonee=(String) request.getAttribute("phonee"); 
if(phonee!=null){%>
	<p><%= phonee%></p>
<%}%>

<label>Password : </label>
<input type="password" placeholder="Please Enter Your Password" name="password"><br><br>
<% String pass=(String) request.getAttribute("pass"); 
if(pass!=null){%>
	<p><%= pass%></p>
<%}%>

<button class="login">login</button>

</form>
<a href="Signup.jsp"><button class="loginn">SignUp</button></a>

</body>
</html>