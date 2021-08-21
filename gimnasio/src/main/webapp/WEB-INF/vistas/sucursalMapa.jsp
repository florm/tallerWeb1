<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="head.jsp"%>
</head>
<body>
	<div id="page">
		<c:if test="${empty sessionScope.rol}">
		<%@include file="menuSinLogin.jsp"%>
		</c:if>
		<c:if test="${!empty sessionScope.rol}">
			<%@include file="menuAdministrador.jsp"%>
		</c:if>
		<div class="container mt-3 d-flex justify-content-end align-items-center">
			<a href="<c:url value="/sucursalesadmin" />" class="">
				<i class="fa fa-arrow-left mr-1"></i>
				Volver al listado de sucursales</a>
		</div>
		<div class="container mt-5">
			<div class="justify-content-center mx-5 my-3" id="mapa" style="height:500px;"></div>
		</div>

	</div>
	<%@include file="archivosjs.jsp"%>
	<script src="https://maps.google.com/maps/api/js?key=AIzaSyAYLHM4JlbbKxTvJTHS295NyCFsv5MmW1g"></script>
	<script src="js/mapa.js"></script>

</body>
</html>

