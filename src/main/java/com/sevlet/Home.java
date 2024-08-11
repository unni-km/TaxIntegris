package com.sevlet;

import java.io.IOException;

import com.service.s_staff;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home")
public class Home extends HttpServlet {
	
	 @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	    
		

	  }

	  @Override
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		  s_staff s=new s_staff();
		 String task=request.getParameter("task");
		 
		 System.err.println("Task:"+task);
// in home page we will check the tasks and performs actions according to that
		 if(task.equals("addstaff"))
		 {System.err.println("insidetask"+task);
		 
			 request.getRequestDispatcher("jsp/addstaff.jsp").include(request, response);
			 
			 
		 }
		 
		 
		// when inserting a new staff we will fetch the user from session and insert along with staff
		 //details so we can filter the staff according to users
		 else if(task.equals("insstaff")){
			 HttpSession session=request.getSession(); 
			 String sname=request.getParameter("sname");
			 String dept=request.getParameter("dept");
			 String design=request.getParameter("design");
			 String pay=request.getParameter("pay");
			 String pname=(String) session.getAttribute("puser");
			 System.err.println("staff name is "+sname);
			 System.err.println("staff dep is "+dept);
			 System.err.println("staff des is "+design);
			 System.err.println("staff basi is "+pay);
			 System.err.println("staff pna is "+pname);
			 
			 if(s.isdigit(pay)) {
			 
			 if(!s.valuser(sname)) {
			 if(!s.insstaff(sname, dept, design, pay, pname)) {
				 
				 response.getWriter().write("Insertion failed");
				 
			 }
			 else {
				 
				 
				 response.getWriter().write("Inserted succesfully");
				 
			 }
			 }else {
				 
				 
				 response.getWriter().write("username already exists please select other one");
				 
			 }
			 
			 }else {
				 
				 response.getWriter().write("basicpay must be a number");
			 }
		 }
			 
		 else if(task.equals("updatestaff")){
			 
			 String department=request.getParameter("dep"),
			        design=request.getParameter("des"),
			        salary=request.getParameter("sal"),
			        id=request.getParameter("id");
			 
			 System.err.println(department);
			 System.err.println(design);
			 System.err.println(salary);
			 System.err.println(id);
			 if(s.isdigit(salary)) {
				 
			
                if(!s.updatestaff(id, department, design, salary)) {
				 
				 response.getWriter().write("Updation failed");
				 
                }
			 else {
				 
				 
				 response.getWriter().write("Updated successfully");
				 
			 }
                }
                else {
   				 
   				 response.getWriter().write("basicpay must be a number");
   			 }
			 
			 }
		 
			 
			 
		 
		 
		 else if(task.equals("deletestaff")){
			 
			 String id=request.getParameter("id");
			        
			 
			
			 System.err.println("isssssssssssssss"+id);
			 
                if(!s.delete(id)) {
				 
				 response.getWriter().write("deletion failed");
				 
			 }
			 else {
				 
				 
				 response.getWriter().write("deleted successfully");
				 
			 }
			 
			 
			        
			 
		 }

			 
			 
	
		 
		 if(task.equals("viewstaff"))
		 {System.err.println("insidetask"+task);
		 
			 request.getRequestDispatcher("jsp/viewstaff.jsp").include(request, response);
			 
			 
		 }
		 if(task.equals("calctax"))
		 {System.err.println("insidetask"+task);
		 
			 request.getRequestDispatcher("jsp/taxcalculation.jsp").include(request, response);
			 
			 
		 }
		 //by logout we will invalidate the session then reroute to login page
		 if(task.equals("logout"))
		 {System.err.println("insidetask"+task);
		 HttpSession session=request.getSession();
		 session.invalidate();
			 request.getRequestDispatcher("index.jsp").include(request, response);
			 
			 
		 }
		 
		 else if(task.equals("signup")){
		
			 String uname=request.getParameter("user");
			 String pass=request.getParameter("pass");
			 System.err.println("staff name is "+uname);
			 System.err.println("staff dep is "+pass);
		
			 
			 
			 if(!s.valuser(uname)) {
			 if(!s.insuser(uname, pass)) {
				 
				 response.getWriter().write("Insertion failed");
				 
			 }
			 else {
				 
				 
				 response.getWriter().write("Inserted succesfully please login");
				 
			 }
			 }else {
				 
				 
				 response.getWriter().write("username already exists please select other one");
				 
			 }
		 }
		 if(task.equals("loginpage"))
		 {System.err.println("insidetask"+task);
			 request.getRequestDispatcher("index.jsp").include(request, response);
			 
			 
		 }
		 
		 
		 
//		 System.err.println("My name is "+request.getParameter("name"));
//		 System.err.println("My age is "+request.getParameter("age"));
//		 System.err.println("My Date of Birth is "+request.getParameter("dob"));
		//response.setContentType("appliaction/json");
		// response.getWriter().write("Inside home handle page of task "+task);
		  
	  }


}
