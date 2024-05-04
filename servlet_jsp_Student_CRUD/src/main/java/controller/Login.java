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
@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		long phone =Long.parseLong(req.getParameter("phone"));
		String password =req.getParameter("password");
		
		StudentDao studentDao=new StudentDao();
		Student student=studentDao.fetchByPhone(phone);
		
		if(student!=null) {
			if(password.equals(student.getStudentPassword())) {
			req.setAttribute("stu", student);
			req.setAttribute("name", student.getStudentName());
			RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");	
			dispatcher.forward(req, resp);
			}
			else {
				req.setAttribute("pass", "Please Enter Correct password");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");	
				dispatcher.forward(req, resp);
			}
		}
		else {
			req.setAttribute("phonee", "Please Enter Correct Phone Number");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");	
			dispatcher.forward(req, resp);
		}
		
	}
	
}
