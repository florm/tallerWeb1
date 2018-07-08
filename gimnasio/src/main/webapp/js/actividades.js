var responseOk = $("#responseOk");
var responseError = $("#responseError");
var inputIdSocio = 0;
var inputIdSucursalActividad = 1;
var inputIdSucursal = 2;


$(document).ready(function() {
$('form').submit(function(event) {
    var formSeleccionado = $(this);
    var idSocio = formSeleccionado[0][inputIdSocio].value;
    var idSucursalActividad = formSeleccionado[0][inputIdSucursalActividad].value; 
    var idSucursal = formSeleccionado[0][inputIdSucursal].value; 
   	var json = { "idSucursal": idSucursal , "idSocio" : idSocio, "idSucursalActividad" : idSucursalActividad };
     
  $.ajax({
      url: $('form').attr( "action"),
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
    			  responseOk.removeClass("d-flex").addClass("d-none"); window.location.reload();
    		  }, 3000);
    	  }
    	  else{
    		  var html = "";
    		  html = html + '<span>' + data.mensaje + '</span>';
    		  responseError.html(html);
    		  responseError.removeClass("d-none").addClass("d-flex");
    		  setInterval(function(){
    			  responseError.removeClass("d-flex").addClass("d-none"); window.location.reload();
    		  }, 3000);
    	  }
      }
  });
    
  event.preventDefault();
	});
});



