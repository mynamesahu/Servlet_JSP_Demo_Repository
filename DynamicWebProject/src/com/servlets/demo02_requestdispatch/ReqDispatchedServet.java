package com.servlets.demo02_requestdispatch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reqDispatch")
public class ReqDispatchedServet extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		//Get a PrintWriter object 
		PrintWriter out = res.getWriter();
		
		
		//Retrieve the data from the request object and Cast to string
		String userName = (String)req.getAttribute("userName");
		
				
		//Print the data to the client browser via the PrintWriter object reference "out"
		out.println(" The user logged in is : "+userName+" and forwarded to this servlet(\"ReqDispatchedServet\") using RequestDispatcher");
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

	
}
