package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class MateriaPrimaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private int codigo;
	private int minimo;
	private ArrayList<StockMateriaPrimaDto> stock;
	
	public MateriaPrimaDto( String nombre, int codigo, int minimo,ArrayList<StockMateriaPrimaDto> stock){
		this.stock=stock;
		this.nombre=nombre;
		this.codigo=codigo;
		this.minimo=minimo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getMinimo() {
		return minimo;
	}

	public void setMinimo(int minimo) {
		this.minimo = minimo;
	}

	public ArrayList<StockMateriaPrimaDto> getStock() {
		return stock;
	}

	public void setStock(ArrayList<StockMateriaPrimaDto> stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nombre+" - "+this.codigo;
	}
	
}
