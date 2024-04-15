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
import com.jsp.sms.model.Student;
@WebServlet(value = "/featchstudent")
public class FeatchStudent extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String featch = req.getParameter("featch");
		
		int studentid = Integer.parseInt(featch);
		
		AdminController adminController = new AdminController();
		Student student = adminController.featchstudent(studentid);
		
		
		System.out.println(student.getUsername());
		PrintWriter printWriter = resp.getWriter();
		
		if (student!=null) {
//			printWriter.print("<html><body>");
//			printWriter.print("<h3>Id :<h3>"+ student.getStudentId());
//			printWriter.print("<h3>Name :<h3>"+ student.getStudentName());
//			printWriter.print("<h3>contact :<h3>"+ student.getContact());
//			printWriter.print("<h3>branch :<h3>"+ student.getBranch());
//			printWriter.print("<h3>gender :<h3>"+ student.getGender());
//			printWriter.print("<h3>Username :<h3>"+ student.getUsername());
//			printWriter.print("<h3>password :<h3>"+ student.getPassword());
//			printWriter.print("<a href=\"Update.html\">add</a>");
//			printWriter.print("</body></html>");
			printWriter.print("<html><body>");
			printWriter.print("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Student Dashboard</title>\r\n"
					+ "    <style>\r\n"
					+ "        body {\r\n"
					+ "            font-family: Arial, sans-serif;\r\n"
					+ "            background-color: #f4f4f4;\r\n"
					+ "            margin: 0;\r\n"
					+ "            padding: 0;\r\n"
					+ "        }\r\n");
			printWriter.print(" a {\r\n"
					+ "            display: block;\r\n"
					+ "            padding: 10px;\r\n"
					+ "            margin: 5px;\r\n"
					+ "            background-color: #3498db;\r\n"
					+ "            color: white;\r\n"
					+ "            text-align: center;\r\n"
					+ "            text-decoration: none;\r\n"
					+ "            border-radius: 5px;\r\n"
					+ "        }\r\n"
					+ "\r\n"
					+ "        a:hover {\r\n"
					+ "            background-color: #2980b9;\r\n"
					+ "        }"
					+ "        header {\r\n"
					+ "            background-image: linear-gradient(red,yellow);\r\n"
					+ "            color: black;\r\n"
					+ "            text-align: center;\r\n"
					+ "            padding: 1em;\r\n"
					+ "        }\r\n"
					+ "        section {\r\n"
					+ "            display: flex;\r\n"
					+ "            justify-content: center;\r\n"
					+ "            align-items: center;\r\n"
					+ "            min-height: 80vh;\r\n"
					+ "        }\r\n"
					+ "        table {\r\n"
					+ "            width: 80%;\r\n"
					+ "            border-collapse: collapse;\r\n"
					+ "            margin: 2em auto;\r\n"
					+ "        }\r\n"
					+ "        th, td {\r\n"
					+ "            border: 1px solid #ddd;\r\n"
					+ "            padding: 12px;\r\n"
					+ "            text-align: left;\r\n"
					+ "        }\r\n"
					+ "        th {\r\n"
					+ "            background-color: black;\r\n"
					+ "            color: blue;\r\n"
					+ "            text-align: center;\r\n"
					+ "        }\r\n"
					+ "        tr:nth-child(even) {\r\n"
					+ "            background-color: #f2f2f2;\r\n"
					+ "        }\r\n"
					+ "        td{\r\n"
					+ "            color: greenyellow;\r\n"
					+ "            background-color: gray;\r\n"
					+ "        }\r\n"
					+ "    </style>\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <header>\r\n"
					+ "        <h1>Student Dashboard</h1>\r\n"
					+ "    </header>\r\n"
					+ "    <section>\r\n"
					+ "        <table>\r\n"
					+ "            <thead>\r\n"
					+ "                <tr>\r\n"
					+ "                    <th>Student ID</th>\r\n"
					+ "                    <th>Student Name</th>\r\n"
					+ "                    <th>Student Gender</th>\r\n"
					+ "                    <th>Student Branch</th>\r\n"
					+ "                </tr>\r\n"
					+ "            </thead>\r\n"
					+ "            <tbody>\r\n"
					+ "                <tr>\r\n"
					+ "                    <td>"+student.getStudentId() +"</td>\r\n"
					+ "                    <td>"+student.getStudentName()+"</td>\r\n"
					+ "                    <td>"+student.getGender()+"</td>\r\n"
					+ "                    <td>"+student.getBranch()+"</td>\r\n"
					+ "                </tr>\r\n"
					+ "               \r\n"
					+ "                \r\n"
					+ "            </tbody>\r\n"
					+ "        </table>\r\n");
				printWriter.print("<a href=\"Dashboard.html\">Curd</a>"
					+ "    </section>");
			printWriter.print("</body></html>");
		} else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("featchstudent");
			
			requestDispatcher.include(req, resp);
			printWriter.print("<html><body>");
			printWriter.print("<h3>Id :<h3>"+ studentid+"<h3>not available<h3>");
			printWriter.print("</body></html>");
		}
		
	
	}
}
