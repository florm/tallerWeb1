<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>

    <%@include file="head.jsp"%>
	<script type="text/javascript">
		var urlPropia = '<c:url value="/homeOperador/${sessionScope.idSucursal}" />';
	</script>

</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <%@include file="menuOperador.jsp" %>
    <div class="container">
        <div class="row p-4">
            <h3>Lista de Socios</h3>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="main-box clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                            <tr>
                                <th class="text-center"><span>Nombre</span></th>
                                <th class="text-center"><span>Apellido</span></th>
                                <th class="text-center"><span>DNI</span></th>
                                <th class="text-center"><span>Teléfono</span></th>
                                <th class="text-center"><span>Email</span></th>
                                <th class="text-center"><span>Localidad</span></th>
                                <th class="text-center"><span>Calle</span></th>
                                <th class="text-center"><span>Número</span></th>
                                <th class="text-center"><span>Dpto</span></th>
                                <th class="text-center"><span>Pase</span></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${listaSocios}" var="socio" varStatus="socios">
                                <tr>
                                    <td class="text-center">${socio.nombre}</td>
                                    <td class="text-center">${socio.apellido}</td>
                                    <td class="text-center">${socio.dni}</td>
                                    <td class="text-center">${socio.telefono}</td>
                                    <td class="text-center">${socio.mail}</td>
                                    <td class="text-center">${socio.ciudad}</td>
                                    <td class="text-center">${socio.domicilioCalle}</td>
                                    <td class="text-center">${socio.domicilioNumero}</td>
                                    <td class="text-center">${socio.domicilioDepto}</td>
                                    <td class="text-center">${socio.pase}</td>
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

<!-- Main -->
<script src="<c:url value="/js/main.js" />"></script>

<script src="<c:url value="/js/home.js" />"></script>


</body>

</html>
