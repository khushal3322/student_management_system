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
import com.jsp.sms.model.Student;

@WebServlet(value = "/UpdatebyStudent")
public class UpdatebyStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		String student_idstr = req.getParameter("Student");
		String conStr = req.getParameter("Contact");
		String password = req.getParameter("password");
		
		long contact = Long.parseLong(conStr);
		int student_id = Integer.parseInt(student_idstr);
		
		AdminController admincontroller = new AdminController();
		StudentController studentController = new StudentController();
		
		Student student = admincontroller.featchstudent(student_id);
		
		student.setContact(contact);
		student.setPassword(password);
		
		 boolean updateStudent1 = studentController.updateStudent1(student);
		

			PrintWriter printwriter = resp.getWriter();
			
		if (updateStudent1==true) {
			
			 
			
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("UpdateByStudent.html");
			requestDispatcher.forward(req, resp);
			printwriter.print("Not updated try again !!!");
			printwriter.print("");
		}
		
		
		
		
	}
}
