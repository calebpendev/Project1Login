<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<div align="center">Log Into Account</div>
<form name="LoginForm" action="LoginServlet" method="post" onsubmit="return validate()">
	<table align="center">
		<tr>
		<td>User Name</td>
		<td><input type="text" name="inputUserName"/></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="text" name="inputPassword"/></td>
		</tr>
		<tr>
		<td><button type="submit">Login</button></td>
		<td><button type="reset">Reset</button></td>
		</tr>
	</table>
</form>
</body>
</html>