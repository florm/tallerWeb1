<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<nav class="fh5co-nav" role="navigation">
	<div class="top">
		<div class="container">
			<div class="row justify-content-end">
				<div class="col-auto">
					<a href="<c:url value="/salir"/>">Salir</a>
					<p class="num">Bienvenido/a ${sessionScope.nombre}</p>
				</div>
				<div class="col-auto">

					<p class="num">Tel: +01 123 456 7890</p>
					<ul class="fh5co-social">
						<li><a href="#"><i class="icon-twitter"></i></a></li>
						<li><a href="#"><i class="icon-dribbble"></i></a></li>
						<li><a href="#"><i class="icon-github"></i></a></li>
					</ul>
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
				<div class="d-flex menu-1">
					<ul>
						<!-- menu admin -->
						<li class="active"><a href="<c:url value="/homeAdmin" />">Inicio</a></li>
						<li><a href="<c:url value="/actividadesOp/${sessionScope.idSucursal}" />">Actividades</a></li>
												
					</ul>
				</div>

			</div>

		</div>
	</div>
</nav>