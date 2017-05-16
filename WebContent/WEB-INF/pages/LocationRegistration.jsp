<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page isErrorPage="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="insertLoc" method="post">
<pre>
Id	:<input type="text" name="locId"/>	
NAME:<input type="text" name="locName"/>
Supervisor Name:<input type="text" name="locSup"/>
Adviser Name:<input type="text" name="locAdv"/>
State:<input type="text" name="locSta"/>
Country:<input type="text" name="locCou"/>
Pin Code:<input type="text" name="locPin"/>
TYPE:<input type="radio" name="locType" value="Urban">Urban<input type="radio" name="locType" value="Rural">Rural
<input type="submit" value="Register">
</pre>
</form>
${id}<br>
<a href="viewAllLocs">VIEW ALL LOCATIONS</a>
</body>
</html>