package negocio;

import java.util.ArrayList;

import entity.OrdenDeProduccionEntity;
import entity.OrdenDeProduccionParcialEntity;

public class OrdenProduccionParcial extends OrdenDeProduccion {
	
	private ArrayList<String> talles;
	private ArrayList<String> colores;
	
	public OrdenProduccionParcial()	{}
	
	public OrdenProduccionParcial(ArrayList<String> talles,ArrayList<String> colores,EstadoOrdenProduccion estado, PedidoPrendas pedido, Prenda prenda, ArrayList<ProcesoProduccion> procesos) {
		super(estado, pedido, prenda, procesos);
		this.talles=talles;
		this.colores=colores;
	}
	
	public OrdenProduccionParcial(OrdenDeProduccionParcialEntity lote) {
		super(lote);
		this.talles=new ArrayList<String>();
		this.colores = new ArrayList<String>();
		
		for (String talle : lote.getTallesValidos()) {
			this.talles.add(talle);
		}
		
		for (String color : lote.getColoresValidos()) {
			this.colores.add(color);
		}
	}
	
	public OrdenProduccionParcial(OrdenDeProduccionEntity lote, ArrayList<String> talles, ArrayList<String> colores) {
		super(lote);
		this.talles=talles;
		this.colores=colores;
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
