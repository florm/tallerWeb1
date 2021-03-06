<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
		<c:if test="${empty sessionScope.idSocio}">
		<%@include file="menuSinLogin.jsp"%>
		</c:if>
		<c:if test="${!empty sessionScope.idSocio}">
			<%@include file="menu.jsp"%>
		</c:if>
		<div class="container">
		
			<div class="row animate-box fadeInUp animated-fast">
				<div class="col-md-8 col-md-offset-2 text-center">
					<h2>Pase Actual</h2>
				</div>
			</div>
			<div class="row">
			
				<div class="center-block">

							<div class="animate-box fadeInUp animated-fast">
								<div class="price-box">
									<h2 class="pricing-plan">${pase.nombre}</h2>
									<div class="price">
										<sup class="currency">$</sup>${pase.precio}<small>mensual</small>
									</div>
									<ul class="classes">
										
										<li>Cantidad de actividades: <c:choose>
												<c:when test="${pase.cantidadActividades == nul}">
									Ilimitadas
									</c:when>
												<c:otherwise>
									${pase.cantidadActividades}
									</c:otherwise>
											</c:choose></li>
									</ul>
									<c:if test="${sessionScope.estado == 0 && sessionScope.idPase !=5}">
									<div class="row justify-content-center align-items-center p-3 my-3" id="responseError">Su plan ha vencido, puede seleccionar un nuevo Plan.</div>
									</c:if>
									<c:if test="${sessionScope.idPase ==5}">
									<div class="row justify-content-center align-items-center p-3 my-3" id="responseOk">Para inscribirse en un plan vaya la pesta?a Pases.</div>
									</c:if>
								</div>
							</div>


				</div>
			</div>
		</div>

	<%@include file="footerRol.jsp"%>
		
	</div>

	<div class="gototop js-top">
		<a href="#" class="js-gotop"><i class="icon-arrow-up"></i></a>
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

