package negocio;

public enum EstadoPedidoPrenda {
	Desconocido(0),
	Nuevo(1),
	PendienteDeAceptacion(2),  //Aceptado por el Admin
	EnProduccion(3),		   //Aceptado por el cliente
	Terminado(4),			   //Ya se despacho
	RechazadoAdmin(5),
	CanceladoCliente(6),
	Despacho(7);			   //Listo para despachar
	
	private int value;

	EstadoPedidoPrenda(int value) {
		this.value = value;
	}

	public int toInt() {
		return value;
	}

	public  static EstadoPedidoPrenda fromInt(int value) {   
		switch(value) {
		case 0: return Desconocido;
		case 1: return Nuevo;
		case 2: return PendienteDeAceptacion;
		case 3: return EnProduccion;
		case 4: return Terminado;
		case 5: return RechazadoAdmin;
		case 6: return CanceladoCliente;
		case 7: return Despacho;
		default:
			return Desconocido;
		}
	}

	public String toString() {
		switch(this) {
		case Desconocido:
			return "Desconocido";
		case Nuevo:
			return "Nuevo";
		case PendienteDeAceptacion:
			return "Pendiente De Aceptacion";
		case EnProduccion:
			return "En Produccion";
		case Terminado:
			return "Terminado";
		case RechazadoAdmin:
			return "Rechazado";
		case CanceladoCliente:
			return "Cancelado";
		case Despacho:
			return "Despacho";
		default:
			return "Desconocido";
		}
	}
	
	public static EstadoPedidoPrenda fromString(String color) {
		switch(color.toUpperCase()) {
		case "DESCONOCIDO":
			return Desconocido;
		case "NUEVO":
			return Nuevo;
		case "PENDIENTE DE ACEPTACION":
			return PendienteDeAceptacion;
		case "EN PRODUCCION":
			return EnProduccion;
		case "TERMINADO":
			return Terminado;
		case "RECHAZADO":
			return RechazadoAdmin;
		case "CANCELADO":
			return CanceladoCliente;
		case "DESPACHO":
			return Despacho;
		default:
			return Desconocido;
		}
	}
}
