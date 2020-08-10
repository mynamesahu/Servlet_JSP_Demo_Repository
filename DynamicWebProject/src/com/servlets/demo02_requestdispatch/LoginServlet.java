package com.servlets.demo02_requestdispatch;

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
		
		
		//Retrieve the user data
		String userName = req.getParameter("useName");
		String password = req.getParameter("password");

		
		//Verify the User Login
		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
			
					out.println("Welcome " + userName + " to my project.");
					
					
					//Call another servlet from this servlet - Using RequestDispatcher
					//=================================================================
					//Put the data in the request object 
					req.setAttribute("userName", userName);
					
					//Get the RequestDispatcher object 
					RequestDispatcher rd = req.getRequestDispatcher("reqDispatch");				// where 'reqDispatch' is the url-pattern for the servlet (ReqDispatchedServlet) 
																								// as described in "web.xml" or as mentioned in the "ReqDispatchedServlet" servlet file itself as an "annotation"
					
					//Dispatch the original request to another servlet ("ReqDispatchedServet")
					rd.forward(req, res);
					
					
						
		
		
		} else { // if the log in is not a valid User 
			
					out.println("Un-authorized Login. Please Log in with valid user name and password");
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
