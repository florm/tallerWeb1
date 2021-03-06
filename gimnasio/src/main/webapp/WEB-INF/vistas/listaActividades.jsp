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
		
		<c:if test="${sessionScope.estado == 0}"> <!-- Si el pase es 5 aparecerá esta leyenda -->
		
		<div class="container">
			<br><div class="col-md-8 col-md-offset-2 text-center">
						<div class="display-t">
							<div class="display-tc" data-animate-effect="fadeIn">
								<h1>
									No hay actividades disponibles <br> 
								</h1>
								<h2>Necesita abonar un pase para poder inscribirse a las distintas actividades.</h2>
							</div>
						</div>
					</div>
			</div>
		</c:if>
		<div class="row d-none justify-content-center align-items-center p-3 m-3" id="responseOk"></div>
		<div class="row d-none justify-content-center align-items-center p-3 m-3" id="responseError"></div>
		<div class="container">
			
			<c:if test="${sessionScope.estado != 0}"> <!-- El pase de ID 5 es el que se utiliza por defecto en un usuario recien registrado, no posee actividades disponibles -->
			<div class="row">
				<c:forEach items="${listaActividades}" var="lista">
					<div
						class="col-md-4 text-center animate-box fadeInUp animated-fast">
						<div class="services">
							<h3>${lista.actividad.nombre}</h3>
							<h4>Cupo Máximo ${lista.cupo} personas</h4>
							<h4>Cupo Actual ${lista.cupoActual}/${lista.cupo} personas</h4>
							<span class="time">${lista.dia} de ${lista.horaDesde} a
								${lista.horaHasta} hs</span>
							<p>Profesor a cargo:</p>
							<label>${lista.profesor.nombre}
								${lista.profesor.apellido}</label>
							<c:url var="post_url" value="/registrarActividad" />
							<form:form action="${post_url}" method="post" modelAttribute="formularioInscripcion"
								>
								<form:input path="idSocio" name="idSocio"
									value="${sessionScope.idSocio}" hidden="hidden"></form:input>
								<form:input path="idSucursalActividad"
									name="idSucursalActividad" value="${lista.idSucursalActividad}"
									hidden="hidden"></form:input>
								<form:input path="idSucursal" name="idSucursal"
									value="${sessionScope.idSucursal}" hidden="hidden"></form:input>
									
								<c:forEach items="${lista.socios}" var="socio">
										
										<c:if test="${socio.idSocio == sessionScope.idSocio}">
											<c:set var="idNoDisponible" value="${lista.idSucursalActividad }"></c:set>
										</c:if>
								</c:forEach>
								<p>
								
								<c:choose>
									
									<c:when test="${lista.cupoActual == lista.cupo || validarPase == false || lista.idSucursalActividad == idNoDisponible }">
										<button disabled="disabled" type="submit"
											class="btn btn-primary btn-outline btn-sm">
											Inscribirse <i class="icon-arrow-right"></i>
										</button><br>
									<c:if test="${lista.cupoActual == lista.cupo}"><p class="pmensaje">-Esta actividad se encuentra llena</p></c:if>
									<c:if test="${validarPase == false}"><p class="pmensaje">- Alcanzó el máximo de actividades por pase.</p></c:if>
									<c:if test="${lista.idSucursalActividad == idNoDisponible}"><p class="pmensaje">- Ya se encuentra inscripto en esta actividad.</p></c:if>
									</c:when> 
									<c:otherwise>
									<button 
										class="btn btn-primary btn-outline btn-sm btninscribir">
										Inscribirse <i class="icon-arrow-right"></i>
									</button>
									</c:otherwise>
								</c:choose>
								</p>
								
							</form:form>

						</div>
					</div>
				</c:forEach>
			
			</div></c:if>
			
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
	<script src="<c:url value="/js/actividades.js" />"></script>
</body>

</html>
