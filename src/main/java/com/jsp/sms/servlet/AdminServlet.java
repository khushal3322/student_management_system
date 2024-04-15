package com.jsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.sms.controller.AdminController;
import com.jsp.sms.controller.StudentController;
import com.jsp.sms.model.Admin;
import com.jsp.sms.model.Student;
@WebServlet(value = "/adminServlet")
public class AdminServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		AdminController aController = new AdminController();
		StudentController sController= new StudentController();
		
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		 PrintWriter printWriter = resp.getWriter();
		
		System.out.println(username);
		System.out.println(password);
		
		Admin admin = aController.fetchAdmin();
		
		
		if (username.equals(admin.getUsername()) && password.equals(admin.getPassword())) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Dashboard.html"); //TODO
			requestDispatcher.forward(req, resp);
		} else {
			
//			resp.sendRedirect("Admin.html");
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("Admin.html");
			requestDispatcher.include(req, resp);
			printWriter.print("<html><body>");
			printWriter.print("<h4> Not matched. Try Again</h4>");
			printWriter.print("</body></html>");
		}
	}

}
