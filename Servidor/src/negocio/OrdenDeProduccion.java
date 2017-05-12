package negocio;

import java.util.ArrayList;

import dto.MateriaPrimaDto;
import dto.OrdenDeProduccionDto;
import entity.MateriaPrimaEntity;
import entity.OrdenDeProduccionEntity;

public abstract class OrdenDeProduccion {
	
	private int nroOrden;
	private String estado;
	private ArrayList<MateriaPrima> materiaPrimaReservada;
	private int confeccionesTerminadas;
	private PedidoPrendas pedido;
	private Prenda prenda;
	
	
	public OrdenDeProduccion(OrdenDeProduccionEntity op){
		ArrayList<MateriaPrima> materiasPrimasReservadas = new ArrayList<>();
		for (MateriaPrimaEntity materiaPrimaEntity : op.getMateriaPrimaReservada()) {
			materiasPrimasReservadas.add(new MateriaPrima(materiaPrimaEntity));
		}
		
		this.nroOrden = op.getNroOrden();
		this.estado=op.getEstado();
		this.confeccionesTerminadas=op.getConfeccionesTerminadas();
		this.materiaPrimaReservada=materiasPrimasReservadas;
		this.pedido=new PedidoPrendas(op.getPedidoPrenda());
		this.prenda=new Prenda(op.getPrenda());
	}
	
	public OrdenDeProduccion(int nroOrden, String estado,ArrayList<MateriaPrima> materiaPrimaReservada, PedidoPrendas pedido, Prenda prenda){
		this.nroOrden = nroOrden;
		this.estado=estado;
		this.materiaPrimaReservada=materiaPrimaReservada;
		this.confeccionesTerminadas=0;
		this.pedido=pedido;
		this.prenda=prenda;
	}
	
	
	public int getNroOrden() {
		return nroOrden;
	}
	public void setNroOrden(int nroOrden) {
		this.nroOrden = nroOrden;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public ArrayList<MateriaPrima> getMateriaPrimaReservada() {
		return materiaPrimaReservada;
	}
	public void setMateriaPrimaReservada(ArrayList<MateriaPrima> materiaPrimaReservada) {
		this.materiaPrimaReservada = materiaPrimaReservada;
	}
	public int getConfeccionesTerminadas() {
		return confeccionesTerminadas;
	}
	public void setConfeccionesTerminadas(int confeccionesTerminadas) {
		this.confeccionesTerminadas = confeccionesTerminadas;
	}
	public PedidoPrendas getPedido() {
		return pedido;
	}
	public void setPedido(PedidoPrendas pedido) {
		this.pedido = pedido;
	}
	public Prenda getPrenda() {
		return prenda;
	}
	public void setPrenda(Prenda prenda) {
		this.prenda = prenda;
	}
	public abstract int getCantidad();
	
	
	public OrdenDeProduccionDto toDto(){
		ArrayList<MateriaPrimaDto> materiaPrimaReservadaDto = new ArrayList<>();
		
		for (MateriaPrima materiaPrima : materiaPrimaReservada) {
			materiaPrimaReservadaDto.add(materiaPrima.toDto());
		}
		
		return new OrdenDeProduccionDto(nroOrden, estado, materiaPrimaReservadaDto, pedido.toDto(), prenda.toDto());
	}
	
}
