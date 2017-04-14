$(function(){
	bindAction();
	loadPanier();
});

function bindAction(){
	bindClick('.data', platClicked);
	bindClick('#annulerPanier', annulPanier);
	bindClick('.supPlat', removePlatPanier);
}

function bindClick(selector, operation){
	$(selector).unbind();
	$(selector).click(operation);
}

function platClicked(){
	//var numTable = $(this).data("table");
	var nomPlat = $(this).data("plat");
	var url = context+'panier/'+numTable+'/add/'+nomPlat;
	console.log(url);
	$.ajax({
		method : "POST",
		url : url,
		success: function(response){
			if(response.error){
				
			}else{					
				loadPanier();
			}
		}
	});
}

function loadPanier(){
	$.getJSON( context + 'panier/'+numTable, function( json ) {
		console.log(json.data);
		var prixTotal = 0;
		var tableauPanier = "";
		$.each(json.data, function (index, value){
			var nomPlat = value[0];
			var prix = value[1];
			var quantite = value[2];
			var totalPrixPlat = prix * quantite;
			tableauPanier += "<tr><td>"+nomPlat+"</td><td>"+quantite+"</td><td>"+prix.toFixed(2)+" &euro;</td>" +
					"<td>"+totalPrixPlat+" &euro;</td><td><button class='supPlat' data-plat='"+nomPlat+"'>-</button></td></tr>";
			prixTotal += totalPrixPlat;
		});
		tableauPanier += "<tr><td></td><td></td><td></td><td>"+prixTotal.toFixed(2)+" &euro;</td></tr>";
		$("#tablePanier").html(tableauPanier);
		bindAction();
	});
}

function annulPanier(){
	console.log('click');
	var url = context+'panier/'+numTable+'/remove';
	$.ajax({
		method : "POST",
		url : url,
		success: function(response){
			if(response.error){
				
			}else{					
				loadPanier();
			}
		}
	});
}

function removePlatPanier(){
	console.log('click');
	var nomPlat = $(this).data("plat");
	var url = context+'panier/'+numTable+'/remove/'+nomPlat;
	$.ajax({
		method : "POST",
		url : url,
		success: function(response){
			if(response.error){
				
			}else{					
				loadPanier();
			}
		}
	});
}