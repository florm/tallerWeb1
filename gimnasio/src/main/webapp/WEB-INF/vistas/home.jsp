<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Stamina Gimnasios</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="freehtml5.co" />


	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap4.min.css">
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<link href="css/fontawesome-all.css" rel="stylesheet">
	<link href="css/estilos.css" rel="stylesheet">

	</head>
	<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-right">
						<p class="num">Tel: +01 123 456 7890</p>
						<ul class="fh5co-social">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
							<li><a href="#"><i class="icon-github"></i></a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="top-menu">
			<div class="container">
				<div class="row">
					<div class="col-xs-2">
						<div id="fh5co-logo"><a href="index.html">Stamina<span>.</span></a></div>
					</div>
					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li class="active"><a href="index.html">Inicio</a></li>
							<li><a href="gallery.html">Galería</a></li>
							<li><a href="about.html">Nosotros</a></li>
							<li><a href="pases">Pases</a></li>
							<li><a href="contact.html">Contacto</a></li>
							
							<li class="has-dropdown" id="usuario-menu">
								<a href="blog.html">Mi Cuenta</a>
								<ul class="dropdown">
									<li><a href="#">Inscripciones</a></li>
									<li><a href="#">Pagos</a></li>
									<li><a href="#">Mi pase</a></li>
									<li><a href="#">Mis datos</a></li>
								</ul>
							</li>
							
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</nav>

	<header id="fh5co-header" class="fh5co-cover" role="banner" style="background-image:url(images/img_banner.jpg);" data-stellar-background-ratio="0.3">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<div class="display-t">
						<div class="display-tc animate-box" data-animate-effect="fadeIn">
							<h1>Un estilo de vida, <br> no un deber.</h1>
							<h2>La cadena de gimnasios más grande de Buenos Aires</h2>
							
							<button id="btn-modal" class="btn with-arrow" type="button" rel="tooltip" data-placement="bottom" title="" data-toggle="modal" data-target="#modal-login" data-original-title="Login">
								Ingresar
							</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
<!-- modal registro -->
<div class="modal fade login" id="modal-login" role="dialog" tabindex="-1">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Iniciar sesion</h4>
        <button class="close" aria-label="Close" data-dismiss="modal" ,="" type="button">
          <span aria-hidden="true">×</span>
        </button>
        
      </div>
      <div class="modal-body p-5">
	      <form class="text-center" method="post" action="validar-login" id="form-login">
		    <div class="form-group input-size">
		        <input type="text" class="form-control" id="email"  name="email" placeholder="Email" required>
		    </div>
		    <div class="form-group input-size">
		        <input type="password" class="form-control" id="password" name="password" placeholder="Contraseña" required>
		    </div>
		    <div id="divLoginErroneo" class="alert alert-danger-custom" role="alert" hidden="hidden">
		        Revise su Usuario y Contraseña e intente ingresar nuevamente
		    </div>
		
		    <input type="submit" id="btn-login" value="Ingresar" class="btn btn-primary">
		    <div class="text-center">
		        <span>Aún no está registrado?</span>
		        <a href="usuario/registrar">Registrarse</a>
		    </div>
		</form>
      	
      </div>
    </div>
  </div>
</div>
</div>

<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	<script src="js/home.js"></script>
	

<body>
</body>

</html>
