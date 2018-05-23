<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = "java.io.*,java.util.*" %>
   
<% 
	if (session.getAttribute("username") == null){
			System.out.println("ERROR");
		    response.sendRedirect("login.jsp");
    }else{
    	System.out.println("GOOD");
    }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome ${username}</title>
</head>
<body>
<div class="headertop">
<h3>Welcome ${username}</h3> 


</div>
<br>
<div class="loginbox">
<form action = "${pageContext.request.contextPath}/SecretaryServlet" method = "post">
                	 		<p>Professor AFM</p><input required name="professorafm" />
                	 		<p>Course ID</p><input required name="courseid" />
                	 		<input type="hidden" name="assign" value="true" />
                	 		<input type="submit"/>
</form>
</div>

</body>
</html>