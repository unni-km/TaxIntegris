<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.db.dbconnect" %>
    <%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
    
<!DOCTYPE html>
<!-- Website - www.codingnepalweb.com -->
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form Validation in HTML | CodingNepal</title>
  <link rel="stylesheet" type="text/css" href="css/staff.css">
    <!-- Fontawesome CDN Link For Icons -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" />
  </head>
  <body>
  <script src="js/staff.js"></script>
  <!-- here we create a data base connection and fetch the values of department and designation from tables so we can maintain the flow -->
  
  <%
  
  
  dbconnect dbcon = new dbconnect();
  
  
	
  PreparedStatement ps = dbcon.connection.prepareStatement("select * from tax_dept order by dept_code");
		
		
		
		PreparedStatement ps1=dbcon.connection.prepareStatement("select * from tax_design order by design_code");
		
  
  
  %>
    <form >
      <h2>Staff Registration</h2>
      <div class="form-group fullname">
        <label for="fullname">Name</label>
        <input type="text" name="sname" id="sname" placeholder="Enter your full name" >
      </div>
      <div class="form-group email">
        <label for="email">Department</label>
        
<!--         <input type="text" name= "desig"id="desig" placeholder="Enter your Designation"> -->
<select name="dept" id="dept">
<option>Select Department</option>

<%
ResultSet rs=ps.executeQuery();
while(rs.next()){%>

<option><%=rs.getString("dept_name") %></option>

<% 
}
rs.close();
%>

      </select>


      </div>
      <div class="form-group password">
        <label for="depart">Designation</label>
<!--         <input type="text" name="depart" id="depart" placeholder="Enter Department"> -->

            <select name="design" value="design">

<option>Select Designation</option>

<%
ResultSet rs1=ps1.executeQuery();
while(rs1.next()){%>

<option><%=rs1.getString("design_name") %></option>

<% 
}
rs1.close();
%>

      </select>

      </div>
      <div class="form-group date">
        <label for="text">Basic Salary</label>
        <input type="text" name="pay" id="pay" placeholder="Enter basic pay" >
      </div>
      
      <button class="form-group submit-btn" type="button" onclick="ins_staff('insstaff')">Add Staff</button>
      <!-- after submitting the form this request go to staff.js there we have a ajax function that will sent the request to server -->
      
    </form>

    <script src="script.js"></script>
  </body>
</html>