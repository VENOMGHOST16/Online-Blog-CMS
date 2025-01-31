package com.programs.DataFlair;
import java.sql.*;

public class Blogging {
	
	/*
	 * This class is used to save data of the blogs into the database whenever the user
	 * wants to create a new blog.
	 * */
	
	
	
	/*
	 * There are two tables that are created because there is large data and storing in one table is not feasible.
	 * */
	String title,blog,caption;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}
	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	public boolean blog_insert(String name,String img_link,String vid_link)
	{
		try
		{
			Connection cn=new GetConnection().doConnect();
			String s="insert into blog1(name,title,vid_link,img_link) values(?,?,?,?)";
			
			
			PreparedStatement ps=cn.prepareStatement(s);
			ps.setString(1, name);
			ps.setString(2, title);
			ps.setString(3, vid_link);
			ps.setString(4, img_link);
			ps.executeUpdate();
			//Inserting values in first table.
			
			s="Insert into blog2 select blog_id,name,?,? from blog1 where name=? order by blog_id desc LIMIT 1";
		/*
		 * This particular command will insert the values into the second table which is blog2
		 * 
		 * The logic applied is this that if two users enter the blog details at same time,so to not cause
		 * ambiguity and confusion we are inserting the blog id that has already been created for the first
		 * user and is automatically incremented. 
		 * */	
			ps=cn.prepareStatement(s);
			ps.setString(1, blog);
			ps.setString(2, caption);
			ps.setString(3, name);
			ps.executeUpdate();
			
			//ON successful blog upload.
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	
}
