package com.revature.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.services.Login;


@WebServlet("/login")
public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("EmployeeLoginPage.html").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		Login login = new Login();
		
		System.out.println(request.getParameter("EmployeeUserName"));
		System.out.println(request.getParameter("EmployeePassword"));
		
		boolean test = login.loginTest(request.getParameter("EmployeeUserName"), request.getParameter("EmployeePassword"));
		
		if(test == true) {
			response.sendRedirect("EmployeeHomePage.html");
		}
		else {
			response.sendRedirect("login");
		}
		
		
	}

}
