<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import = "java.io.*,java.util.*" %>
   
<% 
try{
if (!session.getAttribute("role").equals("professor")){
	response.sendRedirect("login");
}
}
catch(Exception AE){
	response.sendRedirect("login");
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome ${name} ${surname}</title>
</head>
<body>
<div class="headertop">
<h3>Welcome ${name} ${surname}</h3> 


</div>
<br>
<div class="loginbox">
<form action = "${pageContext.request.contextPath}/ProfessorServlet" method = "post">
							<p>Professor ID</p><input required name="professorID" />
                	 		<p>Course ID</p><input required name="courseID" />
                	 		<input type="hidden" name="GradePerLes" value="true" />
             	 			<input type="hidden" name="SetGrade" value="false" />
                	 		<input type="submit"/>
</form>
</div>

</body>
</html>