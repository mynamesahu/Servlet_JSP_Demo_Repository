package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	
	
//	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//				
//		String userName = request.getParameter("useName");
//		String password = request.getParameter("password");
//		
//		PrintWriter out = response.getWriter();
//		
//		
//		
//		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
//			
//					out.println("Welcome " + userName);
//					//response.sendRedirect("success.jsp");
//					//request.getRequestDispatcher("success.jsp");
//			
//		} else {
//			
//					out.println("Un-authorized Login");
//		}
//	
//		
//	}

	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("useName");
		String password = request.getParameter("password");
		
		PrintWriter out = response.getWriter();
		
		
		
		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
			
					out.println("Welcome " + userName);
					//response.sendRedirect("success.jsp");
					//request.getRequestDispatcher("success.jsp");
			
		} else {
			
					out.println("Un-authorized Login. Log in with valid user name and password");
		}
	
	
	}
	
	
	
	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String userName = request.getParameter("useName");
//		String password = request.getParameter("password");
//		
//		PrintWriter out = response.getWriter();
//		
//		
//		
//		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
//			
//					out.println("Welcome " + userName);
//					//response.sendRedirect("success.jsp");
//					//request.getRequestDispatcher("success.jsp");
//			
//		} else {
//			
//					out.println("Un-authorized Login");
//		}
//	
//	
//	}


	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
