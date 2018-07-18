var idDescuento = $("#idDescuento");
var btnmercadopago = $("#btnmercadopago");
var btnpagar = $("#btn-pagar");
idDescuento.change( function(){
	var precio = $('option:selected',this).attr("importe");
	var json = {"titulo": "pago",
				"descripcion": "pago de pase",
				"cantidad": "1",
				"precio": precio
		};
	
	$.ajax({
	  url: "/gimnasio/mercadopago",
	  data: JSON.stringify(json),
	  type: "POST",
	  beforeSend: function(xhr) {
	      xhr.setRequestHeader("Accept", "application/json");
	      xhr.setRequestHeader("Content-Type", "application/json");
	  },      
	  success: function(data) {
		 dibujarBoton(data);
		  
	  }
	});
});

function dibujarBoton(data){
	var html = "";
	  html = html + '<a href="' + data.href + "\"target='_blank' class='btn btn-primary'>1. Pagar</a>";
	  $("#btnmercadopago").html(html);
	  btnmercadopago.removeClass("d-none").addClass("d-flex");
	  btnpagar.removeClass("d-none").addClass("d-flex");
	  
}