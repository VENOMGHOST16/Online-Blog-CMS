package com.programs.DataFlair;
import java.sql.*;

public class UpdateRent {

	Connection cn=null;
	PreparedStatement ps;
	public boolean update(int rent_id)
	{
		try
		{
			String s="update rent_history set paid=1 where id=?";
			ps=cn.prepareStatement(s);
			ps.setInt(1, rent_id);
			ps.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
		
	}
}
