package negocio;


public enum EstadoConfeccion {
	INCOMPLETO(1),		//sin terminar
	COMPLETO(2);		//terminada

	private int value;

	EstadoConfeccion(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	public  static EstadoConfeccion fromInt(int value) {   
		switch(value) {
		case 1: return INCOMPLETO;
		case 2: return COMPLETO;
		default: return null;
		}
	}

	public String toString() {
		switch(this) {
			case INCOMPLETO:
				return "Incompleto";
				
			case COMPLETO:
				return "Completo";
				
			default:
				return "INVALID";
		}
	}
	
	public static EstadoConfeccion fromString(String estado) {
		switch(estado.toUpperCase()) {
			case "INCOMPLETO":
				return INCOMPLETO;
			case "COMPLETO":
				return COMPLETO;
			
			default:
				return null;
		}
	}
}
