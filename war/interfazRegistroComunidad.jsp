<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Interfaz nueva comunidad</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />



<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- // <script type="text/javascript" src="JS/navbarJS.js"></script> -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="JS/interfazregistrocomunidadJS.js" />
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
<link href="estiloindex/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="estiloindex/css/freelancer.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<!-- // <script type="text/javascript" src="estiloindex/js/freelancer.js"></script>   -->
<script type="text/javascript" src="estiloindex/js/contact_me.js"></script>
<script type="text/javascript"
	src="estiloindex/js/jqBootstrapValidation.js"></script>
<script type="text/javascript" src="estiloindex/js/cbpAnimatedHeader.js"></script>
<script type="text/javascript" src="estiloindex/js/classie.js"></script>
<script type="text/javascript" src="JS/interfazregistroJS.js"></script>

<!-- Custom Fonts -->
<link href="estiloindex/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link
	href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
							<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
							<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
			<![endif]-->


</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse" aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/index">AMIGO INVISIBLE</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav ">
				<li class="page-scroll"><a href="/comunidades">Mis
						comunidades</a></li>
				<li class="page-scroll"><a href="interfazmicuenta.html">Mi
						cuenta</a></li>
				<li class="page-scroll"><a href="interfazcambiarpassword.html">Cambiar
						contraseña</a></li>
				<li class="page-scroll"><a href="/salir">Salir</a></li>

			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>
	<section id="about">
	<div class="container text-center">
		</br>
		<h2>Registro de una Nueva comunidad</h2>
		<form action="/registrarComunidad" onsubmit="return confirmarCampos()">

			<h1>Nombre de la comunidad</h1>
			<input type="text" name="nombre_comunidad" required />
			<h3>Contraseña de su comunidad</h3>
			<p>Con esta contraseña sus amigos podran unirse a su comunidad</p>
			<input type="password" name="pass_comunidad" required />
			<p>Confirme contraseña</p>
			<input type="password" name="pass_comunidad2" required />

			<h1>Participantes</h1>
			<p>Introduzca los nombres de usuario de sus amigos</p>
			<div id="part">
				<style>
input.hidden {
	display: none;
}
</style>
				<a onclick="AgregarNombre();">[+] Agregar</a> </br> <input type="text"
					size="20" id="nombre_1" name="nombre_1" /></br> <input type="text"
					size="20" id="nombre_2" name="nombre_2" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_3" name="nombre_3"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_4" name="nombre_4" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_5" name="nombre_5"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_6" name="nombre_6" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_7" name="nombre_7"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_8" name="nombre_8" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_9" name="nombre_9"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_10" name="nombre_10" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_11" name="nombre_11"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_12" name="nombre_12" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_13" name="nombre_13"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_14" name="nombre_14" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_15" name="nombre_15"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_16" name="nombre_16" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_17" name="nombre_17"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_18" name="nombre_18" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_19" name="nombre_19"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_20" name="nombre_20" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_21" name="nombre_21"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_22" name="nombre_22" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_23" name="nombre_23"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_24" name="nombre_24" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_25" name="nombre_25"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_26" name="nombre_26" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_27" name="nombre_27"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_28" name="nombre_28" style="display: none;" /></br> <input
					type="text" size="20" id="nombre_29" name="nombre_29"
					style="display: none;" /></br> <input type="text" size="20"
					id="nombre_30" name="nombre_30" style="display: none;" /></br>


			</div>
			</br>
			<p>
				<input type="submit" class="btn btn-default"
					style="background-color: #2c3e50"> <input type="reset"
					class="btn btn-default" style="background-color: #2c3e50">
			</p>
		</form>
	</div>
	</section>

	<footer class="text-center">
	<div class="footer-below">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					Copyright &copy; AmigoInvisible 2016
					<p>Trabajo para ISST curso 2015-2016.</p>
				</div>
			</div>
		</div>
	</div>
	</footer>
</body>
</html>