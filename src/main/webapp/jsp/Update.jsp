<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="UpdateEmploee" method="get">
<input type="text" name="id" value="${requestScope.emploee.eNo }"><br>
<input type="text" name="name" value="${requestScope.emploee.eName }"><br>
<input type="text" name="salary" value="${requestScope.emploee.eSalary }"><br>
<input type="submit" value="update"><br>
</form>
</body>
</html>