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
<link href="<c:url value="/css/bootstrap4.min.css" />" rel="stylesheet">
<link href="<c:url value="/css/bootstrap.css" />" rel="stylesheet">

<!-- Theme style  -->
<link href="<c:url value="/css/style.css" />" rel="stylesheet">

<link href="<c:url value="/css/datatables.css" />" rel="stylesheet">
<link href="https://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css" />
<link href="<c:url value="/css/MonthPicker.min.css" />" rel="stylesheet" type="text/css" />

<link href="<c:url value="/css/fontawesome-all.css" />" rel="stylesheet">
<link href="<c:url value="/css/estilos.css" />" rel="stylesheet">

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuAdministrador.jsp"%>
		<div class="contenedor-principal">
			<div class="contenedor-fltros p-4 my-3">
				<form class="form-row">
					<div class="form-group col-lg-3 col-md-6 col-sm-6">
						<label for="txtPeriodo">Período</label> 
							<input name="periodo" type="text" id="txtPeriodo" class="form-control" placeholder="Seleccione período">
					</div>

					<div class="form-group col-lg-3 col-md-6 col-sm-6">
						<label for="selSucursal">Sucursal</label>
						<select class="form-control form-control-sm" id="selSucursal">
							<option value="" selected> Seleccione sucursal..
							<c:forEach items="${listaSucursales}" var="sucursal">
								<option value="${sucursal.id}">${sucursal.nombre}
							</c:forEach>
						</select>

					</div>
					<input name="periodoFormat" type="text" id="periodoFormat" hidden="hidden">
				</form>
				
			</div>

			<div class="contenedor-botones d-flex justify-content-end m-2">
				<button id="btnBuscar" class="btn btn-buscar">Calcular</button>
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

	

	<script src="<c:url value="/js/datatables.js" />"></script>
	<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <script src="https://cdn.rawgit.com/digitalBush/jquery.maskedinput/1.4.1/dist/jquery.maskedinput.min.js"></script>
	<script src="<c:url value="/js/MonthPicker.min.js" />"></script>
	
<!-- Main -->
	<script src="<c:url value="/js/main.js" />"></script>
	<script src="<c:url value="/js/home.js" />"></script>
	<script src="<c:url value="/js/ganancias.js" />"></script>

</body>

</html>


