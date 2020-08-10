package com.servlets.demo03_sendredirect.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Get a PrintWriter object 
		PrintWriter out = res.getWriter();
		
		
		//Get user input data
		String userName = req.getParameter("useName");
		String password = req.getParameter("password");
		
		
		
		//Verify the User Login
		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
			
					out.println("Welcome " + userName + " to my project.");
					
					
					
					//2- Using sendRedirect with "URL Re-writing"
					//-------------------------------------------
					
						//Redirect the request to another servlet ("ReqRedirectedServlet1") 
						//modifying the URL with the user data being passed as a query string
						res.sendRedirect("reqRedirectByURLRewriting?userName="+userName);			// where 'reqRedirected1' is the url-pattern for the servlet (ReqRedirectedServlet1) 
																									// as described in "web.xml" or as mentioned in the "ReqRedirectedServlet1" servlet file itself as an "annotation"					
					
					
					
					
					
		
		
		} else { // if the log in is not a valid User 
			
					out.println("Un-authorized Login. Please Log in with valid user name and password");
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
