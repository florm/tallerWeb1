<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
	<%@include file="head.jsp"%>
</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuAdministrador.jsp"%>

		<div class="container mt-5">
			<table id="socios" class="display"
				   style="width: 100%">
				<thead>
				<tr>
					<td>Nombre</td>
					<td>Apellido</td>
					<td>DNI</td>
					<td>Telefono</td>
					<td>Email</td>
					<td>Localidad</td>
					<td>Calle</td>
					<td>Numero</td>
					<td>Depto</td>
					<td>Pase</td>
				</tr>

				</thead>
				<tbody>
				<c:forEach items="${listaSocios}" var="socio">
					<tr>
						<td>${socio.nombre}</td>
						<td>${socio.apellido}</td>
						<td>${socio.dni}</td>
						<td>${socio.telefono}</td>
						<td>${socio.mail}</td>
						<td>${socio.ciudad.nombre}</td>
						<td>${socio.domicilioCalle}</td>
						<td>${socio.domicilioNumero}</td>
						<td>${socio.domicilioDepto}</td>
						<td>${socio.pase.nombre}</td>

					</tr>
				</c:forEach>

				</tbody>

			</table>
		</div>
	</div>

	<%@include file="archivosjs.jsp"%>
	<script src="<c:url value="/js/datatables.js" />"></script>>
<%--	<script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js" ></script>--%>
	<script src="<c:url value="/js/socios.js" />"></script>

</body>

</html>
