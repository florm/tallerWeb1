var pass = $("#password");
var mail = $("#email");
var btnLogin = $("#btn-login");
var modalLogin = $("#modal-login");
var usuarioMenu = $("#usuario-menu");
var divLoginErroneo = $("#divLoginErroneo");
var nombreUsuario = $("#nombreUsuario");
var menuppal = $(".menuppal");

//btnLogin.click(function() {
//	event.preventDefault();
//	var user = new Object();
//	user.password = pass.val();
//	user.email = mail.val();
//	$.ajax({
//		headers : {
//			'Accept' : 'application/json',
//			'Content-Type' : 'application/json'
//		},
//		type : "POST",
//		dataType : 'text',
//		url : "validar-login",
//		data : JSON.stringify(user)
//		success : function(result) {
//			armarMenuUsuario(result);
//			$("#btn-modal").attr("hidden","hidden");
//			$('.modal.in').modal('hide');
//			
//			
//		},
//		error : function(e) {
//			mostrarMensajeError();
//		}
//	});
//});

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

//function armarMenuUsuario(result){
//	var ul = $("<ul class='ml-5' id='menu-usuario'>");
//	var li = $("<li>");
//	li.addClass("has-dropdown");
//	
//	
//	var a = $("<a>");
//	a.attr("id", "nombreUsuario");
//	a.attr("href", "#");
//	a.text(result);
//	li.append(a);
//	
//	var ulLista = $("<ul class='dropdown'>");
//	var liLista =$("<li>");
//	var aLista=$("<a>");
//	aLista.attr("href", result);
//	liLista.append(a);
//	ulLista.append(li);
//	
//	
//	li.append(ulLista);
//	ul.append(li);
//	menuppal.append(ul);
//	$('.has-dropdown').mouseenter(function(){
//
//		var $this = $(this);
//		$this
//			.find('.dropdown')
//			.css('display', 'block')
//			.addClass('animated-fast fadeInUpMenu');
//
//	}).mouseleave(function(){
//		var $this = $(this);
//
//		$this
//			.find('.dropdown')
//			.css('display', 'none')
//			.removeClass('animated-fast fadeInUpMenu');
//	});
//
//	
//	
//}
