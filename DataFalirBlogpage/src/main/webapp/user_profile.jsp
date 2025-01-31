<%@page import="com.programs.DataFlair.UserProfile"%>
<%@ page import="java.sql.*"%>
<% 
	ResultSet rs=new UserProfile().retrieve((String)session.getAttribute("name"));
int count=1;



	/*
	The following program will display all the blogs posted by the current user along with count.
	
	*/
%>
<html>
<head>
    <link rel="stylesheet" href="blog.css">
	<title>Profile Page</title>
	<style>
		body {
			background-color: #f7f7f7;
			color: #333;
			font-family: Arial, sans-serif;
		}
		.container {
            position: relative;
            top:100px;
			max-width: 800px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 10px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
		}
		h1 {
			color: #333;
			font-size: 36px;
			margin-bottom: 20px;
            margin-top: 20px;
		}
		.post {
			margin-bottom: 20px;
			padding: 20px;
			background-color: #fff;
			border-radius: 5px;
			box-shadow: 0 0 5px rgba(0, 0, 0, 0.1);
		}
		.post h2 {
			color: #333;
			font-size: 24px;
			margin-bottom: 10px;
		}
		.post p {
			font-size: 16px;
			line-height: 1.5;
			margin-bottom: 0;
		}
		.post img {
			max-width: 100%;
			margin-bottom: 10px;
		}
		.post a {
			display: inline-block;
			padding: 5px 10px;
			background-color: #333;
			color: #fff;
			font-size: 14px;
			text-align: center;
			border-radius: 5px;
			text-decoration: none;
			margin-right: 10px;
			margin-bottom: 10px;
		}
	</style>
</head>
<body>
    <div class="top">
        <nav class="navbar">
            <ul>
                <li><a href="index.html">HOME</a></li>
                <li><a href="All_blogs.jsp">Community Blogs</a></li>
                <li><a href="blogging.html">Blogging</a></li>
                <li><a href="user_profile.jsp">Profile</a></li>
            </ul>
        </nav>
        
        <div class="logo">
            <img src="./images/projectgurukul.png" width="70px">
        </div>
    </div>
    
	<div class="container">
	
	<% if(rs.next()) //Checking whether there are blogs in the rs or not
	{
		
		%>
		<h1>@<%=rs.getString(2)%></h1>
		
		<%
		
		do
		{
	%>
	
	
		<div class="post">
			<h2><%=count%>)<%=rs.getString(3)%></h2>
			<% 
				if(rs.getString(5)!=null)
				{
			%>
			<img src="<%=rs.getString(5)%>" alt="Image">
			<% }
			%>
			<% if(rs.getString(4)!=null)%>
			<%=rs.getString(4)%>
			
			<p><%=rs.getString(6)%></p>
			<div class="caption">
				<h2>Caption</h2>
				<p>
					<%=rs.getString(7)%>
				</p>
			</div>
		</div>
	
	
	<%count++;
		}while(rs.next());
	}
	else //If there are no blogs posted by the current user
	{
	%>
		NO BLOG POSTED,POST SOME BLOGS
	<% }%>
		
	</div>
	</body>
	</html>