
var responseOk = $("#responseOk");
var responseError = $("#responseError");

$(document).ready(function() {
$('#registrarSocio').submit(function(event) {

    

	var formulario = $('#registrarSocio');
	var usuario = $("#usuarion").val();
	var pass = $("#passwordn").val();
	var nombre = $("#nombre").val();
	var apellido = $("#apellido").val();
	var dni = $("#dni").val();
	var ciudad = $("#ciudad option:selected").val();

	
	var domicilioCalle = $("#domicilioCalle").val();
	var domicilioNumero = $("#domicilioNumero").val();
	var domicilioDepto = $("#domicilioDepto").val();
	var telefono = $("#telefono").val();
	var mail = $("#mail").val();
	var recomendador = $("#recomendadoPor").val();
	var sucursal = $("#sucursal option:selected").val();
	
	
   	var json = {"usuario":{"nick":usuario, "password":pass},
   				"nombre":nombre,
   				"apellido":apellido,
   				"dni":dni,
   				"ciudad":{"id":ciudad},
   				"domicilioCalle":domicilioCalle,
   				"domicilioNumero":domicilioNumero,
   				"domicilioDepto":domicilioDepto,
   				"telefono":telefono,
   				"mail":mail,
   				"recomendadoPor":{"dni":recomendador},
   				"sucursal":{"id":sucursal},
   	};
   	
  $.ajax({
      url: "registrosocio",
      data: JSON.stringify(json),
      type: "POST",
      beforeSend: function(xhr) {
          xhr.setRequestHeader("Accept", "application/json");
          xhr.setRequestHeader("Content-Type", "application/json");
      },      
      success: function(data) {
    	  if(data.estado == "1"){
    		  var html = "";
    		  html = html + '<span>' + data.mensaje + '</span>';
    		  responseOk.html(html);
    		  responseOk.removeClass("d-none").addClass("d-flex");
    		  setInterval(function(){
    			  responseOk.removeClass("d-flex").addClass("d-none"); window.location.href="/gimnasio/";
    		  }, 3000);
    	  }
    	  else{
    		  var html = "";
    		  html = html + '<span>' + data.mensaje + '</span>';
    		  responseError.html(html);
    		  responseError.removeClass("d-none").addClass("d-flex");
    		  setInterval(function(){
    			  responseError.removeClass("d-flex").addClass("d-none");
    		  }, 3000);
    	  }
      }
  });
    
  event.preventDefault();
	});
});



