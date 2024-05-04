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

@WebServlet("/update")
public class Update extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDao studentDao=new StudentDao();
		Student s=studentDao.fetchById(id);
		if(s!=null) {
			req.setAttribute("up", s);
			RequestDispatcher dispatcher=req.getRequestDispatcher("Update.jsp");	
			dispatcher.forward(req, resp);
		}
	}
}
