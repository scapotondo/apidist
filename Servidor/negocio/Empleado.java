package negocio;

public class Empleado {

	private String nombre;
	private String domicilio;
	private String telefono;
	private int legajo;
	
	public Empleado(String nombre, String domicilio, String telefono, int legajo){
		this.nombre=nombre;
		this.domicilio=domicilio;
		this.telefono=telefono;
		this.legajo=legajo;
	}
}
