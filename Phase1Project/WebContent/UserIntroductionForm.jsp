<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Introduction Setup</title>
</head>
<body>
	<h1 align="center">Please Fill out form to Introduce Yourself</h1>
	<div align="center">You Successfully logged in please fill out form</div>
	<form name="IntroductionForm" action="IntroInputServlet" method="post" >
	<table align="center">
		<tr>
			<td>Short Introduction</td>
			<td><input type="text" style="width:200px; height:200px word-wrap:normal" name="introduction" placeHolder="Please introduce yourself" /> </td>
		</tr>
		<tr>
			<td>Favorite Hobby</td>
			<td><input type="text" name="hobby" width="200px" placeholder="What is your favorite hobby?" /> </td>
		</tr>
		<tr>
			<td><input type="submit" name="submitIntroduction" value="Save"/></td>
			<td><input type="reset" name="reset" value="Reset"/></td>
		</tr>
		<tr>
		  <td><%=(request.getAttribute("errMessage") == null) ? ""
         : request.getAttribute("errMessage")%></td>
         </tr>
	</table>
	</form>
</body>
</html>