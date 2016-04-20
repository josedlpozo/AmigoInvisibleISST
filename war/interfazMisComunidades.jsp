<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Mis comunidades</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

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




<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>



<!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
<link href="estiloindex/css/bootstrap.min.css" rel="stylesheet">
<!-- Custom CSS -->
<link href="estiloindex/css/freelancer.css" rel="stylesheet">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
<script type="text/javascript" src="estiloindex/js/contact_me.js"></script>
<script type="text/javascript"
	src="estiloindex/js/jqBootstrapValidation.js"></script>
<script type="text/javascript" src="estiloindex/js/cbpAnimatedHeader.js"></script>
<script type="text/javascript" src="estiloindex/js/classie.js"></script>

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
	<script>

		function setNombre(name) {  		
  		 document.getElementById("nombreComunidad").value = name;
  		} 
 	</script>
	<% if (request.getParameter("nombreComunidad") != null){
		//<c:set var="salary" scope="session" value="${2000*2}"/>
		String nombrecomunidad = request.getParameter("nombreComunidad");
	}
	%>
</head>

<body>
	

	<%@ include file="/navbar.html" %>
	
	<header>
	<div class="container">
		<h1>Mis comunidades</h1>
		<hr class="star-light">
		<p>En este punto, al cargar las comunidades del usuario, aqui le
			aparecería una lista con enlaces a las paginas concretas de cada una</p>
		<div id="listacomunidades">
			<form action="/micomunidad" method="get">
				<c:forEach items="${comunidades}" var="comunidad">
						<input type="submit" 
							name="<c:out value="${comunidad.nombre}" />"
							value="<c:out value="${comunidad.nombre}" />" 
							style="background-color: #2c3e50" 
							class="btn btn-default"
						/>
						<br>
						<br>
				</c:forEach>
			</form>
		</div>
	</div>
	</header>

	<section id="about">
	<div class="container">
		<div class="row text-center">
			<h1>Crea una nueva comunidad</h1>
			<hr class="star-primary">
			<p>Crea una comunidad e invita a todos tus amigos a participar!!</p>
			<input align="center"
				onclick="location='interfazRegistroComunidad.jsp'"
				value="Crea tu comunidad!!" class="btn btn-default"
				style="background-color: #2c3e50" /> <br> <br>
		</div>
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