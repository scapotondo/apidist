
package dto;

import java.io.Serializable;

public enum RolUsuarioEnum implements Serializable{
	Cliente,
	Admin,
	Almacen,
	Despacho;
	
	public  String toString(){
		switch (this) {
			case Cliente: return "CLIENTE";
			case Admin: return "ADMIN";
			case Almacen: return "ALMACEN";
			case Despacho: return "DESPACHO";
			default: return null;
		}
	}
	
	public static RolUsuarioEnum fromString(String value){
		switch (value.toUpperCase()) {
		case "CLIENTE": return Cliente;
		case "ADMIN": return Admin;
		case "ALMACEN": return Almacen;
		case "DESPACHO": return Despacho;
		default: return null;
	}
	}
}
