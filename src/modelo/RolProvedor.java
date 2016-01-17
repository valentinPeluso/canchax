package modelo;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class RolProvedor extends Rol implements Serializable{
	
	private static final long serialVersionUID = -5881039694380016458L;

	public RolProvedor(String descripcion) {
		super(descripcion);
	}

	public RolProvedor() {
		// TODO Auto-generated constructor stub
	}

}
