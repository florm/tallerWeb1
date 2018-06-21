<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Stamina Gimnasios</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="author" content="freehtml5.co" />


<link
	href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800"
	rel="stylesheet">

<!-- Animate.css -->
<link href="<c:url value="/css/animate.css" />" rel="stylesheet">
<!-- Icomoon Icon Fonts-->
<link href="<c:url value="/css/icomoon.css" />" rel="stylesheet">
<!-- Bootstrap  -->
<link href="<c:url value="/css/bootstrap4.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">

<!-- Theme style  -->
<link href="<c:url value="/css/style.css" />" rel="stylesheet">

<!-- Modernizr JS -->
<script src="<c:url value="/js/modernizr-2.6.2.min.js" />"></script>

<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="<c:url value="/js/respond.min.js" />"></script>
	<![endif]-->

<link href="<c:url value="/css/fontawesome-all.css" />" rel="stylesheet">
<link href="<c:url value="/css/estilos.css" />" rel="stylesheet">

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<nav class="fh5co-nav" role="navigation">
			<div class="top">
				<div class="container">
					<div class="row justify-content-end">
						<div class="col-auto">
							<p>Bienvenido ${sessionScope.nombre}</p>
						</div>
						<div class="col-auto">
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
				<div class="container-fluid">
					<div class="row justify-content-between menuppal">
						<div class="col-xs-2">
							<div id="fh5co-logo">
								<a href="index.html">Stamina<span>.</span></a>
							</div>
						</div>
						<div class="d-flex menu-1">
							<ul>
								<li class="active"><a href="index.html">Inicio</a></li>
								<li><a href="gallery.html">Galería</a></li>
								<li><a href="about.html">Nosotros</a></li>
								<li><a href="pases">Pases</a></li>
								<li><a href="contact.html">Contacto</a></li>
								<li><a
									href="<c:url value="/sucursal/${sessionScope.idSucursal}/actividades" />">Actividades</a></li>

							</ul>
						</div>

					</div>

				</div>
			</div>
		</nav>
		<div class="container">
			<div class="row animate-box fadeInUp animated-fast">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading">
					<h2>Pases</h2>
					<p>Elige un plan:</p>
				</div>
			</div>
			<div class="row">
				<div class="pricing">
					<c:forEach items="${listaPases}" var="lista">
						<div class="col-md-3 animate-box fadeInUp animated-fast">
							<div class="price-box">
								<h2 class="pricing-plan">${lista.nombre}</h2>
								<div class="price">
									<sup class="currency">$</sup>${lista.precio}<small>mensual</small>
								</div>
								<ul class="classes">
									<li class="color">Cantidad de beneficios:</li>
									<li>Cantidad de actividades: <c:choose>
											<c:when test="${lista.cantidadActividades == nul}">
								Ilimitadas
								</c:when>
											<c:otherwise>
								${lista.cantidadActividades}
								</c:otherwise>
										</c:choose></li>
								</ul>
								<a href="#" class="btn btn-select-plan btn-sm">Seleccionar
									Pase</a>
							</div>
						</div>

					</c:forEach>

				</div>
			</div>
		</div>




		<footer id="fh5co-footer" class="fh5co-bg"
			style="background-image: url(images/img_bg_1.jpg);"
			role="contentinfo">
			<div class="overlay"></div>
			<div class="container">
				<div class="row row-pb-md">
					<div class="col-md-4 fh5co-widget">
						<h3>Un poco sobre Stamina.</h3>
						<p>La mayor cadena de gimnasios ubicada en Buenos Aires, que
							te permite dedicarle más tiempo a tu entrenamiento y a tu salud.
							Contamos con más de 20 sucursales para estar más cerca tuyo y que
							disfrutes de cada entrenamiento en un clima motivador y
							distendido.</p>
						<p>
							<a class="btn btn-primary" href="#">Registrarme</a>
						</p>
					</div>
					<div class="col-md-8">
						<h3>Clases</h3>
						<div class="col-md-4 col-sm-4 col-xs-6">
							<ul class="fh5co-footer-links">
								<li><a href="#">Cardio</a></li>
								<li><a href="#">Body Building</a></li>
								<li><a href="#">Yoga</a></li>
								<li><a href="#">Boxing</a></li>
								<li><a href="#">Running</a></li>
							</ul>
						</div>

						<div class="col-md-4 col-sm-4 col-xs-6">
							<ul class="fh5co-footer-links">
								<li><a href="#">Boxing</a></li>
								<li><a href="#">Martial Arts</a></li>
								<li><a href="#">Karate</a></li>
								<li><a href="#">Kungfu</a></li>
								<li><a href="#">Basketball</a></li>
							</ul>
						</div>

						<div class="col-md-4 col-sm-4 col-xs-6">
							<ul class="fh5co-footer-links">
								<li><a href="#">Badminton</a></li>
								<li><a href="#">Body Building</a></li>
								<li><a href="#">Teams</a></li>
								<li><a href="#">Advertise</a></li>
								<li><a href="#">API</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="row copyright">
					<div class="col-md-12 text-center">
						<p>
							<small class="block">&copy; 2018 - Todos los derechos
								reservados.</small>
						</p>
						<p>
						<ul class="fh5co-social-icons">
							<li><a href="#"><i class="icon-twitter"></i></a></li>
							<li><a href="#"><i class="icon-facebook"></i></a></li>
							<li><a href="#"><i class="icon-linkedin"></i></a></li>
							<li><a href="#"><i class="icon-dribbble"></i></a></li>
						</ul>
						</p>
					</div>
				</div>

			</div>
		</footer>
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
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

</body>
</html>

