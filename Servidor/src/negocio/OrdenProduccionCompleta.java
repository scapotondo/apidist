package negocio;

import java.util.List;

import entity.OrdenDeProduccionCompletaEntity;
import entity.OrdenDeProduccionEntity;

public class OrdenProduccionCompleta extends OrdenDeProduccion{

	public OrdenProduccionCompleta(int nroOrden, EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda) {
		super(nroOrden, estado, pedido,prenda);
	}
	
	public OrdenProduccionCompleta(EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda) {
		super(estado,pedido,prenda);
	}
	
	public OrdenProduccionCompleta(OrdenDeProduccionCompletaEntity lote) {
		super(lote);
	}
	
	public OrdenProduccionCompleta(OrdenDeProduccionEntity lote) {
		super(lote);
	}
	
	public OrdenProduccionCompleta() {
		super();
	}
	
	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getTalles() {
		return null;
	}

	@Override
	public List<String> getColores() {
		return null;
	}
}
