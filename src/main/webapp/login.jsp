<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<div align="center">
		<h1>User Login</h1>
		<table></table>
		<form action="<%=request.getContextPath()%>/login" method="post">
			<table>
				<tr>
					<td>Enter Username:</td>
					<td><input type="text" name="usr_name"></td>
				</tr>
				<tr>
					<td>Enter Password:</td>
					<td><input type="text" name="usr_pass"></td>
				</tr>
				<tr>
					<td><input type="submit" value="login">
					<td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>