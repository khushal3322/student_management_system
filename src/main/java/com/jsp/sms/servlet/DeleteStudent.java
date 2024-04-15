package com.jsp.sms.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.sms.controller.AdminController;
import com.jsp.sms.model.Student;
@WebServlet(value = "/deleteStudent")
public class DeleteStudent extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String parameter = req.getParameter("delete");
		
		int delete_id = Integer.parseInt(parameter);
		
		AdminController adminController = new AdminController();
		//Student findstudent = adminController.featchstudent(delete_id);
		
		boolean deletepraticularStudent = adminController.DeletepraticularStudent(delete_id);
		
		if (deletepraticularStudent==true) {
			System.out.println("zal");
		} else {
			System.out.println("ny");
		}
	}
}
