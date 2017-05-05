package dto;

import java.util.ArrayList;


public class DespachoDto {

	private AlmacenDto almacen;
	private ArrayList<PedidoPrendasDto> pedidosPrenda;
	private AdministracionDto administracion;
	
	public DespachoDto(AlmacenDto almacen,ArrayList<PedidoPrendasDto> pedidosPrenda,AdministracionDto administracion){
		this.almacen=almacen;
		this.pedidosPrenda=pedidosPrenda;
		this.administracion=administracion;
	}

	public AlmacenDto getAlmacen() {
		return almacen;
	}

	public void setAlmacen(AlmacenDto almacen) {
		this.almacen = almacen;
	}

	public ArrayList<PedidoPrendasDto> getPedidosPrenda() {
		return pedidosPrenda;
	}

	public void setPedidosPrenda(ArrayList<PedidoPrendasDto> pedidosPrenda) {
		this.pedidosPrenda = pedidosPrenda;
	}

	public AdministracionDto getAdministracion() {
		return administracion;
	}

	public void setAdministracion(AdministracionDto administracion) {
		this.administracion = administracion;
	}
	
}
