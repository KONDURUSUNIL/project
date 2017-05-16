<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<table border="1" background="black" bordercolor="red">
<tr>
<th>ID</th><th>NAME</th><th>TYPE</th><th>EMAIL</th><th>ADDR</th><th>MOBILE</th><th>DELETE</th><th>UPDATE</th>
</tr>
<c:forEach items="${listObj}" var="cust">
<tr>
<td><c:out value="${cust.custId}"/></td>
<td><c:out value="${cust.custName}"/></td>
<td><c:out value="${cust.custType}"/></td>
<td><c:out value="${cust.custEmail}"/></td>
<td><c:out value="${cust.custAddr}"/></td>
<td><c:out value="${cust.custMob}"/></td>
<td><a href='deletecust?custId=<c:out value="${cust.custId}"/>'>DELETE</a></td>
<td><a href='editcust?custId=<c:out value="${cust.custId}"/>'>UPDATE</a></td>
<td><a href='exportToCustomerSinglePdf?custId=<c:out value ="${cust.custId}"/>'>Pdf</a></td>
</tr>
</c:forEach>

</table>
<a href="exportToCustomerPdf">Generate Pdf</a>
<a href="exportToCustomerExcel">Excel</a>
</body>
</html>