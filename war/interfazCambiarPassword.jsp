
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
   
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
         <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
            <link href="estiloindex/css/bootstrap.min.css" rel="stylesheet">
            <!-- Custom CSS -->
            <link href="estiloindex/css/freelancer.css" rel="stylesheet">
            <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
            <script type="text/javascript" src="estiloindex/js/contact_me.js"></script>
            <script type="text/javascript" src="estiloindex/js/jqBootstrapValidation.js"></script>
            <script type="text/javascript" src="estiloindex/js/cbpAnimatedHeader.js"></script>
            <script type="text/javascript" src="estiloindex/js/classie.js"></script>    

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
    
<%@ include file="/navbar.html" %>
    
 <Section id="about">
  <div class="container text-center">
    <div class="row">
      <div class="col-md-4"></div>  
      <div class="col-md-4">
            <h1>Cambiar contraseña<small>Amigo invisible</small></h1>
            <br>
            <br>
             
            <form onsubmit="return confirmarCampos()" action="/cambiocontrasena" method="post">
                <div class="input-group">
                  <span class="input-group-addon" id="basic-addon1">Contraseña antigua</span>
                  <input type="password" class="form-control" placeholder="Contraseña antigua" aria-describedby="basic-addon1" name="oldpassword" required >
                </div>

                <br>
                <br>

                <div class="input-group">
                  <span class="input-group-addon" id="basic-addon1">Nueva contraseña</span>
                  <input type="password" class="form-control" placeholder="Contraseña" aria-describedby="basic-addon1" name="password" required >
                </div>

                <br>
                <br>

                <div class="input-group">
                  <span class="input-group-addon" id="basic-addon1">Repita contraseña</span>
                  <input type="password" class="form-control" placeholder="Comprobación" aria-describedby="basic-addon1" name="confpassword" required >
                </div>

                <br>
                <br>
                <div class="row">
                  <div class="col-md-4"></div>  
                  <div class="col-md-4">
                      <input type="submit" value="Entrar" class="btn btn-primary"  >
                      <!--<br><a href="interfazmicuenta.html">en caso de todo bien iriamos aquí</a>!-->
            </form >
            <br>
            <br>
        </div>
    </div>
  </div>
</div>
<Section>
    <br>
    <br>
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
