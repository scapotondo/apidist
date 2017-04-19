package negocio;

import java.util.ArrayList;

public class MateriaPrima {

	private String nombre;
	private int codigo;
	private int minimo;
	private ArrayList<StockMateriaPrima> stock;
	
	public MateriaPrima( String nombre, int codigo, int minimo){
		this.stock=new ArrayList<StockMateriaPrima>();
		this.nombre=nombre;
		this.codigo=codigo;
		this.minimo=minimo;
	}
	public boolean tenesStock(int cantidad){
		return true;
	}
}
