package com.servlets.demo03_sendredirect.urlrewriting;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/reqRedirectByURLRewriting")
public class ReqSendRedirectedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Retrieve the data from the URL query string
		String userName = (String)req.getParameter("userName");
		
		
		
		//Get a PrintWriter object reference by invoking the "getWriter()" method of ServletResponse interface on the HttpServletResponse object
		PrintWriter out = res.getWriter();
		
		
		
		//Print the data to the client browser via the PrintWriter object reference "out"
		out.println(" The user logged in is : "+userName+" and redirected to this servlet(\"ReqRedirectedServet\") using sendRedirect - URL Rewriting");

	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
