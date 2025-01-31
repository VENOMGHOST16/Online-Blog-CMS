<jsp:useBean id="Regid" class="com.programs.DataFlair.UserRegister" scope="session"></jsp:useBean>
<jsp:setProperty  name="Regid" property="*"/>
 <%
 	//register() function returns true after succesful registration
 	String s=request.getParameter("full_name");
 	if(Regid.register())
 	{
 		session.setAttribute("name",s);
 		response.sendRedirect("login_page.html"); //After successful registration user will be redirected to login page
 	}
 		
 	else
 	{
 		//in case of failure in registration
 		session.setAttribute("error","Try different username or try again later");
 		response.sendRedirect("Error.jsp");
 	}
 %>
