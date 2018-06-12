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
 <form action = "${pageContext.request.contextPath}/ProfessorServlet"  method = "post">
	<p>Choose an option:</p>
		<input type="radio" name="option" id="option" value="provoli" >Show all grades per lesson<br><br>
		<input type="radio" name="option" id="option" value="setgrade" >Set Grade <br><br>
		<input type="hidden" name="SetGrade" value="false" />
		<input type="hidden" name="GradePerLes" value="false" />
		<input type="submit" value="GO">
 </form>
 <form action = "${pageContext.request.contextPath}/logout"  method = "post">
	<input type="submit" value="LOGOUT">
</form>
 </div>
${output}

</body>
</html>