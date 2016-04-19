<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Mi cuenta</title>
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


</head>

<body>


	<%@ include file="/navbar.html" %>

	<header>
	<div class="container">

		<div class="container_content">
			<h1>Mi cuenta</h1>

			<p>Correo: <c:out value="${user_email}" /></p>
		</div>
	</div>
	<br>
	<br>
	<br>
	<br>

	<br>
	<br>
	<br>
	<br>
	<br>
	</header>








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