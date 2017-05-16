<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%-- <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"  %>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Master.jsp" %>
<form action="insertVen" method="post" name="venForm" onsubmit="return validateVenForm();" enctype="multipart/form-data">
<pre>
ID      :<input type="text" name="id"/><span id="venIdErr" class="error"></span><br>
NAME	:<input type="text" name="name"/><span id="venNameErr" class="error"></span><br>
Email	:<input type="text" name="email"/><span id="venEmailErr" class="error"></span><br>
Location:<select name="loc.locId" id="locInp">
			<option value="-1">---Select---</option>
			<c:forEach items="${locListObj}" var="loc">
			<option value="${loc.locId}"><c:out value="${loc.locName}"/></option>
			</c:forEach>
		 </select><span id="locErr"></span><br>
Address	:<input type="text" name="addr"/><span id="venAddressErr" class="error"></span><br>
Gender	:<input type="radio" name="gen" value="male"/>MALE<input type="radio" name="gen" value="female"/>FEMALE<br>
<!-- File	:<input type="file" name="fileObj"/><br> -->
<input type="submit" value="insert"/><input type="reset" value="clear"/>
</pre>
</form>
${id}<br>
<a href="viewAllVen">View All Vendors</a><br>
</body>
</html>