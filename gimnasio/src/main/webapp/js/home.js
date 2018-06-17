var pass = $("#password");
var mail = $("#email");
var btnLogin = $("#btn-login");
var modalLogin = $("#modal-login");
var usuarioMenu = $("#usuario-menu");
var divLoginErroneo = $("#divLoginErroneo");

btnLogin.click(function() {
	event.preventDefault();
	var user = new Object();
	user.password = pass.val();
	user.email = mail.val();
	$.ajax({
		headers : {
			'Accept' : 'application/json',
			'Content-Type' : 'application/json'
		},
		type : "POST",
		dataType : 'json',
		url : "validar-login",
		data : JSON.stringify(user),
		success : function(result) {
			armarMenuUsuario(result);
			$("#btn-modal").attr("hidden","hidden");
			$('.modal.in').modal('hide');
			
		},
		error : function(e) {
			mostrarMensajeError();
		}
	});
});

function mostrarMensajeError() {
	divLoginErroneo.removeAttr("hidden");
	divLoginErroneo.css("color", "red");
	window.setTimeout(function() {
		divLoginErroneo.fadeTo(500, 0).slideUp(500, function() {
			window.$(this).attr("hidden", "hidden");
			window.$(this).removeAttr("style");
		});
	}, 5000);
	pass.val("");
}

function armarMenuUsuario(result){
	var a = $("<a>");
	a.attr("href", "#");
	a.text(result.email);
	var ul = $("<ul>");
	ul.addClass("dropdown");
	var inscripcion = $("<li>");
	inscripcion.text("Inscripciones");
	ul.append(inscripcion);
	usuarioMenu.append(a);
	usuarioMenu.append(ul);
}