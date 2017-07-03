<%@page import="dto.LineaProduccionDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<%@page import="java.util.ArrayList"%>
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
		ArrayList<LineaProduccionDto> lineas = (ArrayList<LineaProduccionDto>) request.getAttribute("lineas");
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
	                <a class="navbar-brand" >Lineas de Produccion</a>
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
	            </div>
	        </nav>
	
	        <div class="content">
	            <div class="container-fluid">
	                <div class="row">
	                    <div class="col-md-12">
	                        <div class="card">
	                            <div class="card-header" data-background-color="red">
	                                <h4 class="title">Lineas de Produccion Ocupadas</h4>
	                                <p class="category">Libere una linea</p>
	                            </div>
	                            <div class="card-content table-responsive">
	                                <table class="table">
	                                    <thead class="text-info">
		                                    <th>Numero</th>
		                                    <th>Estado</th>
		                                    <th>Tiempo a Liberarse</th>
		                                    <th>Trabajo</th>
		                                    <th>Liberar</th>
	                                    </thead>
	                                    <tbody>
	                                    	<%
	                                    		if(lineas!= null){
	                                    			for(LineaProduccionDto linea : lineas){
	                                    	%>
					                                    <tr>
					                                        <td><%=linea.getNumero() %></td>
					                                        <td><%=linea.getEstado() %></td>
					                                        <td><%=linea.getTiempoLiberarse() %></td>
					                                        <td><%=linea.getTrabajo() %></td>
					                                        <td><a href="LineasProduccion?lineaNro=<%= linea.getNumero() %>"><i class="material-icons">done</i></a></td>
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