package negocio;

import exceptions.ApplicationException;
import exceptions.ColorException;

public enum TipoMovimientoStockPrendaEnum {
	Sistema(1),
	PorDeterioro(2),
	DiferenciaInventario(3);
	
	private int value;

	TipoMovimientoStockPrendaEnum(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	public static TipoMovimientoStockPrendaEnum fromInt(int value) throws ApplicationException {   
		switch(value) {
		case 1: return Sistema;
		case 2: return PorDeterioro;
		case 3: return DiferenciaInventario;
		default:
			throw new ApplicationException("No se encuentra el tipo de movimiento: " + value);
		}
	}

	public String toString() {
		switch(this) {
		case Sistema:
			return "Sistema";
		case PorDeterioro:
			return "Por Deterioro";
		case DiferenciaInventario:
			return "Diferencia Inventario";
		default:
			return "INVALID";
		}
	}
	
	public static TipoMovimientoStockPrendaEnum fromString(String estado) throws ApplicationException {
		switch(estado.toUpperCase()) {
		case "SISTEMA":
			return Sistema;
		case "POR DETERIORO":
			return PorDeterioro;
		case "DIFERENCIA INVENTARIO":
			return DiferenciaInventario;
		default:
			throw new ApplicationException("El estado '" + estado + "' no existe");
		}
	}
}
