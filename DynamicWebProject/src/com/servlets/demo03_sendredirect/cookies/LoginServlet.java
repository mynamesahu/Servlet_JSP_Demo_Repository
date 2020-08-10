package com.servlets.demo03_sendredirect.cookies;

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
		
		String userName = req.getParameter("useName");
		String password = req.getParameter("password");
		
				
		
		// get a PrintWriter object 
		PrintWriter out = res.getWriter();
		
		
		//Verify the User Login
		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
			
					out.println("Welcome " + userName + " to my project.");
					
					
					//Call another servlet from this servlet - Using sendRedirect with "Cookies" 
					//==========================================================================
						/*
							When the client sends a request to the server, the server sends a response to the client, 
							and the response object contains a Cookie (unique ID).
							
							After some time, when the client sends request to the server again, the Cookie object is also to the server implicitly.
							so that the server recognises the request from the identity of its Cookie (irrespective of the servlet that processes the request).
						*/
						
						//Create a Cookie object by passing the cookie name and cookie value to its constructor
						Cookie cookie = new Cookie("userName",userName);											
																													
						
						//Add the cookie to the response object (which will be sent to the client)
						res.addCookie(cookie);
						
						//Redirect the request to the servlet("ReqRedirectedServlet3") and the cookie object is sent implicitly
						res.sendRedirect("reqRedirectByCookie");									// where 'reqRedirected3' is the url-pattern for the servlet ("ReqRedirectedServlet3") 
																									// as described in "web.xml" or as mentioned in the "ReqRedirectedServlet3" servlet file itself as an "annotation"
						
	
		
		} else { // if the log in is not a valid User 
			
					out.println("Un-authorized Login. Please Log in with valid user name and password");
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
