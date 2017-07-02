<!doctype html>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="dto.PrendaDto"%>
<%@page import="java.util.ArrayList"%>
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
    
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
    	$(function() {
		    $('#prendasSelect').on('change', function(){
		    	var codigo = $('#prendasSelect').val();
		    	if (codigo != 'null') {
		            $.get("GetPrenda", 
		            	{ codigoPrenda : $('#prendasSelect').val() }, 
			            function(response) {   
							fillSelect($('#coloresSelect'), response.Colores);
					      	fillSelect($('#tallesSelect'), response.Talles);
					      	$('#precioTxt').val(response.Precio);
			        });
		    	} else {
		    		$('#coloresSelect').find('option').remove();
		    		$('#tallesSelect').find('option').remove();
		    	}
	        });
	        
	        function fillSelect(select, items) {
	   			select.find('option').remove();
	
	            $.each(items, function(index, value) {
	        		$('<option>').val(value).text(value).appendTo(select);
		      	});
			}
	        
	        function validarCantidad(){
	        	
	        		if( $('#prendasSelect').val() == 'null' ){	
	        			alert("Debe seleccionar una prenda");
	        			return false;
	        		}else if( !$('#cantidadTxt').val()){
	        			alert("Debe ingresar una cantidad");
	        			return false;
	        		}else if( $('#cantidadTxt').val() <= 0){
	        			alert("Debe ingresar una cantidad mayor a cero");
	        			return false;
	        		}
	        		
	        		return true;
	        }
	        
	        var total = 0;
			
			$('#addBtn').on('click', function() {
				
				if( validarCantidad() ){
				var codigo = $('#prendasSelect').val();
					if (codigo != 'null') {
						var color = $('#coloresSelect').val();
						var talle = $('#tallesSelect').val();
						var cantidad = $('#cantidadTxt').val();
						var subtotal = cantidad*$('#precioTxt').val();
						
						total += subtotal;
						$('#totalTxt').val(total);
						
						$('<option>').val(codigo + "-" + color + "-" + talle + "-" + cantidad).text($('#prendasSelect option:selected').text() + " - " + color + " - " + talle + " - " + cantidad + " - " + subtotal).appendTo($('#listaDeItems'));
					}
				}
			});
			
			$('#submitBtn').click(function () {
				$('#listaDeItems option').each(function () {
		            $(this).attr('selected', true);
		        });
			});
		});
    </script>
</head>

<body>

<div class="wrapper">
	<% ArrayList<PrendaDto> prendas = (ArrayList<PrendaDto>) request.getAttribute("prendas");%>
	
    <%@include file="generalNav.jsp" %>

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
                                <form action="${pageContext.request.contextPath}/NuevoPedido" method="post">
                                    <div class="row">
                                    	<label for="prendasSelect">Prenda:</label>
	                                    <select id="prendasSelect">
	                                    	<option value="null">- Seleccionar -</option>
	                                    	<% 	if (prendas != null) { 
	                                    			for (PrendaDto prenda : prendas) { %>
												<option value="<%= prenda.getCodigo() %>"><%= prenda.getDescripcion() %></option>
											<% 		}
												} %>
	  									</select>
	  									
	  									<label for="precioTxt">Precio:</label>
	  									<input type="text" id="precioTxt" disabled="disabled">
	  									
	  									<label for="coloresSelect">Color:</label>
	  									<select id="coloresSelect">
	  									</select>
	  									
	  									<label for="tallesSelect">Talles:</label>
	  									<select id="tallesSelect">
	  									</select>
	  									
	  									<label for="cantidadTxt">Cantidad:</label>
	  									<input id="cantidadTxt" name="cantidad" type="text">
	  									
	  									<input id="addBtn" style="border: 1px;" type="button" value="Agregar">
									</div>
									<div> 
										<select id="listaDeItems" class="listaDeItems" style="width: 25em; height: 15em;" name="items[]" size="10" multiple="multiple">
										</select>
										<label for="totalTxt">Total:</label>
										<input type="text" id="totalTxt" disabled="disabled">
									</div>
									<div>
										<input id="submitBtn" style="border: 1px;" type="submit" value="Realizar pedido">
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
