<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome   ${username}</h2> 
 
 
 
 <form action = "${pageContext.request.contextPath}/SecretaryServlet" method = "post">
	<p>Choose an option:</p>
		<input type="radio" name="option" id="option" value="Classes" >Show all classes available<br><br>
		<input type="radio" name="option" id="option" value="Professors" >Show the professor for each class<br><br>
		<input type="radio" name="option" id="option" value="Assign" >Assign a professor to a class<br><br>
		<input type="submit" value="GO">
 </form>
${output}
</body>
</html>