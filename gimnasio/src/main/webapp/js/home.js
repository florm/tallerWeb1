var pass = $("#password");
var mail = $("#email");
var btnLogin = $("#btn-login");
var modalLogin = $("#modal-login");
var usuarioMenu = $("#usuario-menu");
var divLoginErroneo = $("#divLoginErroneo");
var nombreUsuario = $("#nombreUsuario");
var menuppal = $(".menuppal");



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


var socios = $('#socios').DataTable( {
    lengthChange: false,
        
    scrollY:        400,
    scrollCollapse: true,
    paging:         true

} );

