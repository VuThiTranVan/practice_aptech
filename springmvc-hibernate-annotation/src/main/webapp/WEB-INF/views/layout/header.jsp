<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>Spring MVC - Example</title>

<!-- Latest compiled and minified CSS -->
<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapCss" />
<spring:url value="/assets/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/assets/js/jquery.min.js" var="jquery" />

<link rel="stylesheet" href="${bootstrapCss}" />
<script src="${jquery}" type="text/javascript"></script>
<script src="${bootstrapJs}" type="text/javascript"></script>


</head>

<spring:url value="/" var="urlHome" />
<spring:url value="/students/add" var="addActionUrl" />

<nav class="navbar navbar-inverse ">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="${urlHome}">Spring MVC Home</a>
		</div>
		<div id="navbar">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${addActionUrl}">Add Student</a></li>
			</ul>
		</div>
	</div>
</nav>