<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>

	<%@include file="head.jsp"%>
</head>
<body>


	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuAdministrador.jsp"%>
		<div class="container mt-5 d-flex justify-content-end">
			<a href="<c:url value="/sucursales" />"
			   class="btn btn-primary btn-outline btn-sm">
				Ver mapa<i class="icon-arrow-right"></i></a>
			<a href="<c:url value="/sucursal/agregarNuevaSucursal" />"
			   class="btn btn-primary btn-outline btn-sm">
				Nueva Sucursal<i class="icon-arrow-right"></i></a>
		</div>
		<div class="container">
			<div class="row p-4">
				<h3>Lista de Sucursales</h3>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="main-box clearfix">
						<div class="table-responsive">
							<table class="table user-list">
								<thead>
								<tr>
									<th class="d-none"><span>Id</span></th>
									<th class="text-center">Nombre</th>
									<th class="text-center">Localidad</th>
									<th class="text-center">Direccion</th>
									<th class="text-center">Codigo Postal</th>
									<th class="text-center">Responsable</th>
									<th class="text-center">Acciones</th>

								</tr>
								</thead>
								<tbody>
								<c:forEach items="${listaSucursales}" var="sucursal" varStatus="loop">
									<tr>
										<td class="d-none">${sucrusal.id}</td>
										<td class="text-center">${sucursal.nombre}</td>
										<td class="text-center">${sucursal.ciudad.nombre}</td>
										<td class="text-center">${sucursal.calle} ${sucursal.numcalle}</td>
										<td class="text-center">${sucursal.codPostal}</td>
										<td class="text-center">${sucursal.operador.nombre} ${sucursal.operador.apellido}</td>
										<td class="text-center" style="width: 20%;">
											<a href="<c:url value="/sucursal/${sucursal.id}/modificar" />" class="table-link"
											   data-toggle="tooltip" data-placement="top" title="Modificar">
														<span class="fa-stack">
														<i class="fa fa-square fa-stack-2x"></i>
														<i class="fa fa-edit fa-stack-1x fa-inverse"></i>
														</span>
											</a>
											<a href="<c:url value="/sucursal/${sucursal.id}/eliminar" />" class="table-link"
											   data-toggle="tooltip" data-placement="top" title="Eliminar">
														<span class="fa-stack">
														<i class="fa fa-square fa-stack-2x"></i>
														<i class="fa fa-trash fa-stack-1x fa-inverse"></i>
														</span>
											</a>
										</td>
									</tr>
								</c:forEach>
								</tbody>
							</table>
						</div>
						<%@include file="paginado.jsp" %>

					</div>
				</div>
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
