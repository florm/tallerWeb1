<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page pageEncoding="UTF-8" %>
<nav class="fh5co-nav" role="navigation">
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
						<li class="active"><a href="<c:url value="/" />">Inicio</a></li>
						<li><a href="<c:url value="pases" />">Pases</a></li>
						<li><a href="<c:url value="/actividades" />">Actividades</a></li>
						<li><a href="<c:url value="/sucursales" />">Sucursales</a></li>
						<li><a href="<c:url value="/beneficios" />">Beneficios</a></li>
						<li><a href="<c:url value="/registrar" />">Registrate</a></li>
					</ul>
				</div>

			</div>

		</div>
	</div>
</nav>