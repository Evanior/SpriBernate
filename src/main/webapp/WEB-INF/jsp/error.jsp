<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>ERROR</title>
</head>
<body>
	<h1>ERROR</h1>
	<div class="field">codeError : <c:out value="${error}"></c:out></div>
	<a href="<c:url value="/"/>">retour</a>
</body>
</html>