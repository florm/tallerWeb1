<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Stamina Gimnasios</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="freehtml5.co"/>
    <link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">

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
    <link href="<c:url value="/css/estilos.css" />" rel="stylesheet">
    <script type="text/javascript">
        var urlPropia = '<c:url value="/actividadesOp/${sessionScope.idSucursal}" />';
    </script>
</head>
<body>
<div class="fh5co-loader"></div>

<div id="page">
    <%@include file="menuOperador.jsp" %>
    <c:if test="${not empty ok}">
        <div class="row d-flex justify-content-center align-items-center p-3 m-3" id="responseOk">${ok}</div>
    </c:if>
    <div class="container">
        <div class="row p-4">
            <h3>Lista de Actividades</h3>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="main-box clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                            <tr>
                                <th class="text-center"><span>Nombre</span></th>
                                <th class="text-center"><span>Profesor</span></th>
                                <th class="text-center"><span>Dia</span></th>
                                <th class="text-center"><span>Horarios</span></th>
                                <th class="text-center"><span>Cupo</span></th>
                                <th class="text-center"><span>Descripción</span></th>
                                <th class="text-center"><span>Modificar</span></th>
                                <th class="text-center"><span>Eliminar</span></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listaSucursalActividades}" var="sucursalActividad">
                                <tr>
                                    <td class="text-center">${sucursalActividad.actividad.nombre}</td>
                                    <td class="text-center">${sucursalActividad.profesor.nombre}</td>
                                    <td class="text-center">${sucursalActividad.dia}</td>
                                    <td class="text-center">${sucursalActividad.horaDesde}hs
                                        a ${sucursalActividad.horaHasta}hs
                                    </td>
                                    <td class="text-center">${sucursalActividad.cupo} max</td>
                                    <td class="text-center">${sucursalActividad.actividad.descripcion}</td>
                                    <td class="text-center"><a
                                            href="<c:url value="/actividadesOp/${sucursalActividad.idSucursalActividad}/modificacionActividad" />"
                                            class="btn btn-primary btn-outline btn-sm">Modificar</a></td>
                                    <td class="text-center"><a
                                            href="<c:url value="/actividadesOp/${sucursalActividad.sucursal.id}/bajaActividad?idSucursalActividad=${sucursalActividad.idSucursalActividad}" />"
                                            class="btn btn-primary btn-outline btn-sm">Baja</a></td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <td>
                            <a href="<c:url value="/actividadesOp/${sessionScope.idSucursal}/nuevaActividadEnSucursal" />"
                               class="btn btn-primary btn-outline btn-sm">Nueva Actividad</a>
                        </td>
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

<!-- Main -->
<script src="<c:url value="/js/main.js" />"></script>

</body>

</html>