<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<nav class="fh5co-nav" role="navigation">
	<div class="top">
		<div class="container">
			<div class="row justify-content-end">
				<div class="row align-items-center">
					<c:if test="${not empty error}">
						<h4 class="text-center mb-0 mt-2">
							<span>${error}</span>
						</h4>
						<br>
					</c:if>
					<form:form method="post" action="validar-login" class="form-login"
						modelAttribute="usuario">

						<form:input class="form-control-md" path="email" type="text"
							id="email" name="email" placeholder="Email"></form:input>


						<form:input class="form-control-md" path="password"
							type="password" id="password" name="password"
							placeholder="Contraseña"></form:input>

						<button type="submit" id="btn-login">Ingresar</button>

					</form:form>
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
						<li class="active"><a href="<c:url value="/" />">Inicio</a></li>
						<li><a href="<c:url value="pases" />">Pases</a></li>
						<li><a href="<c:url value="/actividades" />">Actividades</a></li>
						<li><a href="<c:url value="/beneficios" />">Beneficios</a></li>

					</ul>
				</div>

			</div>

		</div>
	</div>
</nav>