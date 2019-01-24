<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="ActionController">
	
	<table>
		
		<tr><td>First Name</td></tr>
		<tr><td><input type="text" name="fname" placeholder="First Name"></td></tr>
		
		
		<tr><td>Last Name</td></tr>
		<tr><td><input type="text" name="lname" placeholder="Last Name"></td></tr>
		
		<tr><td>Email</td></tr>
		<tr><td><input type="text" name="email" placeholder="Email"></td></tr>
		
		<tr><td>Contact</td></tr>
		<tr><td><input type="text" name="contact" placeholder="Contact  No."></td></tr>
	
		<tr><td><input type="submit" name="action" value="insert"></td></tr>
	</table>
	

</form>
</body>
</html>