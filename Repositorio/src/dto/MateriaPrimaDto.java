package dto;

import java.util.ArrayList;


public class MateriaPrimaDto {
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
	
}
