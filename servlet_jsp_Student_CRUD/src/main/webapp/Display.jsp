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
<% Student student=(Student) request.getAttribute("stu");
String name=(String) request.getAttribute("name");
String message2="Welcome To my World Mr."+name;
if(name!=null){
%>	
<h1 id="h1"><%=message2%></h1>
<%} %>

<table border cellpadding="10" cellspacing="5">

	<tr>
		<td> Id </td>
		<td> Name </td>
		<td> Age </td>
		<td> Date Of Birth </td>
		<td> Phone </td>
		<td> Email </td>
		<td> Password </td>
		<td> Delete </td>
		<td> Update </td>
	</tr>
	<%if(student!=null) {%>
	<tr>
		<td><%= student.getStudentId() %></td>
		<td><%= student.getStudentName() %></td>
		<td><%= student.getStudentAge() %></td>
		<td><%= student.getStudentDOB()%></td>
		<td><%= student.getStudentPhone() %></td>
		<td><%= student.getStudentEmail() %></td>
		<td><%= student.getStudentPassword() %></td>
		<td><a href="delete?id=<%= student.getStudentId()%>"><button>Delete</button></a></td>
		<td><a href="update?id=<%= student.getStudentId()%>"><button>Update</button></a></td>
	</tr>
	<% } %>
</table>
<a href="Login.jsp"><button class="logout">Log Out</button></a>
</body>
</html>