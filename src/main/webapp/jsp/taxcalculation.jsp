<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="com.db.dbconnect" %>
    <%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css" href="css/view.css">
</head>


<body>
<script src="js/staff.js"></script>
<h1>Staff Tax</h1>


<!-- using this query will claculate  -->
<%



String puser=(String)session.getAttribute("puser");
System.out.println("ppppppppppppuserrrrrrrrrrrr  "+puser);
dbconnect dbcon = new dbconnect();


PreparedStatement ps = dbcon.connection.prepareStatement("with salary as(select id, name ,designation , department ,basic_salary , basic_salary*0.2 as HRA ,basic_salary*0.1 as DA ,basic_salary*0.05 as TA from tax_staff where parentuser=?) ,"
		+"gross as (select *, basic_salary+hra+da+ta as gross_salary  from salary)select * , case when  (gross_salary >=250001  and  gross_salary<=500000) then gross_salary-0.05*gross_salary when  (gross_salary >=500001"  
		+"and gross_salary<=1000000) then gross_salary- 0.2*gross_salary when  gross_salary >1000000  then gross_salary-0.3*gross_salary else gross_salary  end as net_salary  from gross order by id");

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
     <th>HRA</th>
     <th>DA</th>
     <th>TA</th>
     <th>Gross Salary </th>
     <th>Net Salary </th>
     
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
    <td><%=rs.getDouble("basic_salary") %></td>
    <td><%=rs.getDouble("HRA") %></td>
    <td><%=rs.getDouble("DA") %></td>
    <td><%=rs.getDouble("TA") %></td>
    <td><%=rs.getDouble("gross_salary") %></td>
    <td><%=rs.getDouble("net_salary") %></td>
    
      
      </tr>
       <%
  } %>
  


</table>