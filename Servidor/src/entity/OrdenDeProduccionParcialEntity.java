package entity;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;

import negocio.OrdenProduccionParcial;

@Entity
@DiscriminatorValue(value="parcial")
public class OrdenDeProduccionParcialEntity extends OrdenDeProduccionEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ElementCollection
	private List<String> tallesValidos;
	
	@ElementCollection
	private List<String> coloresValidos;
	
	public OrdenDeProduccionParcialEntity(){}
	
	public OrdenDeProduccionParcialEntity(OrdenProduccionParcial orden){
		super(orden);
		this.tallesValidos = orden.getTalles();
		this.coloresValidos = orden.getColores();
	}

	public List<String> getTallesValidos() {
		return tallesValidos;
	}

	public void setTallesValidos(List<String> tallesValidos) {
		this.tallesValidos = tallesValidos;
	}

	public List<String> getColoresValidos() {
		return coloresValidos;
	}

	public void setColoresValidos(List<String> coloresValidos) {
		this.coloresValidos = coloresValidos;
	}
	
	
}
	