package com.servlets;

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
					
					
					//Call another servlet from this servlet
					//==================================================
					
					
					//1- Using RequestDispatcher
					//---------------------------
					
						//Put the data in the request object 
						req.setAttribute("userName", userName);
						
						//Get the RequestDispatcher object 
						RequestDispatcher rd = req.getRequestDispatcher("reqDispatch");				// where 'reqDispatch' is the url-pattern for the servlet (ReqDispatchedServlet) 
																									// as described in "web.xml" or as mentioned in the "ReqDispatchedServlet" servlet file itself as an "annotation"
						
						//Dispatch the original request to another servlet ("ReqDispatchedServet")
						rd.forward(req, res);
							
							
					
					
					
					
							
					//2- Using sendRedirect with "URL Re-writing"
					//-------------------------------------------
					
//						//Redirect the request to another servlet ("ReqRedirectedServlet1") 
						//modifying the URL with the user data being passed as a query string
//						res.sendRedirect("reqRedirected1?userName="+userName);						// where 'reqRedirected1' is the url-pattern for the servlet (ReqRedirectedServlet1) 
//																									// as described in "web.xml" or as mentioned in the "ReqRedirectedServlet1" servlet file itself as an "annotation"					
					
					
					
					
					
					
					
					//3- Using sendRedirect with "Session object"
					//-------------------------------------------
					
//						//Normally session is used to maintain the User login throughout a Browser session (across all the navigated pages)
//						
//						//Create an HTTP session
//						HttpSession session = req.getSession();					
//						
//						//Put the user data in the session object 
//						session.setAttribute("userName", userName);
//						
//						//Redirect the request to another servlet("ReqRedirectedServlet2")
//						res.sendRedirect("reqRedirected2");											// where 'reqRedirected2' is the url-pattern for the servlet ("ReqRedirectedServlet2") 
//																									// as described in "web.xml" or as mentioned in the "ReqRedirectedServlet2" servlet file itself as an "annotation"
					
					
					
					
					
					
					
					
					//4- Using sendRedirect with "Cookies" 
					//------------------------------------
						/*
							When the client sends a request to the server, the server sends a response to the client, 
							and the response object contains a Cookie (unique ID).
							
							After some time, when the client sends request to the server again, the Cookie object is also to the server implicitly.
							so that the server recognises the request from the identity of its Cookie (irrespective of the servlet that processes the request).
						*/
						
//						//Create a Cookie object by passing the cookie name and cookie value to its constructor
//						Cookie cookie = new Cookie("userName",userName);											
//																													
//						
//						//Add the cookie to the response object (which will be sent to the client)
//						res.addCookie(cookie);
//						
//						//Redirect the request to the servlet("ReqRedirectedServlet3") and the cookie object is sent implicitly
//						res.sendRedirect("reqRedirected3");											// where 'reqRedirected3' is the url-pattern for the servlet ("ReqRedirectedServlet3") 
//																									// as described in "web.xml" or as mentioned in the "ReqRedirectedServlet3" servlet file itself as an "annotation"
						
	
		
		} else { // if the log in is not a valid User 
			
					out.println("Un-authorized Login. Please Log in with valid user name and password");
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
