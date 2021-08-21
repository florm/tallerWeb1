<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page pageEncoding="UTF-8" %>

<!DOCTYPE HTML>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
	<%@include file="head.jsp"%>
	<script>
		var urlBaseEliminarController = "<c:url value="/actividadesAdmin"/>"
	</script>
</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuAdministrador.jsp"%>
		<div class="container mt-5 d-flex justify-content-end">
			<a href="<c:url value="/actividadesAdmin/nuevaActividad" />"
			   class="btn btn-primary btn-outline btn-sm">
				Agregar Actividad<i class="icon-arrow-right"></i></a>
		</div>
		<div class="container mt-5">
			<div class="row p-4">
				<h3>Lista de Actividades</h3>
			</div>
			<table id="actividades" class="table table-striped table-bordered" style="width:100%">
				<thead>
					<tr>
						<td>Nombre</td>
						<td>Descripcion</td>			
						<td>Acciones</td>

					</tr>
				
				</thead>
				<tbody>
					<c:forEach items="${listaActividades}" var="actividad">
						<tr>
							<td>${actividad.nombre}</td>
							<td>${actividad.descripcion}</td>
							<td class="text-center" style="width: 20%;">
								<a href="<c:url value="/actividadesAdmin/${actividad.id}/modificarActividad" />"
								   class="table-link"
								   data-toggle="tooltip" data-placement="top" title="Modificar">
                                            <span class="fa-stack">
                                            <i class="fa fa-square fa-stack-2x"></i>
                                            <i class="fa fa-edit fa-stack-1x fa-inverse"></i>
                                            </span>
								</a>
								<a href="#"
								   class="table-link abrir-modal-eliminar" data-toggle="modal" data-target="#exampleModal" data-actividad-id="${actividad.id}">
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
	</div>
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Confirmar eliminación</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<p>¿Está seguro de que desea eliminar el registro?</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
					<a href="#" class="btn btn-primary mb-2" id="linkConfirmar">Confirmar</a>
				</div>
			</div>
		</div>
	</div>
	<%@include file="archivosjs.jsp"%>
	<script src="<c:url value="/js/datatables.js" />"></script>>
	<script src="<c:url value="/js/actividadesadmin.js" />"></script>>

</body>

</html>