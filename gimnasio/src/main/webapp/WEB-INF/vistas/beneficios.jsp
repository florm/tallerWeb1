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
							<a href="<c:url value="/"/>">Salir</a>
							<p>Bienvenido/a ${sessionScope.nombre}</p>
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
								<li><a href="<c:url value="/sucursal/${sessionScope.idSucursal}/actividades" />">Actividades</a></li>
								<li><a href="<c:url value="/beneficios/pase/${sessionScope.idPase}" />">Beneficios</a></li>
								<li><a href="<c:url value="/socio/${sessionScope.idSocio}/mi-cuenta" />">Mi Cuenta</a></li>
							</ul>
						</div>

					</div>

				</div>
			</div>
		</nav>

		<div class="container">
			<div class="row">
				<c:forEach items="${listaBeneficios}" var="lista">
					<div class="col-lg-4 col-md-4">
					<div class="fh5co-blog animate-box fadeInUp animated-fast">
						<c:url var="imagen" value="/images/${lista.nombre}.jpg" />
						<a href="#"><img class="img-responsive" src="${imagen}" alt=""></a>
						<div class="blog-text d-flex flex-column justify-content-between align-items-start">
							<h3><a class="text-uppercase "href="" #="">${lista.nombre}</a></h3>
							<span class="posted_on">${lista.descuento}</span>
							
							<p>${lista.descripcion}</p>
							<a href="#" class="btn btn-primary">Imprimir cupón</a>
						</div> 
					</div>
				</div>
				</c:forEach>

			</div>
		</div>
		</div>


		<!-- jQuery -->

		<script src="<c:url value="/js/jquery.min.js" />"></script>
		<!-- jQuery Easing -->

		<script src="<c:url value="/js/jquery.easing.1.3.js" />"></script>
		<!-- Bootstrap -->

		<script src="<c:url value="/js/bootstrap.min.js" />"></script>
		<!-- Waypoints -->

		<script src="<c:url value="/js/jquery.waypoints.min.js" />"></script>
		<!-- Stellar Parallax -->

		<script src="<c:url value="/js/jquery.stellar.min.js" />"></script>
		<!-- Carousel -->

		<script src="<c:url value="/js/owl.carousel.min.js" />"></script>
		<!-- countTo -->

		<script src="<c:url value="/js/jquery.countTo.js" />"></script>

		<!-- Main -->
		<script src="<c:url value="/js/main.js" />"></script>
</body>

</html>
