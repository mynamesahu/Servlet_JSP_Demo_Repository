package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/add")
public class AddServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Retrieve the data from the request object and Cast to string
		String userName = (String)req.getAttribute("userName");
		
		//Get the Writer object referenced by PrintWriter
		PrintWriter out = res.getWriter();
		
		//Print the data to the client browser via the Writer object
		out.println("The user logged in is : "+userName+" and then forwarded by LoginServlet to perform add operation");
		//out.println("sum = " +result);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
