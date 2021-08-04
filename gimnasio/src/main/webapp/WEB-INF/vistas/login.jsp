<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Stamina Gimnasios</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="author" content="freehtml5.co"/>


    <link
            href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800"
            rel="stylesheet">

    <!-- Animate.css -->
    <link rel="stylesheet" href="css/animate.css">
    <!-- Icomoon Icon Fonts-->
    <link rel="stylesheet" href="css/icomoon.css">

    <!-- Bootstrap  -->
    <link rel="stylesheet" href="css/bootstrap4.min.css">
    <link rel="stylesheet" href="css/bootstrap.css">

    <!-- Magnific Popup -->
    <link rel="stylesheet" href="css/magnific-popup.css">

    <!-- Owl Carousel  -->
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">


    <!-- Modernizr JS -->
    <script src="js/modernizr-2.6.2.min.js"></script>
    <!-- FOR IE9 below -->
    <!--[if lt IE 9]>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <link href="css/fontawesome-all.css" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet">
    <!-- Theme style  -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="fh5co-loader"></div>

<div id="page">
    <%@include file="menuSinLogin.jsp" %>

    <header id="fh5co-header" class="fh5co-cover" role="banner"
            style="background-image: url(images/img_banner.jpg);"
            data-stellar-background-ratio="0.3">
        <div class="overlay"></div>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center d-flex">
                    <div class="display-t col-md-8">
                        <div class="display-tc animate-box" data-animate-effect="fadeIn">
                            <h1>
                                Un estilo de vida, <br> no un deber.
                            </h1>
                            <h2>La cadena de gimnasios más grande de Buenos Aires</h2>
                        </div>
                    </div>
                    <div class="display-t div-login col-md-3">
                        <div class="display-tc animate-box " data-animate-effect="fadeIn">
                            <h3>Ingresar al sitio</h3>
                            <form:form method="post" action="validar-login"
                                       class="form-login d-flex flex-column align-items-center"
                                       modelAttribute="usuario">
                                <div class="form-group col-md-12">
                                    <form:input class="form-control form-control-sm" path="nick" type="text"
                                                id="nick" name="nick" placeholder="Nickname"></form:input>
                                </div>
                                <div class="form-group col-md-12">
                                    <form:input class="form-control form-control-sm" path="password"
                                                type="password" id="password" name="password"
                                                placeholder="Contraseña"></form:input>
                                </div>
                                <c:if test="${not empty error}">
                                    <div class="text-center">
                                        <span class="loginError">${error}</span>
                                    </div>
                                    <br>
                                </c:if>
                                <button type="submit" class="btn btn-primary col-md-11">Login</button>
                            </form:form>
                            <div class="div-registro">
                                <p>
                                    <a class="btn btn-primary" href="registrar">Registrarme</a>
                                </p>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </header>
    <%@include file="footer.jsp" %>
    <!-- modal login -->
    <!-- <div class="modal fade login" id="modal-login" role="dialog" tabindex="-1">
  <div class="modal-dialog modal-md">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Iniciar sesion</h4>
        <button class="close" aria-label="Close" data-dismiss="modal" ,="" type="button">
          <span aria-hidden="true">�</span>
        </button>
        
      </div>
      <div class="modal-body p-5">
	      <form:form class="text-center" method="post" action="validar-login" id="form-login" modelAttribute="usuario">
		    <div class="form-group input-size">
		        <form:input path="nick" type="text" class="form-control" id="nick"  name="nick" placeholder="Nickname"></form:input>
		    </div>
		    <div class="form-group input-size">
		        <form:input path="password" type="password" class="form-control" id="password" name="password" placeholder="Contrase�a"></form:input>
		    </div>
		    <div id="divLoginErroneo" class="alert alert-danger-custom" role="alert" hidden="hidden">
		        ${error}
		    </div>
		
		    <button type="submit" id="btn-login" value="Ingresar" class="btn btn-primary"></button>
		    <div class="text-center">
		        <span>A�n no est� registrado?</span>
		        <a href="usuario/registrar">Registrarse</a>
		    </div>
		</form:form>
      	
      </div>
    </div>
  </div>
</div>-->
</div>

<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!-- jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!-- Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!-- Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<!-- Stellar Parallax -->
<script src="js/jquery.stellar.min.js"></script>
<!-- Carousel -->
<script src="js/owl.carousel.min.js"></script>
<!-- countTo -->
<script src="js/jquery.countTo.js"></script>

<!-- Main -->
<script src="js/main.js"></script>


</body>

</html>
