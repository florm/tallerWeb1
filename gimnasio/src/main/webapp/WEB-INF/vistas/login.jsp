<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <link href="css/estilos.css" rel="stylesheet">
	</head>
	<body>
		<div class="container-fluid mt-5">
			<div id="loginbox" class="mainbox d-flex flex-column justify-content-center">
				
				
					
				<form id="usuario" class="d-flex flex-column justify-content-center align-items-center" action="./usuario/login" method="post">
				    <p class="header-formulario">Bienvenido</p>
				    <p class="subheader-formulario">Login</p>
				    <div class="form-group input-size">
				        <input id="username" name="email" placeholder="Usuario" type="text" class="form-control" value="">
				    </div>
				    <div class="form-group input-size">
				        <input id="password" name="password" placeholder="Contraseña" type="password" class="form-control" value="">
				    </div>
				    <button class="btn-login" type="Submit">Login</button>			
				    <div class="text-center p-2 m-1">
				        <span>Aún no está registrado?</span>
				        <a href="#">Registrarse</a>
				    </div>
				</form> 
				
				
					
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
