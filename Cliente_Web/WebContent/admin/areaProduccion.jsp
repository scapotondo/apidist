<%@page import="dto.ConfeccionDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.OrdenDeProduccionDto"%>
<%@page import="dto.ProcesoProduccionDto"%>
<%@page import="dto.UsuarioDto"%>
<html >
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Distribuidas</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="assets/css/material-dashboard.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>

<body>
	<%
		UsuarioDto usuario = (UsuarioDto) request.getAttribute("usuario");
		Integer id = (Integer) request.getAttribute("id");
		ArrayList<OrdenDeProduccionDto> ordenes = (ArrayList<OrdenDeProduccionDto>) request.getAttribute("ordenes");
	%>
	<div class="wrapper">
	
	    <%@include file="sidebar.jsp" %>
	
	    <div class="main-panel">
	        <nav class="navbar navbar-transparent navbar-absolute">
	            <div class="container-fluid">
	                <div class="navbar-header">
	                    <button type="button" class="navbar-toggle" data-toggle="collapse">
	                        <span class="sr-only">Toggle navigation</span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                        <span class="icon-bar"></span>
	                    </button>
	                </div>
	                <a class="navbar-brand" >Area de Produccion</a>
	                <div class="collapse navbar-collapse">
	                    <ul class="nav navbar-nav navbar-right">
	                        <li>
	                            <a href="${pageContext.request.contextPath}/User" >
	                                <i class="material-icons">person</i>
	                                <p class="hidden-lg hidden-md">Profile</p>
	                            </a>
	                        </li>
	                    </ul>
	                </div>
	                <div class="col-md-3">
	                        <a href="${pageContext.request.contextPath}/LineasProduccion?id=<%=id%>" class="btn btn-facebook " target="_blank">Ver Lineas Produccion</a>
	                </div>
	            </div>
	        </nav>
				
	        <div class="content">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-md-12">
	                        <div class="card">
	                            <div class="card-header" data-background-color="red">
	                                <h4 class="title">Ordenes de Produccion</h4>
	                                <p class="category">Seleccione una confeccion para terminar</p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table">
	                                    <thead class="text-info">
		                                    <th>Orden de Produccion</th>
		                                    <th>Numero de Pedido</th>
		                                    <th>Confeccion</th>
		                                    <th>Realizar</th>
	                                    </thead>
	                                    <tbody>
	                                    	<%
	                                    		if(ordenes != null){
	                                    			for(OrdenDeProduccionDto orden : ordenes){
	                                    				int menor = 100;
	                                    				ProcesoProduccionDto primerProceso = null;
	                                    				for (ProcesoProduccionDto p : orden.getProcesos()) {
	                                    					if (p.getNroOrden() < menor && p.getEstado().equals("Incompleto")) {
	                                    						menor = p.getNroOrden();
	                                    						primerProceso = p;
	                                    					}
	                                    				}
	                                    				
                                    					if(primerProceso == null || !primerProceso.getEstado().equals("Incompleto"))
                                    						break;
	                                    	%>
					                                    <tr>
					                                        <td><%= orden.getNroOrden()%></td>
					                                        <td><%= orden.getPedido().getNroPedido()%></td>
					                                        <td><%= primerProceso.getConfeccion().getDetalle()%></td>
					                                        <td><a href="AreaProduccion?area=<%= id %>&confeccionId=<%=primerProceso.getConfeccion().getId() %>&nroOrden=<%= orden.getNroOrden() %>"><i class="material-icons">done</i></a></td>
					                                    </tr>
											<%		}
	                                    		}
											%>
	                                    </tbody>
	                                </table>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>

</body>

<!--   Core JS Files   -->
<script src="assets/js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/material.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!-- Material Dashboard javascript methods -->
<script src="assets/js/material-dashboard.js"></script>

</html>