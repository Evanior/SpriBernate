$(function(){
	bindAction();
	loadCommand();
	setInterval(loadCommand, 5000);
});

function bindAction(){
	//bindClick('selecteur', function);
}

function bindClick(selector, operation){
	$(selector).unbind();
	$(selector).click(operation);
}

function loadCommand(){
	$('.inner').html("");
	$.getJSON( context + 'command', function( json ) {
		$.each(json.data, function (index, value){
			var nomPlat = value[0];
			var quantite = value[1];
			var table = value[2];
			var str = "";
			if($('#tableN'+table).length){
				if($('#tableN'+table+' .'+nomPlat).length){
					quantite += $('#tableN'+table+' .'+nomPlat).data('quantite');
					$('#tableN'+table+' .'+nomPlat).html("<div class='plat "+nomPlat+"' " +
							"data-quantite='"+quantite+"'><p>"+nomPlat+" : "+quantite+"</p></div>");
				}else{
					$('#tableN'+table).append("<div class='plat "+nomPlat+"' data-quantite='"+quantite+"'>" +
							"<p>"+nomPlat+" : "+quantite+"</p></div>");
				}
			}else{
				$('.inner').append("<div class='tableService col-sm-3' id=tableN"+table+"><h2 class='soustitre'>Table N"+table+"</h2>" +
						"<div class='plat "+nomPlat+"' data-quantite='"+quantite+"'><p>"+nomPlat+" :  "+quantite+"</p></div>" +
						"</div>");
			}
		});
		bindAction();
	});
}