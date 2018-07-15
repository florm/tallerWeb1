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

<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap4.min.css">
<link rel="stylesheet" href="css/bootstrap.css">

<!-- Theme style  -->
<link rel="stylesheet" href="css/style.css">

<link href="<c:url value="/css/datatables.css" />" rel="stylesheet">

<link href="css/fontawesome-all.css" rel="stylesheet">
<link href="css/estilos.css" rel="stylesheet">

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuAdministrador.jsp"%>
		<label style="display: block;text-align: center;line-height: 150%; font-size: .85em; margin-top: 30px;">
		Seleccione sobre que sucursal desea modificar y eliminar actividades</label> 
		<div class="container mt-5">
			<table id="sucursales" class="table table-striped table-bordered" style="width:100%">
				<thead>
					<tr>
						<td>Nombre</td>
						<td>Localidad</td>
						<td>Direccion</td>
						<td>Codigo Postal</td>
						<td>Responsable</td>
						<td>Acciones</td>
					</tr>
				
				</thead>
				<tbody>
					<c:forEach items="${listaSucursales}" var="sucursal">
						<tr>
							<td>${sucursal.nombre}</td>
							<td>${sucursal.ciudad.nombre}</td>
							<td>${sucursal.calle} ${sucursal.numcalle}</td>
							<td>${sucursal.codPostal}</td>
							<td>${sucursal.operador.nombre} ${sucursal.operador.apellido}</td>
							<td><a href="<c:url value="/${sucursal.id}/listaActividadesSucursal" />" class="btn btn-primary btn-outline btn-sm">Ir <i class="icon-arrow-right"></i></a></td>
						</tr>
					</c:forEach>
				
				</tbody>
			
			</table>
			<td><a href="<c:url value="/actividad/nuevaActividadEnSucursal" />" class="btn btn-primary btn-outline btn-sm">Nueva Actividad En Sucursal</i></a></td>
			<td><a href="<c:url value="/actividad/nuevaActividad" />" class="btn btn-primary btn-outline btn-sm">Nueva Actividad General</i></a></td>
		</div>	
	</div>


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

	<script src="<c:url value="/js/datatables.js" />"></script>
	<!-- Main -->
	<script src="js/main.js"></script>
	
	<script src="<c:url value="/js/sucursales.js" />"></script>
	<script src="js/home.js"></script>

</body>

</html>
