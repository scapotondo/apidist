package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="OrdenDeProduccion")
public class AdministracionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy="administracion")
	private List<ClienteEntity> clientes;
	
	@OneToMany(mappedBy="administracion")
	private List<PrendaEntity> prendas;
	
	public AdministracionEntity(){}

}
