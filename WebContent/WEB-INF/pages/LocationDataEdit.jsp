<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page isErrorPage="false" %>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="updateLoc" method="post">
<pre>
Id	:<input type="text" name="locId" value="${locidObj.locId}" readonly="readonly"/>	
NAME:<input type="text" name="locName" value="${locidObj.locName}"/>
SuperVisor Name:<input type="text" name="locSup" value="${locidObj.locSup}"/>
AdViser Name:<input type="text" name="locAdv" value="${locidObj.locAdv}"/>
State:<input type="text" name="locSta" value="${locidObj.locSta}"/>
Country:<input type="text" name="locCou" value="${locidObj.locCou}"/>
Pin Code:<input type="text" name="locPin" value="${locidObj.locPin}"/>
TYPE:<c:choose><c:when test="${locidObj.locType eq 'Urban'}"><input type="radio" name="locType" value="Urban" checked="checked">Urban<input type="radio" name="locType" value="Rural">Rural
</c:when><c:otherwise><input type="radio" name="locType" value="Urban">Urban<input type="radio" name="locType" value="Rural" checked="checked">Rural</c:otherwise></c:choose>
<input type="submit" value="Register">
</pre>
</form>
</body>
</html>