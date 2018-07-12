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
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">

<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap4.min.css">
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">

<!-- Owl Carousel  -->
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">



<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

<link href="css/fontawesome-all.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">
<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">
</head>
<body>

		<%@include file="menuSinLogin.jsp"%>
		
		<div class="row d-none justify-content-center align-items-center p-3 m-3" id="responseOk"></div>
		<div class="row d-none justify-content-center align-items-center p-3 m-3" id="responseError"></div>
		<div class="container">
			<div class="row">
				<div class="col-md-8 text-center animate-box fadeInUp animated-fast mx-auto">
					
					<div class="modal-body p-5">
					<form:form class="text-center" method="POST" action="registrosocio" modelAttribute="socio" id="registrarSocio">
							
				 			<div class="form-group input-size col-md-6">
						        <form:input required="true" path="usuario.nick" type="text" class="form-control" id="usuarion"  name="usuario.nick" placeholder="Nickname"></form:input>
						    </div>
				 			<div class="form-group input-size col-md-6">
						        <form:input path="usuario.password" type="password" class="form-control" id="passwordn"  name="usuario.password" placeholder="Password"></form:input>
						    </div>
				  		    <div class="form-group input-size col-md-6">
						        <form:input path="nombre" type="text" class="form-control" id="nombre"  name="nombre" placeholder="Nombre"></form:input>
					  	    </div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="apellido" type="text" class="form-control" id="apellido"  name="apellido" placeholder="Apellido"></form:input>
						    </div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="dni" type="number" class="form-control" id="dni"  name="dni" placeholder="D.N.I."></form:input>
						    </div>
					    <div class="form-group input-size col-md-6">
							    <form:select required="true" path="ciudad.id" id="ciudad" name="ciudad.id" cssClass="form-control">
							 		<option value="" selected> Seleccione ciudad..
							 		<c:forEach items= "${listaCiudad}" var="ciudad">
							 			<option value="${ciudad.id}">${ciudad.nombre}	
							 		</c:forEach>
						  		</form:select>
  							</div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="domicilioCalle" type="text" class="form-control" id="domicilioCalle"  name="domicilioCalle" placeholder="Calle"></form:input>
						    </div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="domicilioNumero" type="number" class="form-control" id="domicilioNumero"  name="domicilioNumero" placeholder="Numero"></form:input>
						    </div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="domicilioDepto" type="text" class="form-control" id="domicilioDepto"  name="domicilioDepto" placeholder="Departamento"></form:input>
						    </div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="telefono" type="number" class="form-control" id="telefono"  name="telefono" placeholder="Telefono"></form:input>
						    </div>
						    <div class="form-group input-size col-md-6">
						        <form:input path="mail" type="email" class="form-control" id="mail"  name="mail" placeholder="Mail"></form:input>
						    </div>			
  							 
					    <div class="form-group input-size col-md-6">
						        <form:input path="recomendadoPor.dni" type="number" class="form-control" id="recomendadoPor"  name="recomendadoPor.dni" placeholder="DNI Recomendador"></form:input>
						    </div>
  	
  							 <div class="form-group input-size col-md-12">
							    <form:select required="true" path="sucursal.id" id="sucursal" name="sucursal.id" cssClass="form-control">
							 		<option value="" selected> Seleccione Sucursal..
							 		<c:forEach items= "${listaSucursal}" var="sucursal">
							 			<option value="${sucursal.id}">${sucursal.nombre}	
							 		</c:forEach>
						  		</form:select>
  							</div>
  	
						    <div class="form-group col-md-12">		    
						    <button type="submit" id="btnRegistrar" value="registrar" class="btn btn-primary">Registrar</button>
					    	</div>
					    	
						</form:form>
      				</div>
						
				</div>	
			</div>
		</div>
		<%@include file="footer.jsp"%>
		
	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
	<script src="js/jquery.waypoints.min.js"></script>
	<!-- Stellar Parallax -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>

	<!-- Main -->
	<script src="js/main.js"></script>
	<script src="<c:url value="/js/registro.js" />"></script>
	
</body>

</html>
