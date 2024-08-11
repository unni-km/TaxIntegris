package com.service;
import com.db.d_login;
public class s_staff {
	
	
	
	

	
	
	
	
	
	public boolean insstaff(String staff,String dept,String des,String basicpay,String puser)
	{
		d_login dlogin=new d_login();
		
		dlogin.staff=staff;
		dlogin.dept=dept;
		dlogin.desig=des;
		dlogin.basic=basicpay;
		dlogin.puser=puser;
		boolean stat=false;
		if(dlogin.insstaff()) {
			
			stat=true;
			
		}
		
		return stat;
		
	}
	public boolean insuser(String name,String pass)
	{
		d_login dlogin=new d_login();
		
		dlogin.username=name;
		dlogin.password=pass;
		
		boolean stat=false;
		if(dlogin.insertuser()) {
			
			stat=true;
			
		}
		
		return stat;
		
	}
	
	
	
	
	
	public boolean updatestaff(String id,String dept,String des,String salary)
	{
		d_login dlogin=new d_login();
		
		dlogin.dept=dept;
		dlogin.desig=des;
		dlogin.basic=salary;

		boolean stat=false;
		if(dlogin.updatestaff(id))   stat=true;
			
		
		
		return stat;
		
	}
	
	public boolean delete(String id)
	{
		d_login dlogin=new d_login();
		
	

		boolean stat=false;
		if(dlogin.deletestaff(id))   stat=true;
			
		
		
		return stat;
		
	}
	
	
	
	public boolean valuser(String user) {
		d_login dlogin=new d_login();
		
		dlogin.staff=user;
		
		boolean  stat=false;
		
		if(dlogin.chk())
		{
			stat=true;
		}
		
		return stat;
		
	}
	public boolean reguser(String user) {
		d_login dlogin=new d_login();
		
		dlogin.staff=user;
		
		boolean  stat=false;
		
		if(dlogin.chkreg())
		{
			stat=true;
		}
		
		return stat;
		
	}
	public boolean isdigit(String pay) {
		
		boolean stat=true;
		for(char c :pay.toCharArray())
		{
			if(!Character.isDigit(c)) {
				stat=false;
			}
			
		}
		
		return stat;
	}
	
	
	
	
	
	
	
	
	
	
	

}
