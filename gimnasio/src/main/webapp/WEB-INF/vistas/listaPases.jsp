<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>

<title>Stamina Gimnasios</title>
<meta name="viewport" content="width=device-width, initial-scale=1">


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
			<c:if test="${sessionScope.estado == 0 && sessionScope.idPase !=5}">
				<div class="row justify-content-center align-items-center p-3 my-3" id="responseError">Su ${pase.nombre} ha vencido, puede seleccionar un nuevo Pase.</div>
			</c:if>
			<c:if test="${sessionScope.estadoPago != null && sessionScope.estadoPago != 1}">
				<div class="row justify-content-center align-items-center p-3 my-3" id="responseError">El pago de su ${pase.nombre} aún no ha sido aprobado</div>
			</c:if>
			<div class="row animate-box fadeInUp animated-fast">
				<div class="col-md-8 col-md-offset-2 text-center">
					<h2>Pases</h2>
					<p>Elige un plan:</p>
				</div>
			</div>
			<div class="row">
			
				
			
				<div class="pricing">
					<c:forEach items="${listaPases}" var="lista">
						<c:if test="${lista.id !=5  }">
							<div class="col-md-3 animate-box fadeInUp animated-fast">
								<div class="price-box">
									<h2 class="pricing-plan">${lista.nombre}</h2>
									<div class="price">
										<sup class="currency">$</sup>${lista.precio}<small>mensual</small>
									</div>
									<ul class="classes">
										
										<li class="color">Cantidad de Beneficios: ${fn:length(lista.listaBeneficios)}</li>
										<li>Cantidad de actividades: <c:choose>
												<c:when test="${lista.cantidadActividades == nul}">
									Ilimitadas
									</c:when>
												<c:otherwise>
									${lista.cantidadActividades}
									</c:otherwise>
											</c:choose></li>
									</ul>
									<c:if test="${empty sessionScope.idSocio}">
										<a href="<c:url value="registrar"/>" class="btn btn-select-plan btn-sm">Registrarse</a>
									</c:if>
									<!--<c:if test="${!empty sessionScope.idSocio}">
										<a href="<c:url value="/pago/socio/${sessionScope.idSocio}/pase/${lista.id}" />" class="btn btn-select-plan btn-sm">Seleccionar Pase</a>
									</c:if>
									<c:if test="${sessionScope.estado == 0}">
										<a href="<c:url value="/pago/socio/${sessionScope.idSocio}/pase/${lista.id}" />" class="btn btn-select-plan btn-sm">Seleccionar Pase</a>
									</c:if>-->
																
									<c:if test="${sessionScope.estado == 0}">
										<a href="<c:url value="/pago/socio/${sessionScope.idSocio}/pase/${lista.id}" />" class="btn btn-select-plan btn-sm">Seleccionar Pase</a>
									</c:if>
									
								</div>
							</div>
						</c:if>
					</c:forEach>

				</div>
			</div>
		</div>

	<c:if test="${empty sessionScope.rol}">
		<%@include file="footerRol.jsp"%>
		</c:if>
		<c:if test="${!empty sessionScope.rol}">
			<%@include file="footer.jsp"%>
		</c:if>

		
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

