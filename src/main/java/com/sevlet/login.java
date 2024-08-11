package com.sevlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.service.s_login;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class login extends HttpServlet {
   
	//after submitting the form this servlet will check the method like get or post re-route the jsp pages according to that
	s_login s=new s_login();
	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    
		  
		 RequestDispatcher rd = request.getRequestDispatcher("jsp/register.jsp");
			rd.include(request, response);

	  }

	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {

  String user=request.getParameter("user");
  String password=request.getParameter("pass");
	System.out.println("userrrrrrrrrrrr"+user+"passsss"+password);
  
    if(s.chkuser(user, password)) {
    	HttpSession session=request.getSession();
	  session.setAttribute("puser", user); // after successfull login, create a session and put the user name into the session
	 request.getRequestDispatcher("jsp/home.jsp").include(request, response); //the requestdispatcher will route the request to home jsp
	  
	  
	  
  }
  else {
	  
	  request.getSession().invalidate();
	  PrintWriter p=response.getWriter();
	  response.setContentType("text/html");
	  
	  
	  p.print("sorry invalid credentials, please <a href=\"/Employee\">Login</a> again."); // if invalid credention 
	  
	  
	  
  }
  
  
 
  
  
 
		  
	  }
}
