<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Team</title>
</head>
<body>
	<div class="container">
		<h2>Add a New Team</h2>
		<form action="addteam">
			Team Name<br><input type="text" name="teamname"></input><br>
			<input type="submit" value="Submit"></input><br>
		</form>
	</div>
</body>
</html>