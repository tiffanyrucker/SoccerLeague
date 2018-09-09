<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Team</title>
</head>
<body>
<h2> Update a Team</h2>	
<form action="teamedit">
		<input type="hidden" name="teamid" value="${team.teamid}">
		<table>
			<tr>
				<td>Team ID</td>
				<td>${team.teamid}</td>
			</tr>
			<tr>
				<td>Team Name</td>
				<td><input type="text" name="teamname" value="${team.teamname}"></input></td>
			</tr>
		</table>
		<input id="submitBtn" type="submit" value="Update"></input>
	</form>
</body>
</html>