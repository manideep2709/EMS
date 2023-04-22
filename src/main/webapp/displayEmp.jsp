<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees List</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/add" method="post">

		<input type="submit" value="add">
	</form>

	<table>
		<tr>
			<th>Employee ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>Address</th>
		</tr>
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${employee.emp_id}</td>
				<td>${employee.usr_name}</td>
				<td>${employee.usr_pass}</td>
				<td>${employee.address}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>