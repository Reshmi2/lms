<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Leave</title>
</head>
<body style="background:lightblue">
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2>Welcome ${pageContext.request.userPrincipal.name} | <a onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>

</div>
<div align="center">	
		<h1>Update Leave Details</h1>
		<br/>
		<c:url var="action" value="/Approve"/>
	<form:form action="${action}" method="post"  modelAttribute="editLeave" novalidate="novalidate">
     <table>
            <tr>
				<td> Leave ID:</td>
				<td><form:input path="id" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>From Date</td>
				<td><form:input path="fromDate" /></td>
				<%-- <font color="red"><form:errors path="fromDate" /></font> --%>
			</tr>
			<tr>
				<td>To Date</td>
				<td><form:input path="toDate" /></td>
			</tr>
			<tr>
				<td>LeaveType</td>
				<td><form:input path="leaveType" /></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Approve" /></td>
				<td><input type="reset" value="Cancel" /></td>
			</tr>
		</table>

      </form:form>
</div>

</body>
</html>