<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<table border="1" background="black" bordercolor="blue">
<tr>
<th>ID</th><th>NAME</th><th>TYPE</th><th>SuperVisor Name</th><th>Adviser Name</th><th>State</th><th>Country</th><th>Pin Code</th><th>Generate Pdf</th><th>DELETE</th><th>UPDATE</th>
</tr>
<c:forEach items="${listObj}" var="loc">
<tr>
<td><c:out value="${loc.locId}"/></td>
<td><c:out value="${loc.locName}"/></td>
<td><c:out value="${loc.locType}"/></td>
<td><c:out value="${loc.locSup}"/></td>
<td><c:out value="${loc.locAdv}"/></td>
<td><c:out value="${loc.locSta}"/></td>
<td><c:out value="${loc.locCou}"/></td>
<td><c:out value="${loc.locPin}"/></td>
<td><a href='singleExport?locId=<c:out value="${loc.locId}"/>'>Generate Pdf</a></td>
<td><a href='deleteLoc?locId=<c:out value="${loc.locId}"/>'>DELETE</a></td>
<td><a href='editLoc?locId=<c:out value="${loc.locId}"/>'>UPDATE</a></td>
</tr>
</c:forEach>
</table>
<a href="exportToPdf">Generate Pdf</a>
<a href="exportToExcel">Excel</a>
</body>
</html>