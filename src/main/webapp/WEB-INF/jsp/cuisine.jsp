<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Cuisine</title>
	<link type="text/css" href="<c:url value="/css/bootstarp.min.css"/>" rel="stylesheet"/>
	<link type="text/css" href="<c:url value="/css/cuisine.css"/>" rel="stylesheet"/>
</head>
<body>
	<header class="blockHeader">
		<h1 class="titre">Plat Commander</h1>
	</header>
	<main class="blockMain contnaire">
		<div class="inner row">
		
		</div>
	</main>
	<script type="text/javascript">
		var context = '<c:url value="/" />';
	</script>
	<script src="<c:url value="/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/js/bootstarp.min.js"/>"></script>
	<script src="<c:url value="/js/cuisine.js"/>"></script>
</body>
</html>