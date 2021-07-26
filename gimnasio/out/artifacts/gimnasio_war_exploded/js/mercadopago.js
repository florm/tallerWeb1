var idDescuento = $("#idDescuento");
var btnmercadopago = $("#btnmercadopago");
var btnpagar = $("#btn-pagar");
var idSocioInput = $("#idSocio");
var idPaseInput = $("#idPase");
idDescuento.change( function(){
	var precio = $('option:selected',this).attr("importe");
	var json = new Object();
	json.titulo = "pago";
	json.descripcion = "paso de pase";
	json.cantidad = 1;
	json.precio = precio;
	json.idPase = idPaseInput.val();
	json.idSocio = idSocioInput.val();
	json.idDescuento = $(this).val();
	// var json = {"titulo": "pago",
	// 			"descripcion": "pago de pase",
	// 			"cantidad": "1",
	// 			"precio": precio
	// 	};
	
	$.ajax({
	  url: "/gimnasio/mercadopago",
	  data: JSON.stringify(json),
		dataType: 'text',
	  type: "POST",
	  beforeSend: function(xhr) {
	      xhr.setRequestHeader("Accept", "application/json");
	      xhr.setRequestHeader("Content-Type", "application/json");
	  },      
	  success: function(data) {
		 dibujarBoton(data);
		  
	  },
		error: function(e){
	  		console.log(e);
		}
	});
});

$(document).ajaxStart(function(){
    $("#wait").css("display", "block");
});
$(document).ajaxComplete(function(){
    $("#wait").css("display", "none");
});

function dibujarBoton(data){
	var script = document.createElement("script");
	script.src = "https://www.mercadopago.com.ar/integrations/v1/web-payment-checkout.js";
	script.type = "text/javascript";
	script.dataset.preferenceId = data;
	// var html = "";
	// html = html + '<a href="' + data.href + "\"target='_blank' class='btn btn-primary'>1. Pagar</a>";
	// $("#btnmercadopago").html(html);
	// //$("#btnmercadopago").innerHTML = "";
	// $("#btnmercadopago").appendChild(script);
	//
	//   btnmercadopago.removeClass("d-none").addClass("d-flex");
	//   btnpagar.removeClass("d-none").addClass("d-flex");
	document.getElementById("button-checkout").innerHTML = "";
	document.querySelector("#button-checkout").appendChild(script);
	  
}