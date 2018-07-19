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
				<div class="col-md-5 animate-box fadeInUp animated-fast mx-auto">
	
					
				      	<form:form class="" method="post" action="modificardatos" modelAttribute="sucursalVacia">
							
							<form:input hidden="true" path="id" type="text" class="form-control" value="${sucursal.id}" ></form:input>
							<br><div class="form-group input-size">
						    	Ciudad:
							    <form:select required="true" path="ciudad.id" id="ciudad" name="ciudad.id" cssClass="form-control">
							 		<c:forEach items= "${listaCiudades}" var="ciudad">
								 		<c:choose>
								 			<c:when test="${ciudad.id == sucursal.ciudad.id }">
								 			<option value="${ciudad.id}" selected>${ciudad.nombre}
								 			</c:when>
								 			<c:otherwise>
								 			<option value="${ciudad.id}">${ciudad.nombre}
								 			</c:otherwise>
								 		</c:choose>
							 		</c:forEach>
						  		</form:select>
							</div>
							
						    <div class="form-group input-size">
						        Nombre: <form:input  path="nombre" type="text" class="form-control" value="${sucursal.nombre}" ></form:input>
						    </div>
						    						    
						    <div class="form-group input-size">
						        Calle:<form:input path="calle" type="text" class="form-control"  value="${sucursal.calle}"></form:input>
						    </div>
						    <div class="form-group input-size">
						        Número:<form:input path="numcalle" type="text" class="form-control" value="${sucursal.numcalle}"></form:input>
						    </div>
						    <div class="form-group input-size">
						        Código Postal:<form:input path="codPostal" type="text" class="form-control" value="${sucursal.codPostal}"></form:input>
						    </div>
						    						    
						    <button type="submit" id="btn-modificar" value="modificar" class="btn btn-primary">Modificar</button>
					    
						</form:form>

						
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
