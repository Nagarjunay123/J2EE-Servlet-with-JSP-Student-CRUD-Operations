package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/updated")
public class EditStudent extends HttpServlet {
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 	int id=Integer.parseInt(req.getParameter("id"));
	 	String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String dob=req.getParameter("date");
		long phone=Long.parseLong(req.getParameter("phone"));
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		Student student=new Student();
		student.setStudentId(id);
		student.setStudentName(name);
		student.setStudentAge(age);
		student.setStudentDOB(dob);
		student.setStudentPhone(phone);
		student.setStudentEmail(mail);
		student.setStudentPassword(password);
		
		StudentDao studentDao=new StudentDao();
		Student dbstudent2=studentDao.updateStudent(student);
		if(dbstudent2!=null) {
			req.setAttribute("stu", student);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");	
			dispatcher.forward(req, resp);
		}
		
}
}
