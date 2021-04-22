<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create new Leave</title>
<link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body  style="background:lightblue">
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>

</div>
<div align="center">	
		<h1> New Leave</h1>
		<br/>
	<form:form action="save" method="post"  modelAttribute="leaveForm" novalidate="novalidate">
     <table>
			<tr>
				<td> UserName:</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>From Date:</td>
				<td><form:input  path="fromDate" /></td>
				<%-- <font color="red"><form:errors path="fromDate" /></font> --%>
			</tr>
			<tr>
				<td>To Date:</td>
				<td><form:input  path="toDate" /></td>
			</tr>
			<tr>
				<td>Leave Type:</td>
				<td><form:input path="leaveType" /></td>
			</tr>
			
						<tr>
				<td><input type="submit" value="Apply Leave" /></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>
		</table>

      </form:form>
</div>

</body>
</html>