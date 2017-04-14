<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Commande</title>
	<link type="text/css" href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
	<link type="text/css" href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
</head>
<body>
	<header class="blockHeader container">
		<h1 class="titre">Commande</h1>
		<h3 class="sousTitre">Table N°<c:out value="${table}"></c:out></h3>
	</header>
	<main class="blockMain container">
		<div class="row">
			<div class="plat col-sm-6">
				<h2 class="sousTitre">Menu</h2>
				<table>
					<tbody>
						<c:forEach items="${list}" var="item">
							<tr class="data" data-plat="${item.nom}" data-table="${table}">
								<td><c:out value="${item.nom}"></c:out></td>
								<td><c:out value="${item.description}"></c:out></td>
								<td><c:out value="${item.prix}"></c:out> &euro;</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="panier col-sm-6">
				<h2>Panier</h2>
				<table>
					<thead>
						<tr>
							<th>Plat</th>
							<th>Quantité</th>
							<th>Prix</th>						
							<th>Total</th>
						</tr>
					</thead>
					<tbody id="tablePanier">
					
					</tbody>
				</table>
				<button id="annulerPanier">Annuler</button>
				<button id="validePanier">Valider</button>
			</div>
		</div>
	</main>
	<script type="text/javascript">
		var context = '<c:url value="/" />';
		var numTable = ${table};
	</script>
	<script src="<c:url value="/js/jquery.min.js"/>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/js/app.js"/>"></script>
</body>
</html>
