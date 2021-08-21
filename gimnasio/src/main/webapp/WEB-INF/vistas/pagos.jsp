<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@include file="head.jsp"%>
    <!-- Animate.css -->
    <link href="<c:url value="/css/animate.css" />" rel="stylesheet">

    <link href="<c:url value="/css/pagos.css" />" rel="stylesheet">

	<script type="text/javascript">
		var urlPropia = '<c:url value="/ver-pagos" />';
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
            <h3>Lista de Pagos</h3>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <div class="main-box clearfix">
                    <div class="table-responsive">
                        <table class="table user-list">
                            <thead>
                            <tr>
                                <th class="d-none"><span>Id</span></th>
                                <th><span>Socio</span></th>
                                <th class="text-center"><span>Importe</span></th>
                                <th class="text-center"><span>Fecha</span></th>
                                <th class="text-center"><span>Estado</span></th>
                                <th class="text-center"><span>Aprobar pago</span></th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${pagos}" var="pago" varStatus="loop">
                                <tr>
                                    <td class="d-none">${pago.id}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${loop.index % 2 == 0}">
                                                <img src="https://bootdey.com/img/Content/avatar/avatar3.png" alt="">
                                            </c:when>
                                            <c:otherwise>
                                                <img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
                                            </c:otherwise>
                                        </c:choose>
                                        <a href="#" class="user-link">${pago.socio}</a>
                                    </td>
                                    <td class="text-center">${pago.importe}</td>
                                    <td class="text-center">${ pago.fecha}</td>
                                    <td class="text-center">
                                        <span class="label ${pago.estado}">${pago.estado}</span>
                                    </td>
                                    <c:choose>
                                        <c:when test="${pago.estadoId == 2}">
                                            <td class="text-center" style="width: 20%;">
                                                <a href="<c:url value="/aprobar-pago/${pago.id}" />" class="table-link"
                                                   data-toggle="tooltip" data-placement="top" title="Aprobar pago">
														<span class="fa-stack">
														<i class="fa fa-square fa-stack-2x"></i>
														<i class="fa fa-check-circle fa-stack-1x fa-inverse"></i>
														</span>
                                                </a>
                                            </td>
                                        </c:when>
                                        <c:otherwise>
                                            <td></td>
                                        </c:otherwise>
                                    </c:choose>
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

<!-- Main -->
<script src="<c:url value="/js/main.js" />"></script>

</body>

</html>