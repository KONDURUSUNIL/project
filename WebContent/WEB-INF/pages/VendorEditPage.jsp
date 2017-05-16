<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="updateVen" method="post">
<pre>
ID		:<input type="text" name="id" value="${venid.id}" readonly="readonly"/>
NAME	:<input type="text" name="name" value="${venid.name}"/>
Email	:<input type="text" name="email" value="${venid.email}"/>
Location:<select name="loc.locId" id="locInp">
		<option value="-1">---Select---</option>
		<c:forEach items="${locListObj}" var="loc">
		<c:choose>
		<c:when test="${venid.loc.locId eq loc.locId}">
		<option value="${loc.locId}" selected="selected"><c:out value="${loc.locName}" /></option>
		</c:when>
		<c:otherwise>
		<option value="${loc.locId}"><c:out value="${loc.locName}" ></c:out></option>
		</c:otherwise>
		</c:choose>
		</c:forEach>
		 </select>
Address:<input type="text" name="addr" value="${venid.addr}"/>
Gender:<c:choose><c:when test="${venid.gen eq 'male'}"><input type="radio" name="gen" value="male" checked="checked">MALE<input type="radio" name="gen" value="female">FEMALE</c:when><c:otherwise><input type="radio" name="gen" value="male">MALE<input type="radio" name="gen" value="female" checked="checked">FEMALE</c:otherwise></c:choose>
<input type="submit" value="update">
</pre>
</form>
</body>
</html>