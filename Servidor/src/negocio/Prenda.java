package negocio;

import java.util.ArrayList;

import dao.PrendaDao;
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
	private float porcentajeGanancia;
	private ArrayList<Confeccion> confecciones;
	private ArrayList<StockPrenda> stock;
	
	public Prenda(PrendaEntity prenda){
		this.tallesValidos=new ArrayList<>();
		this.coloresValidos=new ArrayList<>();
		this.codigo=prenda.getCodigo();
		this.esDiscontinuo=prenda.getEsDiscontinuo();
		this.cantidadAProducir=prenda.getCantidadAProducir();
		this.nombre=prenda.getNombre();
		this.descripcion=prenda.getDescripcion();
		this.porcentajeGanancia=prenda.getPorsentajeGanancia();
		this.confecciones = new ArrayList<Confeccion>();
		this.stock=new ArrayList<StockPrenda>();
		
		for (ConfeccionEntity confeccionEntity : prenda.getConfecciones()) {
			this.confecciones.add(new Confeccion(confeccionEntity));
		}
		
		for (StockPrendaEntity stockPrendaEntity : prenda.getStock()) {
			this.stock.add(new StockPrenda(stockPrendaEntity));
		}
		
		for (String talle : prenda.getTallesValidos()) {
			this.tallesValidos.add(talle);
		}
		
		for (String color : prenda.getColoresValidos()) {
			this.coloresValidos.add(color);
		}
	}
	
	public Prenda(ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, boolean esDiscontinuo,
			int cantidadAProducir, String nombre, String descripcion, float porcentajeGanancia, ArrayList<Confeccion> confecciones,
			ArrayList<StockPrenda> stock){
		
		this.tallesValidos=tallesValidos;
		this.coloresValidos=coloresValidos;
		this.esDiscontinuo=esDiscontinuo;
		this.cantidadAProducir=cantidadAProducir;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.porcentajeGanancia=porcentajeGanancia;
		this.confecciones=confecciones;
		this.stock=stock;
	}
	
	public Prenda(ArrayList<String> tallesValidos, ArrayList<String> coloresValidos, int codigo, boolean esDiscontinuo,
			int cantidadAProducir, String nombre, String descripcion, float porcentajeGanancia, ArrayList<Confeccion> confecciones,
			ArrayList<StockPrenda> stock){
		
		this.tallesValidos=tallesValidos;
		this.coloresValidos=coloresValidos;
		this.codigo=codigo;
		this.esDiscontinuo=esDiscontinuo;
		this.cantidadAProducir=cantidadAProducir;
		this.nombre=nombre;
		this.descripcion=descripcion;
		this.porcentajeGanancia=porcentajeGanancia;
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
		return porcentajeGanancia;
	}

	public void setPorsentajeGanancia(float porsentajeGanancia) {
		this.porcentajeGanancia = porsentajeGanancia;
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
				porcentajeGanancia, confeccionesDto, stockDto);
	}
	
	public void saveMe() {
		PrendaDao.getInstance().AltaPrenda(this);
	}
}
