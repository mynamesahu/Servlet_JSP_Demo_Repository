
Servlet
=======================================================================================================
	
	
	service()
	---------
			We can use service() method if there is no restriction on how we send data to the server
			whenever a servlet is requested, it first invokes the service() method
			Depending on the type of request, it will call either doGet() or doPost() method
			
			if we are not using doGet() or doPost() method in the servlet
			then service() method will operate on the data irrespective of the way it has been sent to the server
			
			
			As a developer, if we want the user data to be sent to the server via a specific protocol 
			then we have to use either "doGet()" or "doPost()"	
			which will be called by the service() method in the background to perform the operation
			
			We can use both "doGet()" and "doPost()" methods for same operation at the same time
			In that case we can write the code inside doGet() method
			and then call the doGet() method inside the doPost() method for better design
			Depending on the way data has been sent from the client(jsp file), the respective method - doGet() or doPost() will be called to perform the operation
			
			
	
	doGet() 
	---------
			 - We can use "doGet()" method if we do not need to hide the data (to be sent to the server)
			 - service() method is invoked in the background which executes the doGet() method
			 - the user data is sent to the server via query string in the URL
			 - used by Default (That means no need to mention method=get inside the <form> tag of jsp file
			 
			 
					<form action = "login">
						<input type="text" 		name ="userName">
						<input type="text" 		name ="password">
						<input type="submit" 	value ="SUBMIT">
					</form>

			- servlet retrieves the data as  - request.getParameter("userName") inside the doGet() method
			 		  performs operation on the data
			 		  sends the final data back to the client 

	doPost()
	--------
	 		- We must use "doPost()" method if we need to hide the data (to be sent to the server)
	 		- service() method is invoked in the background which executes the doPost() method
			- the user data is sent to the server as hidden from the URL
			- we have to exclusively mention method=post in the <form> tag of jsp file
			
			  					
					<form action = "login" method=post>
						<input type="text" 		name ="userName">
						<input type="text" 		name ="password">
						<input type="submit" 	value ="SUBMIT">
					</form>
					
			- servlet retrieves the data as  - request.getParameter("userName") inside the doPost() method
			 		  performs operation on the data
			 		  sends the final data back to the client 	
			 		  
			 		  
			 		  	
					
					