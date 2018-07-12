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
		<%@include file="menuAdministrador.jsp"%>
		
		<div class="container">
			<div class="row">
				<div class="col-md-4 text-center animate-box fadeInUp animated-fast mx-auto">
					
					<div class="modal-body p-5">
					
				      	<form:form class="text-center" method="post" action="nuevaSucursal" modelAttribute="sucursalVacia">
							
						    <div class="form-group input-size">
						        <form:input  path="nombre" type="text" class="form-control" value="nombre" ></form:input>
						    </div>
						    <div class="form-group input-size">
							    <form:select required="true" path="ciudad.id" id="ciudad.id" name="ciudad.id" cssClass="form-control">
							 		<option value="" selected> Seleccione ciudad..
							 		<c:forEach items= "${listaCiudad}" var="ciudad">
							 			<option value="${ciudad.id}">${ciudad.nombre}	
							 		</c:forEach>
						  		</form:select>
  							</div>						    
						    <div class="form-group input-size">
						        <form:input path="calle" type="text" class="form-control"  value="calle"></form:input>
						    </div>
						    <div class="form-group input-size">
						        <form:input path="numcalle" type="text" class="form-control" value="numero calle"></form:input>
						    </div>
						    <div class="form-group input-size">
						        <form:input path="codPostal" type="text" class="form-control" value="codigo postal"></form:input>
						    </div>
						    						    
						    <button type="submit" id="btn-modificar" value="modificar" class="btn btn-primary">Agregar</button>
					    
						</form:form>
      				</div>
						
				</div>	
			</div>
		</div>

		<%@include file="footer.jsp"%>
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
