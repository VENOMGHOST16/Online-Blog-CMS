package com.programs.DataFlair;
import java.sql.*;
public class UserProfile {
	
	/*
	 * This program shall retrieve all the blogs and data of the blogs from the database
	 * of a particular user in the session when he views his profile.
	 * */
	ResultSet rs=null;
	Connection cn=null;
	public ResultSet retrieve(String name)
	{
		try {
			cn=new GetConnection().doConnect();
			String s="select b1.blog_id,b1.name,b1.title,b1.vid_link,b1.img_link,b2.blog,b2.caption from blog1 b1,blog2 b2 where b1.name=? and b1.blog_id=b2.blog_id;";
			//THIS sql command joins the blog1 and blog2 table to retrieve all the data and checks 
			//whether the name of the customer is matching or not 
			
			PreparedStatement ps=cn.prepareStatement(s);
			ps.setString(1, name);
			rs=ps.executeQuery();
			
			
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rs;
	}
}
