package negocio;

import java.util.ArrayList;
import java.util.Hashtable;

import dao.AreaProduccionDao;
import dao.MateriaPrimaDao;
import dao.PrendaDao;
import dto.ConfeccionDto;
import dto.InsumoDto;
import dto.PrendaDto;
import dto.StockPrendaDto;
import entity.ConfeccionEntity;
import entity.PrendaEntity;
import entity.StockPrendaEntity;
import exceptions.ColorException;

public class Prenda {

	private ArrayList<String> tallesValidos;
	private ArrayList<ColorPrenda> coloresValidos;
	private int codigo;
	private boolean esDiscontinuo;
	private int cantidadAProducir;
	private String nombre;
	private String descripcion;
	private float porcentajeGanancia;
	private ArrayList<Confeccion> confecciones;
	private ArrayList<StockPrenda> stock;
	
	public Prenda(PrendaEntity prenda) {
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
		
		for (Integer color : prenda.getColoresValidos()) {
			try {
				this.coloresValidos.add(ColorPrenda.fromInt(color));
			} catch (ColorException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Prenda(PrendaDto prendaDto) throws ColorException {
		ArrayList<Confeccion> confecciones = new ArrayList<Confeccion>();
		ArrayList<ColorPrenda> colores = new ArrayList<>();
		
		for (ConfeccionDto confeccionDto : prendaDto.getConfecciones()) {
			
			AreaProduccion areaProd = AreaProduccionDao.getInstance().getById(confeccionDto.getAreaProduccion());
			
			ArrayList<Insumo> insumos = new ArrayList<Insumo>();
			for (InsumoDto insumoDto : confeccionDto.getInsumos()) {
				insumos.add(new Insumo(insumoDto.getCantidad(), insumoDto.getDesperdicio(), MateriaPrimaDao.getInstance().getById(insumoDto.getMateriaPrima())));
			}
			
			Confeccion confeccion = new Confeccion(confeccionDto.getTiempoProd(), confeccionDto.getDetalle(), areaProd, insumos);
			
			confecciones.add(confeccion);
		}
		
		for (String color : prendaDto.getColoresValidos())
			colores.add(ColorPrenda.fromString(color));
		
		
		this.tallesValidos = prendaDto.getTallesValidos(); 
		this.coloresValidos = colores;
		this.esDiscontinuo = prendaDto.getEsDiscontinuo();
		this.cantidadAProducir = prendaDto.getCantidadAProducir();
		this.nombre = prendaDto.getNombre();
		this.descripcion = prendaDto.getDescripcion();
		this.porcentajeGanancia = prendaDto.getPorcentajeGanancia();
		this.confecciones = confecciones;
		this.stock = new ArrayList<StockPrenda>(); //TODO: levantar StockPrenda del dto???
		
	}
	
	public Prenda(ArrayList<String> tallesValidos, ArrayList<ColorPrenda> coloresValidos, boolean esDiscontinuo,
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
	
	public Prenda(ArrayList<String> tallesValidos, ArrayList<ColorPrenda> coloresValidos, int codigo, boolean esDiscontinuo,
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
	public ArrayList<ColorPrenda> getColoresValidos() {
		return coloresValidos;
	}
	public void setColoresValidos(ArrayList<ColorPrenda> coloresValidos) {
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
	
	//Devuelve la cantidad a producir de un talle 1 y color (ej remera verde Small)
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
		Float valor = 0F;
		
		for (Confeccion confeccion : this.confecciones) {
			
			for (Insumo insumo : confeccion.getInsumos()) {
				
				valor = valor + insumo.calcularCosto();
			}
		}
		
		Float ganancia = 1 + this.porcentajeGanancia / 100;
		
		return valor * ganancia;
	}
	
	public Hashtable<MateriaPrima, Integer> CalcularCantidadMateriaPrimaTotal(){
		Hashtable<MateriaPrima, Integer> materiasPrimasNecesarias = new Hashtable<MateriaPrima, Integer>();
		
		for (Confeccion confeccion : this.confecciones) {
			for (Insumo insumo : confeccion.getInsumos()) {
				if(materiasPrimasNecesarias.containsKey(insumo.getMateriaPrima())){
					
					int cantidadVieja = materiasPrimasNecesarias.get(insumo.getMateriaPrima());
					int cantidadNueva = cantidadVieja + insumo.getCantidad();
					
					materiasPrimasNecesarias.replace(insumo.getMateriaPrima(), cantidadVieja, cantidadNueva);
					
				}else
					materiasPrimasNecesarias.put(insumo.getMateriaPrima(), insumo.getCantidad());
			}
		}
		
		return materiasPrimasNecesarias;
	}
	
	//TODO: nose si va aca, revisar
	public boolean hayStockSuficiente(int cantidad){
		return true;
	}
	
	public PrendaDto toDto(){
		ArrayList<ConfeccionDto> confeccionesDto =new ArrayList<>();
		ArrayList<StockPrendaDto> stockDto = new ArrayList<>();
		ArrayList<String> coloresValidosDto = new ArrayList<>();
		
		for (StockPrenda stockPrenda : stock) {
			stockDto.add(stockPrenda.toDto());
		}
		
		for (Confeccion confeccion : confecciones) {
			confeccionesDto.add(confeccion.toDto());
		}
		
		for (ColorPrenda color : coloresValidos) {
			coloresValidosDto.add(color.toString());
		}
		
		return new PrendaDto(tallesValidos, coloresValidosDto, codigo, esDiscontinuo, cantidadAProducir, nombre, descripcion,
				porcentajeGanancia, confeccionesDto, stockDto);
	}
	
	public void saveMe() {
		PrendaDao.getInstance().AltaPrenda(this);
	}
	
	public void deleteMe() {
		PrendaDao.getInstance().EliminarPrenda(this);
	}
	
	public void modificame() {
		PrendaDao.getInstance().ModificarPrenda(this);
	}
	
	//Devuelve cuanto tarda en hacerse una sola prenda (ej una remera verde Small) en horas
	public float calcularCantidadHorasConfeccion() {
		float total = 0;
		
		for(Confeccion confeccion : this.getConfecciones()) {
			total += confeccion.getTiempoProd();
		}
		
		return total;
	}
	
	//Devuelve cuanto tarda en hacerse una sola prenda (ej una remera verde Small) en dias
	public int calcularCantidadDiasConfeccion() {
		return (int) (this.calcularCantidadHorasConfeccion()/24);
	}
}
