<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.db.dbconnect" %>
    <%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Staff</title>


<link rel="stylesheet" type="text/css" href="css/view.css">
</head>


<body>
<script src="js/staff.js"></script>
<h1>Staff Details</h1>


<!-- here we can fetch the staffs data according to users -->
<%



String puser=(String)session.getAttribute("puser");
System.out.println("ppppppppppppuserrrrrrrrrrrr  "+puser);
dbconnect dbcon = new dbconnect();



PreparedStatement ps = dbcon.connection.prepareStatement("select * from tax_staff where parentuser=? order by id");

   ps.setString(1, puser);
   System.out.println("staff name is "+ps);

%>

<table id="staff">
  <tr>
    <th >id</th>
    <th>name</th>
    <th>department</th>
    <th>designation</th>
    <th>Basic salary</th>
     <th>update</th>
      <th>delete</th>
  </tr>
  
  <%
  ResultSet rs=ps.executeQuery();
  
  while(rs.next())
  {
  
  %>
  <tr>
    <td><%=rs.getString("id") %></td>
    <td><%=rs.getString("name") %></td>
    <td><%=rs.getString("department") %></td>
     <td><%=rs.getString("designation") %></td>
      <td><%=rs.getString("basic_salary") %></td>
      <td align="center">   <button type="button" onclick="stupdate(this,<%=rs.getString("id") %>)" > Update</button>  </td>
      <td align="center">   <button type="button" name='del' id='del' onclick="stdelete(<%=rs.getString("id") %>)" >  Delete</button>  </td>
      </tr>
       <%
  } %>
  


</table>


<div class="form-popup" id="myForm">
  <form class="form-container">
    <h1>Update Details</h1>

    <label for="dep"><b>Department</b></label>
    <input type="text" placeholder="Enter Department" name="dep" id="dep" required>

    <label for="des"><b>Designation</b></label>
    <input type="text" placeholder="Enter Designation" name="des" id="des" required>
    
    <label for="sal"><b>Basic salary</b></label>
    <input type="text" placeholder="Enter Salary" name="sal" id="sal" required>


 <input type="hidden" placeholder="Enter Salary" name="id" id="id" value="">
    <button type="button" class="btn" onclick="updateDetails(this)">Update</button>
    <button type="button" class="btn cancel" onclick="closeForm()">Cancel</button>
  </form>
</div>


</body>
</html>


