package negocio;

import java.util.ArrayList;

import entity.OrdenDeProduccionParcialEntity;

public class OrdenProduccionParcial extends OrdenDeProduccion {
	
	private ArrayList<String> talles;
	private ArrayList<String> colores;
	
	public OrdenProduccionParcial()	{}
	public OrdenProduccionParcial(int nroOrden, ArrayList<String> talles,ArrayList<String> colores,EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda) {
		super(nroOrden, estado,pedido,prenda);
		this.talles=talles;
		this.colores=colores;
	}
	
	public OrdenProduccionParcial( ArrayList<String> talles,ArrayList<String> colores,EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda) {
		super(estado,pedido,prenda);
		this.talles=talles;
		this.colores=colores;
	}
	
	public OrdenProduccionParcial(OrdenDeProduccionParcialEntity lote) {
		super(lote);
		this.talles=(ArrayList<String>) lote.getTallesValidos();
		this.colores=(ArrayList<String>) lote.getColoresValidos();
	}
	
	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<String> getTalles() {
		return talles;
	}

	public void setTalles(ArrayList<String> talles) {
		this.talles = talles;
	}

	public ArrayList<String> getColores() {
		return colores;
	}

	public void setColores(ArrayList<String> colores) {
		this.colores = colores;
	}

	
}
