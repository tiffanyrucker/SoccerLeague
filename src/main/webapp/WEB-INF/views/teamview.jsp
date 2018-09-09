<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TEAM MEMBERS</title>
</head>
<body>
	<div class="container">
		<input type="hidden" name="teamid" value="${team.teamid}">
	</div>
	<div class="container">
		<h3>Team Name</h3>
		${team.teamname}
	</div>

	<div class="container">
		<h3>Current Members</h3>
		<c:forEach var="member" items="${members}">
			${member}
			<br>
		</c:forEach>
	</div>
</body>
</html>