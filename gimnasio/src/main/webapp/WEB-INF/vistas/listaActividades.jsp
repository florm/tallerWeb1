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
			<c:if test="${not empty exito}">
				<h4>
					<span class="mr-2">${exito}</span>
					<a href=<c:url value="/sucursal/${sessionScope.idSucursal}/actividades" />>Volver</a>
				</h4>
				<br>
			</c:if>
			<div class="row">
				<c:forEach items="${listaActividades}" var="lista">
					<div
						class="col-md-4 text-center animate-box fadeInUp animated-fast">
						<div class="services">
							<h3>${lista.actividad.nombre}</h3>
							<h4>Cupo Máximo ${lista.cupo} personas</h4>
							<p>Dignissimos asperiores vitae velit veniam totam fuga
								molestias accusamus alias autem provident. Odit ab aliquam dolor
								eius</p>
							<c:url var="post_url" value="/registrarActividad" />
							<form:form action="${post_url}" method="post"
								modelAttribute="formularioInscripcion">
								<form:input path="idSocio" name="idSocio"
									value="${sessionScope.idSocio}" hidden="hidden"></form:input>
								<form:input path="idSucursalActividad"
									name="idSucursalActividad" value="${lista.idSucursalActividad}"
									hidden="hidden"></form:input>
								<form:input path="idSucursal" name="idSucursal"
									value="${sessionScope.idSucursal}" hidden="hidden"></form:input>
								<p>
									<button type="submit"
										class="btn btn-primary btn-outline btn-sm">
										Inscribirse <i class="icon-arrow-right"></i>
									</button>
								</p>
							</form:form>

						</div>
					</div>
				</c:forEach>

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
