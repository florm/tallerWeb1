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
			<div class="row">
			<div class="col-md-5 animate-box fadeInUp animated-fast mx-auto"><br>
				<form:form class="" method="post" action="modificardatossocio" id="" modelAttribute="socio">
							
					<div class="form-group input-size">
				       Username:<form:input readonly="true" path="usuario.nick" type="text" class="form-control" id="nick"  name="usuario.nick" value="${socio.usuario.nick}"></form:input>
				    </div>
				    <div class="form-group input-size">
				        Nombre:<form:input readonly="true" path="nombre" type="text" class="form-control" id="nombre"  name="nombre" value="${socio.nombre}" ></form:input>
				    </div>
				    <div class="form-group input-size">
				        Apellido:<form:input readonly="true" path="apellido" type="text" class="form-control" id="apellido"  name="apellido" value="${socio.apellido}" ></form:input>
				    </div>
				    <div class="form-group input-size">
				        DNI:<form:input readonly="true" path="dni" type="text" class="form-control" id="dni"  name="dni" value="${socio.dni}"></form:input>
				    </div>
				    <div class="form-group input-size">
				        Telefono:<form:input path="telefono" type="text" class="form-control" id="telefono"  name="telefono" value="${socio.telefono}"></form:input>
				    </div>
				    <div class="form-group input-size">
				        Email:<form:input path="mail" type="email" class="form-control" id="mail"  name="mail" value="${socio.mail}"></form:input>
				    </div>
				    <div class="form-group input-size">
				    	Ciudad:
					    <form:select required="true" path="ciudad.id" id="ciudad" name="ciudad.id" cssClass="form-control">
					 		<c:forEach items= "${listaCiudad}" var="ciudad">
						 		<c:choose>
						 			<c:when test="${ciudad.id == socio.ciudad.id }">
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
				        Calle:<form:input path="domicilioCalle" type="text" class="form-control" id="domicilioCalle"  name="domicilioCalle" value="${socio.domicilioCalle}"></form:input>
				    </div>
				    <div class="form-group input-size">
				        Numero:<form:input path="domicilioNumero" type="number" class="form-control" id="domicilioNumero"  name="domicilioNumero" value="${socio.domicilioNumero}"></form:input>
				    </div>
				    <div class="form-group input-size">
				        Departamento:<form:input path="domicilioDepto" type="text" class="form-control" id="domicilioDepto"  name="domicilioDepto" value="${socio.domicilioDepto}"></form:input>
				    </div>
					
				    
				    <button type="submit" id="btn-modificar" value="modificar" class="btn btn-primary">Modificar</button>
			    
				</form:form>
			</div>
					
				<!-- <div class="col-md-5 text-center animate-box fadeInUp animated-fast mx-auto">
					
					
					
				  	<div class="modal-body p-5">
					
				      	
      				</div>
					
				</div>	-->	
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