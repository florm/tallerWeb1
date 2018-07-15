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
		<div class="container">
			<div class="row">
				<div class="col-xs-2">
					<div id="fh5co-logo">
						<a href="index.html">Stamina<span>.</span></a>
					</div>
				</div>
				<div class="col-xs-10 text-right menu-1">
					<ul>
						<!-- menu socio -->
						<li class="active"><a href="<c:url value="/home" />">Inicio</a></li>
						<li><a
							href="<c:url value="/socio/${sessionScope.idSocio}/pases" />">Pases</a></li>
						<li><a
							href="<c:url value="/sucursal/${sessionScope.idSucursal}/actividades?socio=${sessionScope.idSocio}" />">Actividades</a></li>
						<li><a
							href="<c:url value="/beneficios/pase/${sessionScope.idPase}" />">Beneficios</a></li>
						<li class="has-dropdown"><a
							href="#" style="color:  black;">Mi Cuenta</a>
							<ul class="dropdown" style="display: none;">
								<li><a href="<c:url value="/socio/${sessionScope.idSocio}/datospersonales" />">Datos Personales</a></li>
								<li><a href="<c:url value="/socio/${sessionScope.idSocio}/modificardatospersonales" />">Modificar Datos Personales</a></li>
								<li><a href="<c:url value="/socio/${sessionScope.idSocio}/paseactual" />">Pase Actual</a></li>
							</ul></li>

					</ul>
				</div>

			</div>

		</div>
	</div>
</nav>