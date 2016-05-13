<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	
	


	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

	
  <script src="ajax.js"></script>
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
<body>


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
										<span class="divider"></span> <a data-toggle="collapse"
											data-parent="#accordion" href="#chat"><i
											class="fa fa-chevron-down"></i></a>
									</div>
									<div class="clearfix"></div>
								</div>
								<div id="chat" class="panel-collapse collapse in">
									<div id="actualizar">
										<div class="portlet-body chat-widget"
											style="overflow-y: auto; width: auto; height: 300px;">
											<c:forEach items="${mensajes}" var="mensaje">
												<div class="row">
													<div class="col-lg-12">
														<div class="media">
															<div class="media-body">
																<p>
																	<c:out value="${mensaje.mensaje}" />
																</p>
															</div>
														</div>
													</div>
												</div>
												<hr>
											</c:forEach>
										</div>
									</div>
									<div class="portlet-footer">
										<form action="/savemessage" method="post">
											<div class="form-group">
												<textarea class="form-control"
													placeholder="Enter message..." name="mensaje"></textarea>
											</div>
											<div class="form-group">

												<input type="submit" class="btn btn-default pull-right"
													onclick="recuperaResidencia()">Send</input>
												<div class="clearfix"></div>
										</form>
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
	
	</body>