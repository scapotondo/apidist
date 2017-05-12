package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Administracion")
public class AdministracionEntity implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	@OneToMany()
//	@JoinColumn(name="administraction_id")
//	private List<ClienteEntity> clientes;
//	
//	@OneToMany()
//	@JoinColumn(name="administraction_id")
//	private List<PrendaEntity> prendas;
	
	public AdministracionEntity(){}

}
