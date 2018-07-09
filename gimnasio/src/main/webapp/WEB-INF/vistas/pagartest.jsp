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
			<div class="row">
				<div class="col-md-8 text-center animate-box fadeInUp animated-fast mx-auto">
					<div class="modal-body p-5">
						<c:if test="${socio.descuento != null}">
						<div class="row justify-content-center align-items-center p-3 m-3" id="responseOk">Los precios incluyen un descuento del 5% por referidos. Felicidades!</div>
						</c:if>
						<form:form class="text-center" method="post" action="abonarpase" id="" modelAttribute="formulario">
						
						
						    <div class="form-group input-size">
								<form:input readonly="true" path="idSocio" type="text" class="form-control" id="idSocio"  name="nombre" value="${socio.idSocio}" ></form:input>
						    </div>
						    <div class="form-group input-size">
								<form:input readonly="true" path="idSocio" type="text" class="form-control" id="idSocio"  name="nombre" value="${socio.idSocio}" ></form:input>
						    </div>
						    <div class="form-group input-size">

							  	<form:select required="true" path="idDescuento" id="idDescuento" name="idDescuento" cssClass="form-control">
							 		<option value="" selected> Seleccione cantidad de meses..
							 		<c:forEach items= "${listaDescuentos}" var="descuento">
							 			<option value="${descuento.id}">${descuento.meses} Meses (${descuento.descuento}% de Descuento) Precio por mes: $${descuento.importe}
							 		</c:forEach>
						  		</form:select>
							  	
						    </div>
						</form:form>
						
					</div>
				</div>
			</div>
		</div>

	<%@include file="footer.jsp"%>
		
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

