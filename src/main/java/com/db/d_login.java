package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class d_login {

	
	 
	 

	 
	 
		public String username;
		public String password;
		
		public String staff,dept,desig,basic,puser;
	
	
	
	 
		public boolean checkuser()
		{
			
			
			boolean stat=false;
			PreparedStatement ps=null;
			dbconnect dbcon = new dbconnect();
			try {
				
				ps = dbcon.connection.prepareStatement("select * from tax_users where username=? and password=?");
				
				
				ps.setString(1, this.username);
				ps.setString(2, this.password);
				
				ResultSet rs=ps.executeQuery();
				
			while(rs.next()) {
					
					
					stat=true;
				}
				
	                ps.close();
	                rs.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stat;
			
			
			
			
		}
		
		
		
		public boolean insstaff()
		{
			
			int c=0;
			dbconnect dbcon = new dbconnect();
			PreparedStatement ps=null;
			try {
				ps = dbcon.connection.prepareStatement("insert into tax_staff(name, designation, department, basic_salary, parentuser) values(?,?,?,?,?)");
				
				
				ps.setString(1, this.staff);
				ps.setString(2, this.desig);
				ps.setString(3, this.dept);
				ps.setDouble(4, Double.parseDouble(basic));
				ps.setString(5, this.puser);
				
				 c=ps.executeUpdate();
				
				
	             ps.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (c!=0)?true:false;
		}
		
		public boolean insertuser()
		{
			
			int c=0;
			dbconnect dbcon = new dbconnect();
			PreparedStatement ps=null;
			try {
				ps = dbcon.connection.prepareStatement("insert into tax_users values(?,?)");
				
				
				ps.setString(1, this.username);
				ps.setString(2, this.password);
				
				
				 c=ps.executeUpdate();
				
				
	             ps.close();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (c!=0)?true:false;
		}
		
		
		
		
		
		
		public boolean updatestaff(String id)
		{
			dbconnect dbcon = new dbconnect();
			
			
			int c=0;
			
			PreparedStatement ps = null;
			try {
				ps = dbcon.connection.prepareStatement("update tax_staff set  designation=? , department=? , basic_salary=?  where id =? ");
				
				
				ps.setString(1, this.desig);
				ps.setString(2, this.dept);
				ps.setDouble(3, Double.parseDouble(this.basic));
				ps.setInt(4,Integer.parseInt(id));
				
				 c=ps.executeUpdate();
				 ps.close();
				
	               
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (c!=0)?true:false;
			
			
		}
			
		public boolean deletestaff(String id)
		{
			dbconnect dbcon = new dbconnect();
			
			
			int c=0;
			
			PreparedStatement ps = null;
			try {
				ps = dbcon.connection.prepareStatement("delete from tax_staff   where id =? ");
				
				
				
				ps.setInt(1,Integer.parseInt(id));
				
				 c=ps.executeUpdate();
				 ps.close();
				
	               
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (c!=0)?true:false;
			
			
		}
		
		
			
			public boolean chk() {
				
				dbconnect dbcon = new dbconnect();
				boolean stat=false;
				PreparedStatement ps;
				try {
					ps = dbcon.connection.prepareStatement("select name from tax_staff where name=?");
					
					
					ps.setString(1, this.staff);
					
					
					ResultSet rs=ps.executeQuery();
					
				while(rs.next()) {
						
						
						stat=true;
					}
					
		                   ps.close();
	                    	rs.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return stat;
				
				
				
				
				
			}
			
public boolean chkreg() {
				
				dbconnect dbcon = new dbconnect();
				boolean stat=false;
				PreparedStatement ps;
				try {
					ps = dbcon.connection.prepareStatement("select name from tax_users where username=?");
					
					
					ps.setString(1, this.staff);
					
					
					ResultSet rs=ps.executeQuery();
					
				while(rs.next()) {
						
						
						stat=true;
					}
					
		                   ps.close();
	                    	rs.close();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return stat;
				
				
				
				
				
			}
			
			
		
		
		
		
	
	
}
