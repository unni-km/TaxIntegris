package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class dbconnect {
	private final String url = "jdbc:postgresql://localhost:5432/tax";
	private final String user= "postgres";
	private final String password ="postgres";

	public static Connection connection;
	public dbconnect() {

	try{
		
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection(url, user, password);
	 if(connection != null) 
	 { 
		 System.out.println("Connected to PostgreSQL server successfully!");
	 }

	
	else 
	{
		System.out.println("Failed to connect PostgreSQL server");
	}
	}catch( ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {

	e.printStackTrace();
	}
	}




}
