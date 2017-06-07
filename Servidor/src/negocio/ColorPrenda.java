package negocio;

import exceptions.ColorException;

public enum ColorPrenda {
	ROJO(1),
	AZUL(2),
	NEGRO(3),
	BLANCO(4),
	VERDE(5),
	AMARILLO(6),
	NARANJA(7);

	private int value;

	ColorPrenda(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	public  static ColorPrenda fromInt(int value) throws ColorException {   
		switch(value) {
		case 1: return ROJO;
		case 2: return AZUL;
		case 3: return NEGRO;
		case 4: return BLANCO;
		case 5: return VERDE;
		case 6: return AMARILLO;
		case 7: return NARANJA;
		default:
			throw new ColorException("No se encuentra el color para el valor: " + value);
		}
	}

	public String toString() {
		switch(this) {
		case ROJO:
			return "Rojo";
		case AZUL:
			return "Azul";
		case NEGRO:
			return "Negro";
		case BLANCO:
			return "Blanco";
		case VERDE:
			return "Verde";
		case AMARILLO:
			return "Amarillo";
		case NARANJA:
			return "Naranja";
		default:
			return "INVALID";
		}
	}
	
	public static ColorPrenda fromString(String color) throws ColorException {
		switch(color.toUpperCase()) {
		case "ROJO":
			return ROJO;
		case "AZUL":
			return AZUL;
		case "NEGRO":
			return NEGRO;
		case "BLANCO":
			return BLANCO;
		case "VERDE":
			return VERDE;
		case "AMARILLO":
			return AMARILLO;
		case "NARANJA":
			return NARANJA;
		default:
			throw new ColorException("El color '" + color + "' no existe");
		}
	}
}
