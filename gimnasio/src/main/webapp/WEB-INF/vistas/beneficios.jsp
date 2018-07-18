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
		<%@include file="menu.jsp"%>

		<div class="container">
		<c:if test="${sessionScope.estado == 0}"> <!-- Si el pase es 5 aparecerá esta leyenda -->
			
			<br><div class="col-md-8 col-md-offset-2 text-center">
						<div class="display-t">
							<div class="display-tc" data-animate-effect="fadeIn">
								<h1>
									No hay beneficios disponibles <br> 
								</h1>
								<h2>Necesita abonar un pase para obtener beneficios exclusivos!</h2>
							</div>
						</div>
					</div>
			
			</c:if>
			<c:if test="${sessionScope.estado != 0}"> <!-- El pase de ID 5 es el que se utiliza por defecto en un usuario recien registrado, no posee actividades disponibles -->
			<div class="row">
				<c:forEach items="${listaBeneficios}" var="lista">
					<div class="col-lg-4 col-md-4 mt-5">
						<div class="fh5co-blog animate-box fadeInUp animated-fast">
							<c:url var="imagen" value="/images/${lista.nombre}.jpg" />
							<a href="#"><img class="img-responsive" src="${imagen}"
								alt=""></a>
							<div
								class="blog-text d-flex flex-column justify-content-between align-items-start">
								<h3>
									<a class="text-uppercase " href=""#="">${lista.nombre}</a>
								</h3>
								<span class="posted_on">${lista.descuento}</span>

								<p>${lista.descripcion}</p>
								<a href="<c:url value='/download/${lista.nombre}' />" class="btn btn-primary">Imprimir cupón</a>
							</div>
						</div>
					</div>
				</c:forEach>

			</div>
			</c:if>
		</div>
		
		<%@include file="footerRol.jsp"%>
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
