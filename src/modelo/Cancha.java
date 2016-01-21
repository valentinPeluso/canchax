package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cancha implements Serializable {
	
	public Cancha(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	private static final long serialVersionUID = -8741863440005330443L;

	public Cancha() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	
	private long id;
	private String descripcion;

	@Id
	@GeneratedValue
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
