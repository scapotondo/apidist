<!doctype html>
<%@page import="dto.StockPrendaDto"%>
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
	ArrayList<StockPrendaDto> stockPrendas = (ArrayList<StockPrendaDto>)request.getAttribute("stockPrendas");
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
	                <a class="navbar-brand" >Stock Prendas</a>
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
	                    <div class="col-md-2"></div>
	                    <div class="col-md-8">
	                        <div class="card">
	                            <div class="card-header" data-background-color="orange">
	                                <h4 class="title"> Modificar Stock Prenda</h4>
	                            </div>
	                            <div class="card-content">
	                                
	                                <form action="${pageContext.request.contextPath}/ModificarStockPrendas" method="post">
	                                    <div class="row">
	                                        <div class="col-md-5">
	                                            <div class="form-group label-floating">
	                                                <select class="form-control" name="stockPrenda">
	                                                    <option value="">Seleccione un stock</option>
	                                                    <%
	                                                    	if(stockPrendas!= null){
	                                                    		for(StockPrendaDto stock : stockPrendas){
	                                                    %>
			                                                   		<option value="<%=stock.getCodigo()%>"><%=stock.getPrenda().getDescripcion()%> - <%=stock.getUbicacion() %> - <%=stock.getTalle() %> - <%=stock.getColor() %></option>
	                                                   	<% 		} 
	                                                    	}
	                                                   	%>
	                                                </select>
	                                            </div>
	                                        </div>
	                                    </div>
	
										<div class="row">
	                                        <div class="col-md-4">
	                                            	<select class="form-control" name="tipoMovimiento">
	                                                    <option value="">Seleccione el tipo de movimiento</option>
			                                            <option value="Por Deterioro">Por Deterioro</option>
			                                            <option value="Diferencia Inventario">Diferencia Inventario</option>
	                                                </select>
	                                        </div>
	                                    </div>
	
	                                    <div class="row">
	                                        <div class="col-md-4">
	                                            <div class="form-group label-floating">
	                                                <label class="control-label">Cantidad</label>
	                                                <input type="text" name="cantidad" class="form-control">
	                                            </div>
	                                        </div>
	                                        <div class="col-md-6">
	                                            <div class="form-group label-floating">
	                                                <label class="control-label">Quien autoriza</label>
	                                                <input type="text" name="autoriza" class="form-control" >
	                                            </div>
	                                        </div>
	                                        
	                                    </div>
	
	                                    <button class="btn btn-google ">Aceptar</button>
	                                </form>
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

<!--  Notifications Plugin    -->
<script src="assets/js/bootstrap-notify.js"></script>

<!-- Material Dashboard javascript methods -->
<script src="assets/js/material-dashboard.js"></script>

</html>
