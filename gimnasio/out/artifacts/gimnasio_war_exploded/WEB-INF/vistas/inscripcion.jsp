<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Stamina|Inscripcion</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Website Template by freehtml5.co" />
	<meta name="keywords" content="free website templates, free html5, free template, free bootstrap, free website template, html5, css3, mobile first, responsive" />
	<meta name="author" content="freehtml5.co" />

	<link href="https://fonts.googleapis.com/css?family=Work+Sans:300,400,500,700,800" rel="stylesheet">
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">

	<!-- Magnific Popup -->
	<link rel="stylesheet" href="css/magnific-popup.css">

	<!-- Owl Carousel  -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">

	<!-- Theme style  -->
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
		
	<div class="fh5co-loader"></div>
	
	<div id="page">
	<nav class="fh5co-nav" role="navigation">
		<div class="top">
			<div class="container">
				<div class="row">
					<div class="col-xs-12 text-right">
						<p class="num">Call: +01 123 456 7890</p>
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
						<div id="fh5co-logo"><a href="index.html">Stamina<span>.</span></a></div>
					</div>
					<div class="col-xs-10 text-right menu-1">
						<ul>
							<li class="active"><a href="index.html">Inicio</a></li>
							<li><a href="gallery.html">Galería</a></li>
							<li><a href="about.html">Nosotros</a></li>
							<li><a href="pricing.html">Pases</a></li>
							<li><a href="contact.html">Contacto</a></li>
							<li class="has-dropdown">
								<a href="blog.html">Mi Cuenta</a>
								<ul class="dropdown">
									<li><a href="#">Inscripciones</a></li>
									<li><a href="#">Pagos</a></li>
									<li><a href="#">Mi pase</a></li>
									<li><a href="#">Mis datos</a></li>
								</ul>
							</li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</nav>

	</div>

	<div id="fh5co-schedule" class="fh5co-bg" style="background-image: url(images/img_bg_1.jpg);">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center fh5co-heading animate-box">
					<h2>Nueva Inscripción</h2> <br>
					<h5> Seleccione el día y horario de la actividad: </h5>
				</div>
			</div>

			<div class="row animate-box">
				
				<div class="fh5co-tabs">
					<ul class="fh5co-tab-nav">
						<li class="active"><a href="#" data-tab="1"><span class="hidden-xs">Domingo</span></a></li>
						<li><a href="#" data-tab="2"><span class="hidden-xs">Lunes</span></a></li>
						<li><a href="#" data-tab="3"><span class="hidden-xs">Martes</span></a></li>
						<li><a href="#" data-tab="4"><span class="hidden-xs">Miércoles</span></a></li>
						<li><a href="#" data-tab="5"><span class="hidden-xs">Jueves</span></a></li>
						<li><a href="#" data-tab="6"><span class="hidden-xs">Viernes</span></a></li>
						<li><a href="#" data-tab="7"><span class="hidden-xs">Sábado</span></a></li>
					</ul>

					<!-- Tabs -->
					<div class="fh5co-tab-content-wrap">
						<div class="fh5co-tab-content tab-content active" data-tab-content="1">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
								
							</ul>
						</div>

						<div class="fh5co-tab-content tab-content active" data-tab-content="2">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
								
							</ul>
						</div>

						<div class="fh5co-tab-content tab-content active" data-tab-content="3">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
							</ul>
						</div>

						<div class="fh5co-tab-content tab-content active" data-tab-content="4">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
							</ul>
						</div>

						<div class="fh5co-tab-content tab-content active" data-tab-content="5">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
							</ul>
						</div>

						<div class="fh5co-tab-content tab-content active" data-tab-content="6">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
							</ul>
						</div>

						<div class="fh5co-tab-content tab-content active" data-tab-content="7">
							<ul class="class-schedule">
								<li class="text-center">
									<span><img src="images/exercise.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Cardio</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/dumbbell.svg" class="img-responsive" alt=""></span>
									<span class="time">9:00 AM - 11AM</span>
									<h4>Body Building</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/yoga-carpet.svg" class="img-responsive" alt=""></span>
									<span class="time">6:00 AM - 7AM</span>
									<h4>Yoga</h4>
									<small>Angel Adams</small>
								</li>
								<li class="text-center">
									<span><img src="images/two-boxing-gloves.svg" class="img-responsive" alt=""></span>
									<span class="time">7:00 AM - 8AM</span>
									<h4>Boxing</h4>
									<small>Angel Adams</small>
								</li>
							</ul>
						</div>

					</div>

				</div>
			</div>
		</div>
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
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/magnific-popup-options.js"></script>
	<!-- Main -->
	<script src="js/main.js"></script>

	
</body>

</html>
