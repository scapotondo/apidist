package dto;

import java.io.Serializable;
import java.util.ArrayList;


public class PrendaDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> tallesValidos;
	private ArrayList<String> coloresValidos;
	private int codigo;
	private boolean esDiscontinuo;
	private int cantidadAProducir;
	private String nombre;
	private String descripcion;
	private float porcentajeGanancia;
	private ArrayList<ConfeccionDto> confecciones;
	private ArrayList<StockPrendaDto> stock;
	private float precio;
	
	public PrendaDto(int codigo) {
		this.codigo=codigo;
	}
	
	public PrendaDto(ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, int codigo, boolean esDiscontinuo,
			int cantidadAProducir, String nombre, String descripcion, float porsentajeGanancia, ArrayList<ConfeccionDto> confecciones,
			ArrayList<StockPrendaDto> stock){
		this(codigo);
		
		this.tallesValidos = tallesValidos;
		this.coloresValidos = coloresValidos;
		this.esDiscontinuo = esDiscontinuo;
		this.cantidadAProducir = cantidadAProducir;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentajeGanancia = porsentajeGanancia;
		this.confecciones = confecciones;
		this.stock = stock;
	}
	
	public PrendaDto(ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, int codigo, boolean esDiscontinuo,
			int cantidadAProducir, String nombre, String descripcion, float porsentajeGanancia, ArrayList<ConfeccionDto> confecciones,
			ArrayList<StockPrendaDto> stock, float precio){
		this(codigo);
		
		this.tallesValidos = tallesValidos;
		this.coloresValidos = coloresValidos;
		this.esDiscontinuo = esDiscontinuo;
		this.cantidadAProducir = cantidadAProducir;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentajeGanancia = porsentajeGanancia;
		this.confecciones = confecciones;
		this.stock = stock;
		this.precio = precio;
	}
	
	public PrendaDto(ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, int codigo, boolean esDiscontinuo,
			int cantidadAProducir, String nombre, String descripcion, float porsentajeGanancia, float precio){
		this(codigo);
		
		this.tallesValidos = tallesValidos;
		this.coloresValidos = coloresValidos;
		this.esDiscontinuo = esDiscontinuo;
		this.cantidadAProducir = cantidadAProducir;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.porcentajeGanancia = porsentajeGanancia;
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public ArrayList<String> getTallesValidos() {
		return tallesValidos;
	}

	public void setTallesValidos(ArrayList<String> tallesValidos) {
		this.tallesValidos = tallesValidos;
	}

	public ArrayList<String> getColoresValidos() {
		return coloresValidos;
	}

	public void setColoresValidos(ArrayList<String> coloresValidos) {
		this.coloresValidos = coloresValidos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean getEsDiscontinuo() {
		return esDiscontinuo;
	}

	public void setEsDiscontinuo(boolean esDiscontinuo) {
		this.esDiscontinuo = esDiscontinuo;
	}

	public int getCantidadAProducir() {
		return cantidadAProducir;
	}

	public void setCantidadAProducir(int cantidadAProducir) {
		this.cantidadAProducir = cantidadAProducir;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPorcentajeGanancia() {
		return porcentajeGanancia;
	}

	public void setPorcentajeGanancia(float porcentajeGanancia) {
		this.porcentajeGanancia = porcentajeGanancia;
	}

	public ArrayList<ConfeccionDto> getConfecciones() {
		return confecciones;
	}

	public void setConfecciones(ArrayList<ConfeccionDto> confecciones) {
		this.confecciones = confecciones;
	}

	public ArrayList<StockPrendaDto> getStock() {
		return stock;
	}

	public void setStock(ArrayList<StockPrendaDto> stock) {
		this.stock = stock;
	}
	
}
