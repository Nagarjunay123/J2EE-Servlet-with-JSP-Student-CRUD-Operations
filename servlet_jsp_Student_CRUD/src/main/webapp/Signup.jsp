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
<h1 id="h1">Welcome to Registration page</h1>
<%
String signup=(String) request.getAttribute("signup");
%>
<% String s=(String)request.getAttribute("del"); 
if(s!=null){
	%>
	<h3><%= s%></h3>
<%} %>
<form action="signup" method="post">
<label>Name : </label>
<input type="text" placeholder="Please Enter Your Full Name" name="name"><br><br>

<label>Age : </label>
<input type="number" placeholder="Please Enter Your Age" name="age"><br><br>

<label>Date Of Birth : </label>
<input type="date" placeholder="select your dob" name="date"><br><br>

<label>Phone : </label>
<input type="tel" placeholder="Please Enter Your Phone number" name="phone"><br><br>


<% if(signup!=null) {%> <p><%= signup %></p><% } %>

<label>Email : </label>
<input type="email" placeholder="Please Enter Your Email" name="mail"><br><br>

<label>Password : </label>
<input type="password" placeholder="Please Enter Your Password" name="password"><br><br>

<button class="signup">SignUp</button>

</form>
<a href="Login.jsp"><button id="nag" class="signupp">Login</button></a>
</body>
</html>