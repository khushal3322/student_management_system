package com.jsp.sms.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.sms.controller.AdminController;
import com.jsp.sms.model.Admin;
import com.jsp.sms.model.Student;
@WebServlet(value = "/addstudent")
public class AddStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AdminController adminController = new AdminController();
		
		String studentname = req.getParameter("name");
		
		String contact = req.getParameter("contact");
		long phone = Long.parseLong(contact);
		
		String gender = req.getParameter("gender");
		
		String branch = req.getParameter("branch");
		
		String username = req.getParameter("Username");
		
		String password = req.getParameter("password");
		
		Student student = new Student();
		student.setStudentName(studentname);
		student.setContact(phone);
		student.setGender(gender);
		student.setBranch(branch);
		student.setUsername(username);
		student.setPassword(password);
		
		
		 Admin admin = adminController.fetchAdmin();	
		List<Student> students = admin.getStudents();
		students.add(student);
		
		admin.setStudents(students);
		
		adminController.addStudent(student, admin);
		
		
		
		
	}
}
