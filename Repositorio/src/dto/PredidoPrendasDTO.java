package dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import negocio.Cliente;
import negocio.ItemPrenda;
import negocio.OrdenDeProduccion;

public class PredidoPrendasDTO implements Serializable{
	
	private int nroPedido;
	private Date fechaProbableDespacho;
	private String estado;
	private Date fechaGeneracion;
	private Date fechaRealDespacho;
	private OrdenDeProduccion ordenProduccion;
	private Cliente cliente;
	private ArrayList<ItemPrenda> items;

}
