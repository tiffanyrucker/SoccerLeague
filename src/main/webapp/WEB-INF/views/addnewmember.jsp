<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member</title>
</head>
<body>
	<div class="container">
		<h2>Add a New Member</h2>
		<form action="addmember">
			Name<br><input type="text" name="membername"></input><br>
			Role<br><input type="text" name="memberrole"></input><br>
			Team ID<br><input type="number" name="teamid"></input><br>
			<input type="submit" value="Submit"></input><br>
		</form>
	</div>
</body>
</html>
