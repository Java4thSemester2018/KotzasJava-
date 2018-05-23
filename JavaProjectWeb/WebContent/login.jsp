<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="headertop">
    <h3><strong>LOGIN</strong></h3>
    </div>
    <br>
    <div class="loginbox">
		<form action="${pageContext.request.contextPath}/login" method="post"> 
			<table border="0" width="500" align="center">
				<tr><td>Name:</td>
					<td><input required id="username" type="text" name="username"></td>
				</tr>
			</table>
            <input type="submit" value="login"/>
            <br></br>
        </form>  
    </div>
    <h6>${message}</h6>
</body>
</html>




