<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Example Spring 4 - hibernate 5</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container" style="margin-top: 50px">
		<div class="row md-col-8">
			<div class="md-col-8">
				<fieldset>
					<legend>
						<h2>User Input From</h2>
					</legend>
					<form:form action="#" method="post" modelAttribute="student"
						cssClass="form-horizontal">
						<table>
							<tr>
								<th>Name</th>
								<td><form:input path="name" cssClass="form-control" /> <form:errors
										path="name" cssClass="error" /></td>
								<th style="padding-left: 28px;">Email</th>
								<td><form:input path="email" cssClass="form-control" /> <form:errors
										path="email" cssClass="error" /></td>
								<td style="padding-left: 28px;"><button type="submit">Submit</button></td>
							</tr>
						</table>
					</form:form>
				</fieldset>
			</div>
		</div>
		<div class="row" style="margin-top: 20px">
			<div class="md-col-8">
				<fieldset>
					<legend>
						<h2>Student List</h2>
					</legend>
					<table class="table table-hover table-dark">
						<thead class="bg-primary">
							<tr>
								<th scope="col">#</th>
								<th scope="col">Email</th>
								<th scope="col">Username</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${students}" var="student" varStatus="count">
								<tr>
									<th scope="row">${count.index + 1}</th>
									<td>${student.email}</td>
									<td>${student.name}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</fieldset>
			</div>
		</div>
	</div>

</body>
</html>