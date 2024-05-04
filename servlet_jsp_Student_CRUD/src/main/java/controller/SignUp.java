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
@WebServlet("/signup")
public class SignUp extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String dob=req.getParameter("date");
		long phone=Long.parseLong(req.getParameter("phone"));
		String mail=req.getParameter("mail");
		String password=req.getParameter("password");
		
		StudentDao studentDao=new StudentDao();
		Student dbstudent=studentDao.fetchByPhone(phone);
		if(dbstudent!=null) {
			req.setAttribute("signup", "Phone number Already register please go with Login");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Signup.jsp");	
			dispatcher.forward(req, resp);
					
		}
		else {
		Student student=new Student();
		student.setStudentName(name);
		student.setStudentAge(age);
		student.setStudentDOB(dob);
		student.setStudentPhone(phone);
		student.setStudentEmail(mail);
		student.setStudentPassword(password);
		
		Student dbstudent2=studentDao.saveStudent(student);
		if(dbstudent2!=null) {
			req.setAttribute("msg", "Congrats Your succussfully Register Please Proceed to Login");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");	
			dispatcher.forward(req, resp);
		}
		}
	}
}
