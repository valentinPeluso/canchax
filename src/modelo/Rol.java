package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2032453365123805230L;

	public Rol(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	
	public Rol() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue
	private long id;
	private String descripcion;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
