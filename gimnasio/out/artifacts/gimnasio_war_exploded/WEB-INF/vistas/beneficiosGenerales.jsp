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
		<%@include file="menuSinLogin.jsp"%>

		<div class="container">
			<div class="row d-flex flex-column text-center m-5">
				<h2>Beneficios</h2>
				<p>Los Beneficios varían de acuerdo al Plan contratado</p>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-4 mt-5">
					<div class="fh5co-blog animate-box fadeInUp animated-fast">
						<img class="img-responsive" src="<c:url value="/images/Adidas.jpg" />" alt="">
						<div class="d-flex flex-column justify-content-center align-items-center p-3 mt-3">
							<h3><a class="text-uppercase " href="#">Adidas</a></h3>
    						<h5 class="text-center">De 5 a 20% de descuento en indumentaria</h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 mt-5">
					<div class="fh5co-blog animate-box fadeInUp animated-fast">
						<img class="img-responsive" src="<c:url value="/images/Nike.jpg" />" alt="">
						<div class="d-flex flex-column justify-content-center align-items-center p-3 mt-3">
							<h3><a class="text-uppercase " href="#">Nike</a></h3>
    						<h5 class="text-center">De 10 a 20% de descuento en indumentaria (no zapatillas)</h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 mt-5">
					<div class="fh5co-blog animate-box fadeInUp animated-fast">
						<img class="img-responsive" src="<c:url value="/images/Medife.jpg" />" alt="">
						<div class="d-flex flex-column justify-content-center align-items-center p-3 mt-3">
							<h3><a class="text-uppercase " href="#">Medife</a></h3>
    						<h5 class="text-center">De 5 a 15% de descuento en planes de salud</h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 mt-5">
					<div class="fh5co-blog animate-box fadeInUp animated-fast">
						<img class="img-responsive" src="<c:url value="/images/America Resto.jpg" />" alt="">
						<div class="d-flex flex-column justify-content-center align-items-center p-3 mt-3">
							<h3><a class="text-uppercase " href="#">America Resto</a></h3>
    						<h5 class="text-center">De 5 a 25% de descuento en mesas restaurante y salones para eventos especiales</h5>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-4 mt-5">
					<div class="fh5co-blog animate-box fadeInUp animated-fast">
						<img class="img-responsive" src="<c:url value="/images/Lof.jpg" />" alt="">
						<div class="d-flex flex-column justify-content-center align-items-center p-3 mt-3">
							<h3><a class="text-uppercase " href="#">Lof</a></h3>
    						<h5 class="text-center">De 20% de descuento en todos los productos (exceptuando lentes de contacto descartables)</h5>
						</div>
					</div>
				</div>
				
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
