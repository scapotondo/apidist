<!doctype html>
<html >
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

    <title>Distribuidas</title>

    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!--  Material Dashboard CSS    -->
    <link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css" rel="stylesheet"/>

    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
</head>

<body>

<div class="wrapper">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <ul class="nav navbar-nav">
                    <li><a href="pedidosPendientes.jsp">Pedidos Pendientes</a></li>
                    <li><a href="pedidosAceptados.jsp">Pedidos Aceptados</a></li>
                    <li><a href="nuevoPedido.jsp">Generar Pedido</a></li>
                    <li><a href="perfil.jsp">Perfil</a></li>
                    <li><a >Nombre cliente</a></li>
                    <li><a href="" >Log Out</a></li>
                </ul>
            </div>

        </div>
    </nav>

    <div class="main-panel">

        <div class="content" style="margin-top: 0px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header" data-background-color="orange">
                                <h4 class="title"> Generar Pedido</h4>
                            </div>
                            <div class="card-content">
                                <form>
                                    <div class="row">
                                    </div>
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
<script src="${pageContext.request.contextPath}/assets/js/jquery-3.1.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/assets/js/material.min.js" type="text/javascript"></script>

<!--  Charts Plugin -->
<script src="${pageContext.request.contextPath}/assets/js/chartist.min.js"></script>

<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}/assets/js/bootstrap-notify.js"></script>

<!-- Material Dashboard javascript methods -->
<script src="${pageContext.request.contextPath}/assets/js/material-dashboard.js"></script>

</html>
