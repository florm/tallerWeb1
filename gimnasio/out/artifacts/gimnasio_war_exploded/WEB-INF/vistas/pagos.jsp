<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
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
	<link href="<c:url value="/css/pagos.css" />" rel="stylesheet">

<!-- Modernizr JS -->
<script src="<c:url value="/js/modernizr-2.6.2.min.js" />"></script>

<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="<c:url value="/js/respond.min.js" />"></script>
	<![endif]-->

<%--<link href="<c:url value="/css/fontawesome-all.css" />" rel="stylesheet">--%>
<link href="<c:url value="/css/estilos.css" />" rel="stylesheet">

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuOperador.jsp"%>
		<c:if test="${not empty ok}">
			<div class="row d-flex justify-content-center align-items-center p-3 m-3" id="responseOk">${ok}</div>
		</c:if>
		<div class="container">
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
								<c:forEach items="${pagos}" var="pago">
									<tr>
										<td class="d-none">${pago.id}</td>
										<td>
											<img src="https://bootdey.com/img/Content/avatar/avatar1.png" alt="">
											<a href="#" class="user-link">${pago.socio}</a>
<%--											<span class="user-subhead">Admin</span>--%>
										</td>
										<td class="text-center">${pago.importe}</td>
										<td class="text-center">${ pago.fecha}</td>
										<td class="text-center">
											<span class="label ${pago.estado}">${pago.estado}</span>
										</td>
										<c:choose>
											<c:when test="${pago.estadoId == 2}">
												<td class="text-center" style="width: 20%;">
													<a href="<c:url value="/aprobar-pago/${pago.id}" />" class="table-link" data-toggle="tooltip" data-placement="top" title="Aprobar pago">
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
						<ul class="pagination pull-right">
							<c:choose>
								<c:when test="${paginado.paginaActual == 1}">
									<li><a class="page-link prev isDisabled" href="#"><i class="fa fa-chevron-left"></i></a></li>
								</c:when>
								<c:otherwise>
									<li><a class="page-link prev" href="#"><i class="fa fa-chevron-left"></i></a></li>
								</c:otherwise>
							</c:choose>

							<c:forEach begin="1" step="1" end="${paginado.paginasTotales}" varStatus="loop">
								<c:choose>
									<c:when test="${paginado.paginaActual == loop.index}">
										<li class="paginate_button page-item active">
											<a numeroDePagina="${loop.index}" class= "page-link" href="<c:url value='/ver-pagos?numeroPagina=${loop.index}'/>">${loop.index}</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="paginate_button page-item">
											<a class= "page-link" href="<c:url value='/ver-pagos?numeroPagina=${loop.index}'/>">${loop.index}</a>
										</li>
									</c:otherwise>
								</c:choose>

							</c:forEach>
							<c:choose>
								<c:when test="${paginado.paginaActual == paginado.paginasTotales}">
									<li><a class="page-link next isDisabled" href="#"><i class="fa fa-chevron-right"></i></a></li>
								</c:when>
								<c:otherwise>
									<li><a class="page-link next" href="#"><i class="fa fa-chevron-right"></i></a></li>
								</c:otherwise>
							</c:choose>

						</ul>
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