package negocio;

import java.util.ArrayList;

public class OrdenProduccionParcial extends OrdenDeProduccion {
	
	private ArrayList<String> talles;
	private ArrayList<String> colores;
	
	public OrdenProduccionParcial(int nroOrden, ArrayList<String> talles,ArrayList<String> colores,String estadoo,ArrayList<MateriaPrima> materiaPrimaReservada, PedidoPrendas pedido, Prenda prenda) {
		super(nroOrden, estadoo,materiaPrimaReservada,pedido,prenda);
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
