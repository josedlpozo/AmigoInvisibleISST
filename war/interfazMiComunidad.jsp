<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	<title>Mi comunidad</title>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	
  
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    
    <!-- Latest compiled JavaScript -->
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <!-- Bootstrap Core CSS - Uses Bootswatch Flatly Theme: http://bootswatch.com/flatly/ -->
    <link href="estiloindex/css/bootstrap.min.css" rel="stylesheet">


    <!-- Custom CSS -->
    <link href="estiloindex/css/freelancer.css" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript" src="estiloindex/js/freelancer.js"></script>  
    <script type="text/javascript" src="estiloindex/js/contact_me.js"></script>
    <script type="text/javascript" src="estiloindex/js/jqBootstrapValidation.js"></script>
    <script type="text/javascript" src="estiloindex/js/cbpAnimatedHeader.js"></script>
    <script type="text/javascript" src="estiloindex/js/classie.js"></script>    
    
    <link href="./../css/chat.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <link href="estiloindex/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">
					</head>
<body id="page-top">



	<%@ include file="/navbar.html" %>
	
	
	
	<section id="about">
		<div class="container text-center">
			<fieldset>
				<div id="infopersonal"></div>
					<h1><c:out value="${nombrecomunidad}"/></h1>
						<h2><c:out value="${user}"/></h2>
							<a id="Mi lista de deseos" href="interfazmilistadedeseos.html">Mi lista de deseos</a><br>
							<a id="Ideas para regalar" href="interfazideasderegalo.html">Ideas para regalar</a>
				</div>
				<hr class="star-primary">
			</fieldset>
		</div>
	</section>
	
	
	
	<header>
		<div class="container">
			<fieldset>
				<div id="nombres">
					<div id="oculto">
						<h2>A quien tienes que regalar </h2>
								<!--  TODO  -->
								<c:if test="${not empty sorteo}">
									<p class="oculto"><c:out value="${sorteo}" /></p>
								</c:if>
					</div>
					<c:if test="${not empty gestor}">
						<form action="/sorteo" method="get"> 
							 <input type="submit" 
							 	name="Realizar sorteo"
							 	value="Realizar sorteo"
								style="background-color: #2c3e50" 
								class="btn btn-default"
							/>
						</form>
					</c:if> 	
				</div>
				<hr class="star-light">
			</fieldset>
		</div>
	</header>
	
	
	
	<section id="about">
		<div class="container text-center">
			<fieldset>
				<div id="listasdedeseos">
					<h2>Listas de deseos</h2>
						<p>AquÃ­ aparecen los nombres de los usuarios del grupo y esos nombres son los enlaces a sus correspondientes listas de deseos</p>
				</div>
				<hr class="star-primary">
			</fieldset>
		</div>
	</section>
	
	
	
	<header>
		<div class="container">
			<fieldset>
				<div id="infocomunidad">
					<h2>Fecha de entrega de regalos</h2>
						<h3>5 de junio de 2016</h3>
						<p>Si aÃºn no se ha establecido debera aparecer un mensaje avisÃ¡ndolo</p>

					<h2>Precio orientativo</h2>
						<h3>Precio orientativo(texto variable y autogenerado, javascript a partir de campo de base de datos?)</h3>
						<p>Si aÃºn no se ha establecido debera aparecer un mensaje avisÃ¡ndolo</p>
					<h4>Al gestor le aparecera la opciÃ³n de cambiar ambos campos</h4>
				</div>
				<hr class="star-light">
			</fieldset>
		</div>
	</header>
	
	
	
	<section id="about">
		<div class="container text-center">
			<fieldset>
				<div id="chatdecomunidad">
				<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-md-8 col-md-offset-2">
            <div class="portlet portlet-default">
                <div class="portlet-heading">
                    <div class="portlet-title">
                        <h4></h4>
                    </div>
                    <div class="portlet-widgets">
                        <span class="divider"></span>
                        <a data-toggle="collapse" data-parent="#accordion" href="#chat"><i class="fa fa-chevron-down"></i></a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div id="chat" class="panel-collapse collapse in">
                    <div>
                    <div class="portlet-body chat-widget" style="overflow-y: auto; width: auto; height: 300px;">
                        <c:forEach items="${mensajes}" var="mensaje">
	                        <div class="row">
	                            <div class="col-lg-12">
	                                <div class="media">
	                                    <div class="media-body">
	                                        <p><c:out value="${mensaje.mensaje}"/></p>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <hr>
                        </c:forEach>
                    </div>
                    </div>
                    <div class="portlet-footer">
                        <form role="form">
                            <div class="form-group">
                                <textarea class="form-control" placeholder="Enter message..."></textarea>
                            </div>
                            <div class="form-group">
                                <button type="button" class="btn btn-default pull-right">Send</button>
                                <div class="clearfix"></div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- /.col-md-4 -->
    </div>
</div>
				</div>
				<hr class="star-primary">
			</fieldset>
		</div>
	</section>



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


	<div class="scroll-top page-scroll visible-xs visible-sm visible-lg">
        <a class="btn btn-primary" href="#page-top">
            <i class="fa fa-chevron-up"></i>
        </a>
    </div>

    

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
</body>
</html>