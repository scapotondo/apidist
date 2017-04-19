package negocio;

public class Proveedor {

	private String telefono;
	private String nombre;
	private String domicilio;
	private String cuit;
	private String cbu;
	
	public Proveedor(String telefono, String nombre, String domicilio, String cuit, String cbu){
		this.telefono=telefono;
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.cuit=cuit;
		this.cbu=cbu;
	}
}
