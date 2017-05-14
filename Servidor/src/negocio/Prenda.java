package negocio;

import java.util.ArrayList;

import dto.ConfeccionDto;
import dto.PrendaDto;
import dto.StockPrendaDto;
import entity.ConfeccionEntity;
import entity.PrendaEntity;
import entity.StockPrendaEntity;

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
	
	public Prenda(PrendaEntity prenda){
		ArrayList<String> tvalidos=new ArrayList<>();
		for (String talle : prenda.getTallesValidos()) {
			tvalidos.add(talle);
		}
		ArrayList<String> cValidos=new ArrayList<>();
		for (String color : prenda.getColoresValidos()) {
			cValidos.add(color);
		}
		this.tallesValidos=tvalidos;
		this.coloresValidos=cValidos;
		this.codigo=prenda.getCodigo();
		this.esDiscontinuo=prenda.getEsDiscontinuo();
		this.cantidadAProducir=prenda.getCantidadAProducir();
		this.nombre=prenda.getNombre();
		this.descripcion=prenda.getDescripcion();
		this.porsentajeGanancia=prenda.getPorsentajeGanancia();
		this.confecciones = new ArrayList<Confeccion>();
		for (ConfeccionEntity confeccionEntity : prenda.getConfecciones()) {
			this.confecciones.add(new Confeccion(confeccionEntity));
		}
		this.stock=new ArrayList<StockPrenda>();
		for (StockPrendaEntity stockPrendaEntity : prenda.getStock()) {
			this.stock.add(new StockPrenda(stockPrendaEntity));
		}
	}
	
	
	public Prenda(ArrayList<String> tallesValidos,ArrayList<String> coloresValidos,int codigo,boolean esDiscontinuo,
			int cantidadAProducir,String nombre,String descripcion,float porsentajeGanancia,ArrayList<Confeccion> confecciones,
			ArrayList<StockPrenda> stock){
		
		this.tallesValidos=tallesValidos;
		this.coloresValidos=coloresValidos;
		this.codigo=codigo;
		this.esDiscontinuo=esDiscontinuo;
		this.cantidadAProducir=cantidadAProducir;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.porsentajeGanancia=porsentajeGanancia;
		this.confecciones=confecciones;
		this.stock=stock;
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

	public float getPorsentajeGanancia() {
		return porsentajeGanancia;
	}

	public void setPorsentajeGanancia(float porsentajeGanancia) {
		this.porsentajeGanancia = porsentajeGanancia;
	}

	public ArrayList<Confeccion> getConfecciones() {
		return confecciones;
	}

	public void setConfecciones(ArrayList<Confeccion> confecciones) {
		this.confecciones = confecciones;
	}

	public ArrayList<StockPrenda> getStock() {
		return stock;
	}

	public void setStock(ArrayList<StockPrenda> stock) {
		this.stock = stock;
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
	
	public PrendaDto toDto(){
		ArrayList<ConfeccionDto> confeccionesDto =new ArrayList<>();
		ArrayList<StockPrendaDto> stockDto = new ArrayList<>();
		
		for (StockPrenda stockPrenda : stock) {
			stockDto.add(stockPrenda.toDto());
		}
		for (Confeccion confeccion : confecciones) {
			confeccionesDto.add(confeccion.toDto());
		}
		return new PrendaDto(tallesValidos, coloresValidos, codigo, esDiscontinuo, cantidadAProducir, nombre, descripcion,
				porsentajeGanancia, confeccionesDto, stockDto);
	}
}
