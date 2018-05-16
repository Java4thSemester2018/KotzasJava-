<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<style>
body{
	background-color:#d9d9d9; 
	color:black; 
	font-family:sans-serif;
	background-image: url("cropbg1faded.jpg");
	text-shadow: 1px 1px 1px #808080;
	}
*{
	text-align:center;
}
table{
	border: #F0F0F0 1px solid;
	border-radius: 4px;
}
td{
	padding: 7px;
}
</style>
</head>
<body>
		<h1>Login:</h1>
		<form action="${pageContext.request.contextPath}/login" method="post"> 
			<table border="0" width="500" align="center">
				<tr><td>Name:</td>
					<td><input id="username" type="text" name="username"></td>
				</tr>
				<tr><td>Profession:</td>
					<td><select name="pro">
							<option value="Professor">Professor</option>
							<option value="Secretary">Secretary</option>
							<option value="Student">Student</option>
					</select></td>
				</tr>
			</table>
			<h6>${message}</h6>
			<input type="submit" value="login"/>
	</form>  
</body>
</html>


