<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Member</title>
</head>
<body>
<h2> Update a Member</h2>	
<form action="memberedit">
		<input type="hidden" name="memberid" value="${member.memberid}">
		<table>
			<tr>
				<td>ID</td>
				<td>${member.memberid}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="membername" value="${member.membername}"></input></td>
			</tr>
			<tr>
				<td>Team</td>
				<td><input type="number" name="teamid" value="${member.team.teamid}"></input></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input type="text" name="memberrole" value="${member.memberrole}"></input></td>
			</tr>
		</table>
		<input id="submitBtn" type="submit" value="Update"></input>
	</form>
</body>
</html>