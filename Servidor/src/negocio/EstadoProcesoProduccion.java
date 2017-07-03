package negocio;


public enum EstadoProcesoProduccion {
	INCOMPLETO(1),		//sin terminar
	PRODUCCION(2),		//en produccion
	COMPLETO(3);		//terminada
	

	private int value;

	EstadoProcesoProduccion(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	public  static EstadoProcesoProduccion fromInt(int value) {   
		switch(value) {
		case 1: return INCOMPLETO;
		case 2: return PRODUCCION;
		case 3: return COMPLETO;
		default: return null;
		}
	}

	public String toString() {
		switch(this) {
			case INCOMPLETO:
				return "Incompleto";
				
			case PRODUCCION:
				return "Produccion";
				
			case COMPLETO:
				return "Completo";
				
			default:
				return "INVALID";
		}
	}
	
	public static EstadoProcesoProduccion fromString(String estado) {
		switch(estado.toUpperCase()) {
			case "INCOMPLETO":
				return INCOMPLETO;
			case "PRODUCCION":
				return PRODUCCION;
			case "COMPLETO":
				return COMPLETO;
			
			default:
				return null;
		}
	}
}
