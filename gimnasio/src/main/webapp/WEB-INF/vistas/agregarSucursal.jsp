<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
		 pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="head.jsp"%>

</head>
<body>

	<div class="fh5co-loader"></div>

	<div id="page">
		<%@include file="menuAdministrador.jsp"%>
		<div class="container mt-3 d-flex justify-content-end align-items-center">
			<a href="<c:url value="/sucursalesadmin" />" class="">
				<i class="fa fa-arrow-left mr-1"></i>
				Volver al listado de sucursales</a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-4 text-center animate-box fadeInUp animated-fast mx-auto">
					
					<div class="modal-body p-5">
					
				      	<form:form class="text-center" method="post" action="nuevaSucursal" modelAttribute="sucursalVacia">
							
						    <div class="form-group input-size">
						        <form:input  path="nombre" type="text" class="form-control" placeholder="Nombre" ></form:input>
						    </div>
						    <div class="form-group input-size">
							    <form:select required="true" path="ciudad.id" id="ciudad.id" name="ciudad.id" cssClass="form-control">
							 		<option value="" selected> Seleccione ciudad..
							 		<c:forEach items= "${listaCiudad}" var="ciudad">
							 			<option value="${ciudad.id}">${ciudad.nombre}	
							 		</c:forEach>
						  		</form:select>
  							</div>						    
						    <div class="form-group input-size">
						        <form:input path="calle" type="text" class="form-control"  placeholder="Calle"></form:input>
						    </div>
						    <div class="form-group input-size">
						        <form:input path="numcalle" type="number" class="form-control" placeholder="Numero"></form:input>
						    </div>
						    <div class="form-group input-size">
						        <form:input path="codPostal" type="text" class="form-control" placeholder="Codigo Postal"></form:input>
						    </div>
						    						    
						    <button type="submit" id="btn-modificar" value="modificar" class="btn btn-primary">Agregar</button>
					    
						</form:form>
      				</div>
						
				</div>	
			</div>
		</div>

	</div>
	<%@include file="archivosjs.jsp"%>
</body>

</html>