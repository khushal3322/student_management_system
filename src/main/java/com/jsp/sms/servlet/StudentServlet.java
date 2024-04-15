package com.jsp.sms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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
@WebServlet(value = "/studentServlet")
public class StudentServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		AdminController aController = new AdminController();
		StudentController sController  = new StudentController();	
		String username = req.getParameter("username"); //TODO
		String password = req.getParameter("password"); //TODO
		Admin admin = new Admin();
		
		PrintWriter writer = resp.getWriter();
		List<Student> students = sController.fetchAllStudent();
//		List<Student> students2 = admin.getStudents();
		writer.print("ny");
	
		System.out.println(students);
		
		for (Student student : students) {
			writer.print("student :"+student.getUsername());
		}
		boolean flag = true;
		for (Student student : students) {
			if (username.equals(student.getUsername()) && password.equals(student.getPassword())) {
				flag = false;
				req.setAttribute("featch", student);
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("StudentDashboard"); //TODO
				requestDispatcher.forward(req, resp);
				
				break;
			}
		}
		if (flag) {
			
			resp.sendRedirect("Student.html"); //TODO
			writer.print("<html><body>");
			writer.print("<h4>Credentials Not matched.</h4>");
			writer.print("</body></html>");
		}
	}
}
