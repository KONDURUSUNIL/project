<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<table border="1" background="black" bordercolor="green">
<tr>
<th>ID</th><th>NAME</th><th>Email</th><th>LocName</th><th>LocType</th><th>Address</th><th>Gender</th><th>Delete</th><th>Update</th>
</tr>
<c:forEach items="${vendorObj}" var="ven">
<tr>
<td><c:out value="${ven.id}"/></td>
<td><c:out value="${ven.name}"/></td>
<td><c:out value="${ven.email}"/></td>
<td><c:out value="${ven.loc.locName}"/></td>
<td><c:out value="${ven.loc.locType}"/></td>
<td><c:out value="${ven.addr}"/></td>
<td><c:out value="${ven.gen}"/></td>
<td><a href='deleteVen?id=<c:out value="${ven.id}"/>'>Delete</a></td>
<td><a href='editVen?id=<c:out value="${ven.id}"/>'>Update</a></td>
<td><a href='exportToVendorSinglePdf?id=<c:out value="${ven.id}"/>'>Pdf</a></td>
</tr>
</c:forEach>
</table>
<a href="exportToVendorPdf">Genereate Pdf</a>
<a href="exportToVendorExcel">Excel</a>


</body>
</html>