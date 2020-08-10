package com.servlets.demo03_sendredirect.cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.tomcat.util.http.parser.Cookie;
import javax.servlet.http.Cookie;

@WebServlet("/reqRedirectByCookie")
public class ReqSendRedirectedServlet extends HttpServlet {
	       
    //doGet() method
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//Retrieve the data from the Cookies
		
		// First get the array of cookies from the request object
		Cookie[] cookies = req.getCookies();   
		
		String userName = "";
		
		//Iterate through all the cookies of the "cookies" array
		for(Cookie c : cookies) {
			
			//Check if there is a cookie named "userName" and then get the corresponding value
			if (c.getName().equalsIgnoreCase("userName"))
					
					// Store the value in a variable
					userName = c.getValue();
		}
		
		
		
		//Get a PrintWriter object reference by invoking the "getWriter()" method of ServletResponse interface on the HttpServletResponse object
		PrintWriter out = res.getWriter();
		
		
		
		//Print the data to the client browser via the PrintWriter object reference "out"
		out.println(" The user logged in is : "+userName+" and redirected to this servlet(\"ReqRedirectedServet\") using sendRedirect - Cookies");

	}

	
	
	//doPost() method
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
