<!doctype html>
<%@page import="dto.MovimientoMateriaPrimaDto"%>
<%@page import="dto.MovimientoPrendaDto"%>
<%@page import="dto.StockMateriaPrimaDto"%>
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
		ArrayList<StockPrendaDto> stockPrendas = (ArrayList<StockPrendaDto>) request.getAttribute("stockPrendas");
		ArrayList<StockMateriaPrimaDto> stockMateriaPrima = (ArrayList<StockMateriaPrimaDto>) request.getAttribute("stockMateriaPrima");
		ArrayList<MovimientoPrendaDto> movimientosPrenda = (ArrayList<MovimientoPrendaDto>) request.getAttribute("movimientosPrenda");
		
		ArrayList<MovimientoMateriaPrimaDto> movimientosMateriaPrima = (ArrayList<MovimientoMateriaPrimaDto>) request.getAttribute("movimientosMateriaPrima");
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
					<a class="navbar-brand" >Almacen</a>
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
						<div class="col-md-3">
							<a href="${pageContext.request.contextPath}/ModificarStockPrendas" class="btn btn-facebook ">Modificar stock prenda</a>
						</div>
						<div class="col-md-12">
							<div class="card">
								<div class="card-header" data-background-color="red">
									<h4 class="title">Stock Prendas</h4>
									<p class="category">Bultos disponibles de cada prenda </p>
								</div>
								<div class="card-content table-responsive">
									<table class="table">
										<thead class="text-info">
										<th>Lote</th>
										<th>Prenda</th>
										<th>Color</th>
										<th>Talle</th>
										<th>Cantidad</th>
										<th>Ubicacion</th>
										</thead>
										<tbody>
											<%
												if(stockPrendas != null){
													for(StockPrendaDto stock : stockPrendas){
											%>
														<tr>
															<td><%= stock.getLote().getNroOrden() %></td>
															<td><%= stock.getPrenda().getNombre() %></td>
															<td><%= stock.getColor() %></td>
															<td><%= stock.getTalle() %></td>
															<td><%= stock.getCantidad() %></td>
															<td><%= stock.getUbicacion() %></td>
														</tr>
											<% 		} 
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="card">
								<div class="card-header" data-background-color="red">
									<h4 class="title">Stock Materia Prima</h4>
									<p class="category">Bultos disponibles de cada materia prima </p>
								</div>
								<div class="card-content table-responsive">
									<table class="table">
										<thead class="text-info">
											<th>Numero</th>
											<th>Materia Prima</th>
											<th>Cantidad</th>
											<th>Ubicacion</th>
										</thead>
										<tbody>
											<%
												if(stockMateriaPrima != null){
													for(StockMateriaPrimaDto stock :stockMateriaPrima){
											%>
														<tr>
															<td><%= stock.getNumero() %></td>
															<td><%= stock.getMateriaPrima().getNombre() %></td>
															<td><%= stock.getCantidad() %></td>
															<td><%= stock.getUbicacion() %></td>
														</tr>
											<%
													}
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="card">
								<div class="card-header" data-background-color="red">
									<h4 class="title">Movimiento Prenda</h4>
									<p class="category">Eventos realizados sobre prendas </p>
								</div>
								<div class="card-content table-responsive">
									<table class="table">
										<thead class="text-info">
											<th>Id</th>
											<th>Prenda</th>
											<th>Color</th>
											<th>Talle</th>
											<th>Cantidad</th>
											<th>Destino</th>
											<th>Encargado</th>
											<th>Quien autorizo</th>
											<th>Fecha</th>
										</thead>
										<tbody>
											<%
												if(movimientosPrenda != null){
													for(MovimientoPrendaDto movimiento : movimientosPrenda){
											%>
														<tr>
															<td><%= movimiento.getId() %></td>
															<td><%= movimiento.getPrenda().getNombre() %></td>
															<td><%= movimiento.getCantidad() %></td>
															<td><%= movimiento.getDestino() %></td>
															<td><%= movimiento.getEncargado() %></td>
															<td><%= movimiento.getQuienAutorizo() %></td>
															<td><%= movimiento.getFecha() %></td>
														</tr>
											<%		}
												}
											%>
										</tbody>
									</table>
								</div>
							</div>
						</div>
						<div class="col-md-12">
							<div class="card">
								<div class="card-header" data-background-color="red">
									<h4 class="title">Movimiento Materia Prima</h4>
									<p class="category">Eventos realizados sobre materia prima </p>
								</div>
								<div class="card-content table-responsive">
									<table class="table">
										<thead class="text-info">
											<th>Id</th>
											<th>Materia Prima</th>
											<th>Cantidad</th>
											<th>Fecha</th>
											<th>Estado</th>
										</thead>
										<tbody>
											<%
												if(movimientosMateriaPrima != null){
													for(MovimientoMateriaPrimaDto movimiento :movimientosMateriaPrima ){
											%>
														<tr>
															<td><%= movimiento.getId() %></td>
															<td><%= movimiento.getStocksReservados().get(0).getMateriaPrima().getNombre() %></td>
															<td><%= movimiento.getCantidad() %></td>
															<td><%= movimiento.getFecha() %></td>
															<td><%= movimiento.getEstado() %></td>
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
