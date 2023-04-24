<%@page import="com.kiran.model.Emploee"%>
<%@page import="java.util.List"%>
<%@page import="com.kiran.emploeeDao.EmploeeDaoFactory"%>
<%@page import="com.kiran.emploeeDao.EmploeeDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head> 
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="../css/table.css" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%!EmploeeDao dao;
%>
<% dao=EmploeeDaoFactory.getInstance(); 
List<Emploee> list=dao.readAllEmploee();
application.setAttribute("list", list);
%>
<h1>Emploee DATA TABLE</h1>
<table border="1">
<tr>
<td>Id</td><td>Name</td><td>Salary</td><td>Delete</td><td>Update</td>
</tr>
<c:forEach var="emp" items="${applicationScope.list }">
<tr>
<td><c:out value="${emp.eNo }"></c:out></td>
<td><c:out value="${emp.eName }"></c:out></td>
<td><c:out value="${emp.eSalary }"></c:out></td>
<td><a href="${pageContext.request.contextPath}/DeleteEmploee?id=${emp.eNo}">DELETE</a></td>
<td><a href="${pageContext.request.contextPath}/UpdateRecordFetch?id=${emp.eNo}">UPDATE</a></td>
</tr>

</c:forEach>
<tr>
<td><a href='../Welcome.html'>Register</a></td></tr>
</table>
</body>
</html>