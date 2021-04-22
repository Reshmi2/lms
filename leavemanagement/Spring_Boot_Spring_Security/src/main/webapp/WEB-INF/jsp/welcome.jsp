<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <style>
    .table {
   margin: auto;
   width: 50%; 
}

    </style>
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
	<h1 style="color:red">Leave Management System</h1>
	<div>
		<a href="new">Apply Leave Here</a>
	</div>
	
	<br/><br/>	
	<table class="table table-stripped">
		<thead>
			<tr>
				<th>User ID</th>
				<th>Name</th>
				
				<th>FromtDate</th>
				<th>ToDate</th>	
				<th>Type of leave</th>
				<th>Action</th>
					<th>Status</th>		
							
			
			</tr>
		</thead>
		<c:forEach var="leave" items="${llist}">
		<tbody>
		<tr>
			<td>${leave.id}</td>
			<td>${leave.username}</td>
			<td>${leave.fromDate}</td>
			<td>${leave.toDate}</td>
			<td>${leave.leaveType}</td>
			
			<td><a href="/Approve/${leave.id}">Approve</a> 
            <a href="/Reject/${leave.id}">Reject</a>
            <td>${leave.status }</td>
		</tr>
		</tbody>
		</c:forEach>
	</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
