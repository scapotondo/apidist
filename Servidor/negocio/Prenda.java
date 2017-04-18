package negocio;

import java.util.ArrayList;

public class Prenda {

	private ArrayList<String> tallesValidos;
	private ArrayList<String> coloresValidos;
	private int codigo;
	private boolean esDiscontinuo;
	private int cantidadAProducir;
	private String nombre;
	private String descripcion;
	private float porsentajeGanancia;
	private ArrayList<Confeccion> confecciones;
	private ArrayList<StockPrenda> stock;
	
	public Prenda(){
		
	}
	
	public float calcularCostoActual(){
		return 0;
	}
	public void getPrendasDto(){
		
	}
	
	public ArrayList<Insumo> CalcularCantidadMateriaPrimaTotal(){
		return null;
	}
	
	public boolean hayStockSuficiente(int cantidad){
		return true;
	}
}
