<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="uploadfile" method="post" enctype="multipart/form-data">
<pre>
Document ID	:<input type="text" name="fileId"/>
Document	:<input type="file" name="fileDtls"/>
<input type="submit" value="Register"/>
</pre>
</form>
<table border="1">
<tr>
<td>Id</td><td>Name</td><td>Download</td>
</tr>
<c:forEach items="${listfile}" var="file">
<tr>
<td><c:out value="${file[0]}"></c:out></td>
<td><c:out value="${file[1]}"></c:out></td>
<td><a href='download?fileId=<c:out value="${file[0]}"/>'>Download</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>