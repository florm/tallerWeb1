<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="fh5co-nav" role="navigation">
	<div class="top">
		<div class="container-fluid">
			<div class="row justify-content-end">
				<div class="col-auto">

					<p class="num">Tel: +01 123 456 7890</p>
					<ul class="fh5co-social">
						<li><a href="#"><i class="icon-twitter"></i></a></li>
						<li><a href="#"><i class="icon-dribbble"></i></a></li>
						<li><a href="#"><i class="icon-github"></i></a></li>
					</ul>
				</div>
				<div class="col-auto ml-auto">
					<p class="num">Bienvenido/a ${sessionScope.nombre}</p>
					<a class="logout" href="<c:url value="/salir"/>">Salir</a>
				</div>
			</div>
		</div>
	</div>
	<div class="top-menu">
		<div class="container-fluid">
			<div class="row justify-content-between menuppal">
				<div class="col-xs-2">
					<div id="fh5co-logo">
						<a href="index.html">Stamina<span>.</span></a>
					</div>
				</div>
				<div class="d-flex menu-1 ml-auto">
					<ul>
						<!-- menu admin -->
						<li class="active"><a href="<c:url value="/homeAdmin" />">Inicio</a></li>
						<li><a href="<c:url value="/actividadesAdmin" />">Actividades</a></li>
						<li><a href="<c:url value="/socios/" />">Socios</a></li>
						<li><a href="<c:url value="/ganancias/" />">Ganancias</a></li>
						<li><a href="<c:url value="/sucursalesadmin/" />">Sucursales</a></li>
						<li><a href="<c:url value="/operadores/" />">Operadores</a></li>
						
					</ul>
				</div>

			</div>

		</div>
	</div>
</nav>