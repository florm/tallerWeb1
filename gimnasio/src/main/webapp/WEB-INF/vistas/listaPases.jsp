<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gimnasio</title>
<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
<!-- DataTables CSS -->
   <link href="css/dataTables.bootstrap4.css" rel="stylesheet" >
   
</head>
<body>

Lista de Pases
<table id="pases" class="table table-striped table-bordered" style="width:100%">
	<thead>
		<tr>
			<td>Nombre</td>
			<td>Cantidad de Actividades Disponibles</td>
			<td>Precio</td>
		</tr>
	
	</thead>
	<tbody>
		<c:forEach items="${listaPases}" var="pase">
			<tr>
				<td>${pase.nombre}</td>
				<c:choose>
				    <c:when test="${pase.cantidadActividades == null}">
				         <td>Ilimitadas</td>
				    </c:when>    
				    <c:otherwise>
				        <td>${pase.cantidadActividades}</td>
				        
				    </c:otherwise>
				</c:choose>
				<td>$ ${pase.precio}</td>
			</tr>
		</c:forEach>
	
	</tbody>

</table>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="js/bootstrap.min.js" ></script>

<!-- datatable-->
 <script type="text/javascript" src="js/datatables.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap4.js"></script>

<script type="text/javascript" src="js/pases.js"></script>

</body>
</html>