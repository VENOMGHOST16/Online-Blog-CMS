
<jsp:useBean id="blog" class="com.programs.DataFlair.Blogging" scope="session"></jsp:useBean>
<jsp:setProperty  name="blog" property="*"/>

<%	
	String img_link="",vid_link="";
	img_link=request.getParameter("imglink");
	vid_link=request.getParameter("vidlink");
	
	//blog_insert() returns true when it recieves successful submission of blog.
 	if(blog.blog_insert((String)session.getAttribute("name"),img_link,vid_link))
	{
 		//if there is succesfull blog upload then the user will be redirected to its own profile page
 		//where he can view all his blogs.
 		response.sendRedirect("user_profile.jsp");
	}
	else
	{
		//in case of some error occuring.
		session.setAttribute("error", "Some error has occured....pls try again later!!!");
		response.sendRedirect("Error.jsp");
	}
%>