package com.servlets.demo03_sendredirect.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/reqRedirectBySession")
public class ReqSendRedirectedServlet extends HttpServlet {
	       
    //doGet() method
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Retrieve the data from the session object
		HttpSession session = req.getSession();
		String userName = (String)session.getAttribute("userName");
		
		
		
		//Get a PrintWriter object reference by invoking the "getWriter()" method of ServletResponse interface on the HttpServletResponse object
		PrintWriter out = res.getWriter();
		
		
		
		//Print the data to the client browser via the PrintWriter object reference "out"
		out.println(" The user logged in is : "+userName+" and redirected to this servlet(\"ReqRedirectedServet\") using sendRedirect - Session object");

	}

	
	
	//doPost() method
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
