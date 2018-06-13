<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="headertop">
    <h3><strong>REGISTER</strong></h3>
    </div>
    <br>
    <div class="loginbox">
		<form action="${pageContext.request.contextPath}/register" method="post"> 
			<table border="0" width="500" align="center">
				<tr><td>Username:</td>
					<td><input required id="username" type="text" name="username"></td>
				</tr>
					<tr><td>Password:</td>
					<td><input required id="password" type="password" name="password"></td>
				</tr><tr><td>Name:</td>
					<td><input required id="name" type="text" name="username"></td>
				</tr><tr><td>Surname:</td>
					<td><input required id="surname" type="text" name="username"></td>
				</tr><tr><td>Department:</td>
					<td><select required id="department" name="department">
						<optgroup label="Πληροφορικής και Επικοινωνιών">
							<option value="CS">Πληροφορικής</option>
							<option value="DS">Ψηφιακά συστήματα</option>
						</optgroup>
						<optgroup label="Χρηματοοικονομικής και στατιστικής">
							<option value="STAT">Στατιστικής</option>
							<option value="XRI">Χρηματοοικονομικής</option>
						</optgroup>
						<optgroup label="Ναυτιλίας και Βιομηχανίας">
							<option value="BIO">Βιομηχανική</option>
							<option value="NAUT">Ναυτιλιακά</option>
						</optgroup>
						<optgroup label="Οικονομικών, Επιχειρηματικών, και Διεθνών">
							<option value="DIETH">Διεθνών και Ευρωπαϊκών</option>
							<option value="OIKON">Οικονομικών Επιστημών</option>
							<option value="ODE">Ο.Δ.Ε.</option>
						</optgroup>
					</select></td>
				</tr><tr><td>User Role:</td>
					<td><select required id="role" name="role">
						<option value="secretary">Γραμματέας</option>
						<option value="professor">Καθηγητής</option>
						<option value="student">Μαθητής</option>
						</td>
			</table>
            <input type="submit" value="register"/>
            <br></br>
        </form>  
    </div>
    <h6>${message}</h6>
</body>
</html>
