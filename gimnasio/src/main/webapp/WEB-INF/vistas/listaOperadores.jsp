<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="head.jsp" %>

    <script>
        var urlEliminarOperadorController = "<c:url value="/operador/eliminar?operador=" />"
    </script>
</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <%@include file="menuAdministrador.jsp" %>
    <div class="container mt-5 d-flex justify-content-end">
        <a href="<c:url value="/operador/alta" />"
           class="btn btn-primary btn-outline btn-sm">
            Agregar Operador<i class="icon-arrow-right"></i></a>
    </div>
    <div class="container">
        <div class="row p-4">
            <h3>Lista de Operadores</h3>
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
                                <th class="text-center">Apellido</th>
                                <th class="text-center">Sucrusal</th>
                                <th class="text-center">Acciones</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listaOperadores}" var="operador" varStatus="loop">
                                <tr>
                                    <td class="d-none">${operador.id}</td>
                                    <td class="text-center">${operador.nombre}</td>
                                    <td class="text-center">${operador.apellido}</td>
                                    <td class="text-center">${operador.sucursal.nombre}</td>
                                    <td class="text-center" style="width: 20%;">
                                        <a href="<c:url value="/operador/modificar?operador=${operador.id}" />"
                                           class="table-link"
                                           data-toggle="tooltip" data-placement="top" title="Modificar">
                                            <span class="fa-stack">
                                            <i class="fa fa-square fa-stack-2x"></i>
                                            <i class="fa fa-edit fa-stack-1x fa-inverse"></i>
                                            </span>
                                        </a>
                                        <a href="#"
                                           class="table-link abrir-modal-eliminar" data-toggle="modal" data-target="#exampleModal" data-operador-id="${operador.id}">
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
<%--                <a href="<c:url value="/operador/eliminar?operador=${operador.id}" />" class="btn btn-primary">Confirmar</a>--%>
                <a href="#" class="btn btn-primary mb-2" id="linkConfirmar">Confirmar</a>
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

<!-- Main -->
<script src="<c:url value="/js/main.js" />"></script>
<script src="<c:url value="/js/admin.js" />"></script>


</body>

</html>
