package com.servlets.demo04_servletcontext_and_servletconfig;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




//Specify the "servlet URL mapping" using "annotation"  - @WebServlet(...)
//									       in this servlet code itself instead of specifying in the "web.xml"

@WebServlet("/serv3")
public class Servlet3 extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		
		
		//Retrieve the ServletContext parameters initialised inside <context-param> tag in the "web.xml"
		ServletContext 	ctx 			= req.getServletContext();
		String 			organization 	= ctx.getInitParameter("organization");
		out.println("Display the ServletContext Parameters - accessible to all the servlets in the application");
		out.println("---------------------------------------------------------------------------------------------");
		out.println("organization = "+organization);
	
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
