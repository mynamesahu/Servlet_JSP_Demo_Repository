package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/login")
public class LoginServlet extends HttpServlet {


	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String userName = req.getParameter("useName");
		String password = req.getParameter("password");
		
		//int num1 = 
		
		
		// get a PrintWriter object 
		PrintWriter out = res.getWriter();
		
		
		
		if ( userName.equals("Sambit")  &&  password.equals("pass123")  ) {
			
					out.println("Welcome " + userName + " to my project.");
					
					
					//Calling another servlet from this servlet
					
					//1- using RequestDispatcher
					//---------------------------
					
					//Put the data in the request object before dispatching the original request to another servlet "AddServlet"
					req.setAttribute("userName", userName);
					
					//Get the RequestDispatcher object that should know which servlet(relative URL path) the request to be forwarded to 
					RequestDispatcher rd = req.getRequestDispatcher("add");	
					
					//forward the original request to the specific servlet via the RequestDispatcher object
					rd.forward(req, res);
							
							
							
					//2- sendRedirect
					//----------------------
					//response.sendRedirect("success.jsp");
			
		} else {
			
					out.println("Un-authorized Login. Please Log in with valid user name and password");
		}
	
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		
		doGet(request, response);
			
		
	}

}
