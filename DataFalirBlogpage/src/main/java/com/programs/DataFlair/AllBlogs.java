package com.programs.DataFlair;
import java.sql.*;
public class AllBlogs {
	
	/*
	 * This program shall retrieve all the blogs from the database of all the users.
	 * */
	
	
	Connection cn=null;
	ResultSet rs=null;
	
	public ResultSet retrieve_all()
	{
		try
		{

			cn=new GetConnection().doConnect();
			String s="select b1.blog_id,b1.name,b1.title,b1.vid_link,b1.img_link,b2.blog,b2.caption from blog1 b1,blog2 b2 where b1.blog_id=b2.blog_id;";
			
			//The following statement joins two tables blog1 and blog2 to retrieve all the data.
			PreparedStatement ps=cn.prepareStatement(s);
			
			rs=ps.executeQuery();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rs;
	}
}
