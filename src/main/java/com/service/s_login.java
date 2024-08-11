package com.service;

import com.db.d_login;

public class s_login {
	
	
	
	
	
 d_login d=new d_login();
	
	
	
	//this method will check idf the user already exists or not so we can make unique usernames
	
	public boolean chkuser(String user,String pass)
	{
		
		System.out.println("userrrrrrrrrrrr"+user+"passsss"+pass);
		boolean stat=true;
		d.username=user;
		d.password=pass;
		
		
		if(!d.checkuser())
		{
			stat=false;
		}
		
		return stat;
		
		
		
	}
		
		
		
		
	
	
	
	

}
