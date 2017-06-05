package negocio;


import dao.InsumoDao;
import dto.InsumoDto;
import entity.InsumoEntity;

public class Insumo {
	private int cantidad;
	private int desperdicio;
	private int precio;
	private MateriaPrima materiaPrima;
	
	
	public Insumo(InsumoEntity insumo){
		this.cantidad=insumo.getCantidad();
		this.desperdicio=insumo.getDesperdicio();
		this.materiaPrima=new MateriaPrima(insumo.getMateriaPrima());
		this.precio = insumo.getPrecio();
	}
	
	public Insumo(int cantidad, int desperdicio, MateriaPrima materiaPrima,int precio){
		this.cantidad=cantidad;
		this.desperdicio=desperdicio;
		this.materiaPrima=materiaPrima;
		this.precio=precio;
	}

	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getDesperdicio() {
		return desperdicio;
	}
	public void setDesperdicio(int desperdicio) {
		this.desperdicio = desperdicio;
	}
	public void setMateriaPrima(MateriaPrima materiaPrima) {
		this.materiaPrima = materiaPrima;
	}
	public MateriaPrima getMateriaPrima(){
		return this.materiaPrima;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public InsumoDto toDto(){
		return new InsumoDto(cantidad, desperdicio, materiaPrima.toDto(),precio);
	}
	
	
	public void saveMe() {
		InsumoDao.getInstance().crearInsumo(this);
	}
	
	
	@Override
	public String toString() {
		return this.cantidad + " de " +this.materiaPrima.getNombre() ;
	}
}
