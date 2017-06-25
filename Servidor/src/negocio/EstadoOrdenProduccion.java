package negocio;

import exceptions.ColorException;

public enum EstadoOrdenProduccion {
	PENDIENTE(1),
	PRODUCCION(2),
	TERMINADA(3);
	
	private int value;

	EstadoOrdenProduccion(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	public  static EstadoOrdenProduccion fromInt(int value) throws ColorException {   
		switch(value) {
		case 1: return PENDIENTE;
		case 2: return PRODUCCION;
		case 3: return TERMINADA;
		default:
			throw new ColorException("No se encuentra el color para el valor: " + value);
		}
	}

	public String toString() {
		switch(this) {
		case PENDIENTE:
			return "Pendiente";
		case PRODUCCION:
			return "Produccion";
		case TERMINADA:
			return "Terminada";
		default:
			return "INVALID";
		}
	}
	
	public static EstadoOrdenProduccion fromString(String estado) throws Exception {
		switch(estado.toUpperCase()) {
		case "PENDIENTE":
			return PENDIENTE;
		case "PRODUCCION":
			return PRODUCCION;
		case "TERMINADA":
			return TERMINADA;
		default:
			throw new Exception("El estado '" + estado + "' no existe");
		}
	}
}
