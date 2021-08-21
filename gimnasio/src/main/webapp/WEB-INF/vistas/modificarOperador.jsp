<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="head.jsp" %>


</head>
<body>

<%@include file="menuAdministrador.jsp" %>
<div class="container mt-3 d-flex justify-content-end align-items-center">
    <a href="<c:url value="/operadores" />" class="">
        <i class="fa fa-arrow-left mr-1"></i>
        Volver al listado de operadores</a>
</div>
<div class="container">
    <div class="row d-flex flex-column">
        <div class="col-md-8 text-center animate-box fadeInUp animated-fast mx-auto">

            <div class="modal-body p-5">
                <form:form class="text-center" method="POST" action="modificarOperador" modelAttribute="operador">

                    <form:input hidden="true" path="id" name="id" type="text" class="form-control"
                                value="${operador.id }"></form:input>
                    <form:input hidden="true" path="usuario.id" name="usuario.id" type="text" class="form-control"
                                value="${operador.usuario.id }"></form:input>
                    <div class="form-group input-size">
                        <form:input readonly="true" path="nombre" name="nombre" type="text" class="form-control"
                                    value="${operador.nombre }"></form:input>
                    </div>
                    <div class="form-group input-size">
                        <form:input readonly="true" path="apellido" name="apellido" type="text" class="form-control"
                                    value="${operador.apellido}"></form:input>
                    </div>
                    <div class="form-group input-size">

                        <form:select required="true" path="sucursal.id" cssClass="form-control">
                        <option value="" selected> Seleccione sucursal..
                            <c:forEach items="${listaSucursales}" var="sucursal">
                            <c:choose>
                                <c:when test="${sucursal.id == operador.sucursal.id }">
                                    <option value="${sucursal.id}" selected>${sucursal.nombre}
                                </c:when>
                                <c:otherwise>
                                    <option value="${sucursal.id}">${sucursal.nombre}
                                </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            </form:select>
                    </div>

                    <div class="form-group col-md-12">
                        <button type="submit" id="btnModificar" value="modificar" class="btn btn-primary">Modificar
                        </button>
                    </div>

                </form:form>
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


</body>

</html>
