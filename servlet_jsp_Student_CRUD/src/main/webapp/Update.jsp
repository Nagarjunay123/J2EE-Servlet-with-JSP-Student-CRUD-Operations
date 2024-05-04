<%@page import="dto.Student"%>
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
<% Student student=(Student) request.getAttribute("up"); %>
<h1 class="vignan">Welcome to Update page here you can change your details</h1>
<form action="updated" method="post">
<label>Id : </label>
<input type="number" placeholder=<%=student.getStudentId() %> name="id" readonly value="<%=student.getStudentId()%>"><br><br>

<label>Name : </label>
<input type="text" placeholder="Please Enter Your Full Name" name="name" value="<%= student.getStudentName()%>"><br><br>

<label>Age : </label>
<input type="number" placeholder="Please Enter Your Age" name="age" value="<%= student.getStudentAge()%>"><br><br>

<label>Date Of Birth : </label>
<input type="date" placeholder="select your dob" name="date" value="<%= student.getStudentDOB()%>"><br><br>

<label>Phone : </label>
<input type="tel" placeholder="Please Enter Your Phone number" name="phone" value="<%= student.getStudentPhone()%>"><br><br>

<label>Email : </label>
<input type="email" placeholder="Please Enter Your Email" name="mail" value="<%= student.getStudentPassword()%>"><br><br>

<label>Password : </label>
<input type="password" placeholder="Please Enter Your Password" name="password" value="<%= student.getStudentPassword()%>"><br><br>

<button>Update</button>


</form>
</body>
</html>