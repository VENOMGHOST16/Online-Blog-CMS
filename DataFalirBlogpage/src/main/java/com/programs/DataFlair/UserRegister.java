package com.programs.DataFlair;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserRegister {
	String username;
	String password;
	String full_name;
	
	
	/*
	 * This program shall help in registering the new student into the table student_login
	 * so that he can take books from library
	 * */
	public String getUsername() {
		return username;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean register()
	{
boolean ch=false;
		
		try
		{
			GetConnection ob=new GetConnection();
			Connection cn=ob.doConnect();
			
			//The process will enter the details for registering
			String qry="insert into user_login values(?,?,?)";
			PreparedStatement ps=cn.prepareStatement(qry);
			ps.setString(1,full_name);
			ps.setString(2, username);
			ps.setString(3,password);
			ps.executeUpdate();
			
			//on successful registration
			return true;
		}
		catch(Exception e)
		{
			//An exception can occur if the username is duplicate in a table which is not possible 
			//because the username field is made primary key
			e.printStackTrace();
		}
		
		return ch;
	}
}
