package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
@WebServlet("/delete")
public class DeleteStudent extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDao studentDao=new StudentDao();
		boolean s=studentDao.deleteById(id);
		if(s) {
			req.setAttribute("del", "Successfully deleted your Account");
			RequestDispatcher dispatcher=req.getRequestDispatcher("Display.jsp");	
			dispatcher.forward(req, resp);
		}
	}
}
