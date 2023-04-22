<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div align="center">
  <h1>Employee Register Form</h1>
  <form action="<%=request.getContextPath()%>/add" method="post">
   <table>
    <tr>
     <td>User Name</td>
     <td><input type="text" name="usr_name" /></td>
    </tr>
    <tr>
     <td>Password</td>
     <td><input type="password" name="usr_pass" /></td>
    </tr>
  
    <tr>
     <td>Address</td>
     <td><input type="text" name="address" /></td>
    </tr>
   </table>
   <input type="submit" value="add" />
  </form>
 </div>
</body>
</html>