package negocio;

import exceptions.ColorException;

public enum EstadoOrdenProduccion {
	PENDIENTE(1),
	PRODUCCION(2),
	TERMINADA(3),
	MATERIAPRIMA(4);
	
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
		case 4: return MATERIAPRIMA;
		default:
			throw new ColorException("No se encuentra la materia Prima  para el valor: " + value);
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
		case MATERIAPRIMA:
			return "MateriaPrima";
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
		case "MATERIAPRIMA":
			return MATERIAPRIMA;
		default:
			throw new Exception("El estado '" + estado + "' no existe");
		}
	}
}
