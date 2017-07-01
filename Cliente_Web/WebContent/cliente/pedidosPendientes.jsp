<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import= "dto.UsuarioDto"%>
<%@ page import= "dto.PedidoPrendasDto"%>
<!doctype html>
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
	ArrayList<PedidoPrendasDto> pedidosPendientes = (ArrayList<PedidoPrendasDto>)request.getAttribute("pedidosPendientes");
	UsuarioDto usuario = request.getAttribute("usuario");
%>
<div class="wrapper">

    <%@include file="generalNav.jsp" %>

    <div class="main-panel" style="width: 100%;">

        <div class="content" style="margin-top: 0px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header" data-background-color="orange">
                                <h4 class="title">Pedidos Pendientes</h4>
                            </div>
                            <div class="card-content table-responsive">
                                <table class="table">
                                    <thead class="text-info">
	                                    <th>Pedido</th>
	                                    <th>Fecha Probable Despacho</th>
	                                    <th>Aceptar</th>
	                                    <th>Rechazar</th>
                                    </thead>
                                    
                                    <tbody>
                                    	<%
                                    		for(PedidoPrendasDto pedido : pedidosPendientes){
                                    	%>
		                                    <tr>
		                                        <td><%= pedido.getNroPedido() %></td>
		                                        <td><%= pedido.getFechaProbableDespacho() %></td>
		                                        <td><a href="PedidosPendientes?action=aceptar"> <i class="material-icons">done</i> </a></td>
		                                        <td><a href="PedidosPendientes?action=rechazar"> <i class="material-icons" style="color:red">clear</i> </a></td>
		                                    </tr>
		                                    
										<% } %>
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
<script src="../assets/js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="../assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="../assets/js/material.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="../assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="../assets/js/bootstrap-notify.js"></script>

<!-- Material Dashboard javascript methods -->
<script src="../assets/js/material-dashboard.js"></script>

</html>

