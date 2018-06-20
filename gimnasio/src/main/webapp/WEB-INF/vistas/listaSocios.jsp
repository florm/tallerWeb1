<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gimnasio</title>
</head>
<body>

Lista de Usuarios
<form action="">
  	<select>
 	
 		<c:forEach items= "${listaSocios}" var="socio">
 			<option value="${socio.idSocio}">${socio.nombre}	
 		</c:forEach>
  	</select> 
</form>

</body>
</html>