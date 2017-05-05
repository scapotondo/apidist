package negocio;

import java.util.ArrayList;

import dto.MateriaPrimaDto;
import dto.StockMateriaPrimaDto;

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
	public ArrayList<StockMateriaPrima> getStock() {
		return stock;
	}
	public void setStock(ArrayList<StockMateriaPrima> stock) {
		this.stock = stock;
	}
	public boolean tenesStock(int cantidad){
		return true;
	}
	
	public MateriaPrimaDto toDto(){
		
		ArrayList<StockMateriaPrimaDto> stockDto = new ArrayList<>();
		for (StockMateriaPrima stockMateriaPrima : stock) {
			stockDto.add(stockMateriaPrima.toDto());
		}
		return new MateriaPrimaDto(nombre, codigo, minimo, stockDto);
	}
}
