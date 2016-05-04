<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>

	<html>
		<head>	
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<meta name="description" content="">
			<meta name="author" content="">

			<title>Registro Amigo invisible ISST</title>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
  
      <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<!-- // <script type="text/javascript" src="JS/navbarJS.js"></script> -->
		 <!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
			<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
			<link href="estiloindex/css/bootstrap.min.css" rel="stylesheet">
			<!-- Custom CSS -->
			<link href="estiloindex/css/freelancer.css" rel="stylesheet">
			<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
			<!-- // <script type="text/javascript" src="estiloindex/js/freelancer.js"></script>   -->
			<script type="text/javascript" src="estiloindex/js/contact_me.js"></script>
			<script type="text/javascript" src="estiloindex/js/jqBootstrapValidation.js"></script>
			<script type="text/javascript" src="estiloindex/js/cbpAnimatedHeader.js"></script>
			<script type="text/javascript" src="estiloindex/js/classie.js"></script>    
			<script type="text/javascript" src="JS/interfazregistroJS.js"></script>

			<!-- Custom Fonts -->
			<link href="estiloindex/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
			<link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
			<link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

			<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
			<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
			<!--[if lt IE 9]>
							<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
							<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
			<![endif]-->

		</head>


		
		<body>


				<!-- Navigation -->
			<nav class="navbar navbar-default navbar-fixed-top">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header page-scroll">
						<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="/index">AMIGO INVISIBLE</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav navbar-right">
							<li class="hidden">
								<a href="#page-top"></a>
							</li>
					<li class="page-scroll">
                        <a id="Registro" href="/interfazRegistro.jsp">Registro</a>
                    </li>
                    <li class="page-scroll">
                        <a id="Entrar" href="/interfazLogin.jsp">Entrar</a>
                    </li>	
						</ul>
					</div>
											<!-- /.navbar-collapse -->
				</div>
							<!-- /.container-fluid -->
			</nav>

			<section id="about">
				<div class="container text-center"><!--onsubmit="return confirmarCampos()"-->
					<form  action="/register" >   
						<div class="container_content">
							<h1>Registrarse</h1>
								<fieldset>
									<form>
									<div class='rellenar'>

									<label for="number">Nombre de usuario:</label>
										<div id='username2' class='outerDiv'>
											<span><input type="text" name="username" id="username" required  /></span>
										</div>

									<label for="password">Contraseña:</label>
										<div id='password1' class='outerDiv'>
											<input type="password" name="password" id="password" required />
										</div>

									<label for="password">Confirmar contraseña:</label>
										<div id='password2' class='outerDiv'>
											<input type= "password" name ="password2" id="confpassword" required/>
										</div>

									<label for="email">Introduzca su email:</label>
										<div id='email' class='outerDiv'>
											<input type="email" name="email" required />
										</div>
									</div>
										<br>
										<label><c:out value="${samepasswords}"/></label>
										<label><c:out value="${error}"/></label>
										<div class='message' id='emailDiv'>La confirmacion de registro se enviará a su email.</div>		
								</form>								
							</fieldset>
							<br>
							<div id='submit' class='outerDiv' align="center">
								<input align="center" type="submit" value="Crear mi cuenta" class="btn btn-default" style="background-color: #2c3e50"><a href="interfazmicuenta.html"></input>					
							</div>
							<br>
					</div>
		</form>
		<form  action="/registerWithGoogle" >   
			<div class="container_content">
				<div id='submit' class='outerDiv' align="center">
					<input align="center" type="submit" value="Crear mi cuenta con Google" class="btn btn-default" style="background-color: #2c3e50"><a href="interfazmicuenta.html"></input>					
				</div>
			</div>
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

