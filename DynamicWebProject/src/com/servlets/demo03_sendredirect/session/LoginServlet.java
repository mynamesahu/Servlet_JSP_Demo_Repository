package com.servlets.demo03_sendredirect.session;

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
				
		
		//Get the user input data
		String userName = req.getParameter("useName");
		String password = req.getParameter("password");
		
				
			
		
		//Verify the User Login
		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
			
					out.println("Welcome " + userName + " to my project.");
					
					
					//Call another servlet from this servlet - by using sendRedirect with "Session object"
					//===================================================================================
					
					
					/*
					  	Normally session is used to "maintain the User login authentication" throughout a Browser session 
						(That means it maintains the user login authentication across all the navigated pages in a session)
					*/

					//Create an HTTP session
					HttpSession session = req.getSession();					
					
					//Put the user data in the session object 
					session.setAttribute("userName", userName);
					
					//Redirect the request to another servlet("reqRedirectBySession")
					res.sendRedirect("reqRedirectBySession");											// where 'reqRedirected2' is the url-pattern for the servlet ("ReqRedirectedServlet2") 
																								// as described in "web.xml" or as mentioned in the "ReqRedirectedServlet2" servlet file itself as an "annotation"
					
		
		
		} else { // if the log in is not a valid User 
			
					out.println("Un-authorized Login. Please Log in with valid user name and password");
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
