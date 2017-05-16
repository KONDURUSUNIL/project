<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page isELIgnored="false" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="insertcust" method="post">
<pre>
ID:<input type="text" name="custId"/>
NAME:<input type="text" name="custName"/>
TYPE:<select name="custType"><option>SELECT</option><option>SELLER</option><option>CUSTOMER</option></select>
EMAIL:<input type="text" name="custEmail"/>
ADDRESS:<textarea name="custAddr" rows="2" cols="10"></textarea>
MOBILE:<input type="text" name="custMob"/>
<input type="submit" value="Register"/>
</pre>
</form>
${custIdObj}<br>
<a href="viewAllCust">View All Customers</a>
</body>
</html>