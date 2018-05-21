<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome  </h2><h2 value=name> ${username}</h2> 
 
<form action = "${pageContext.request.contextPath}/SecretaryServlet" method = "post">
                	 		<p>Professor AFM</p><input required name="professorafm" />
                	 		<p>Course ID</p><input required name="courseid" />
                	 		<input type="hidden" name="assign" value="true" />
                	 		<input type="submit"/>
</form>
${queryresult}
</body>
</html>