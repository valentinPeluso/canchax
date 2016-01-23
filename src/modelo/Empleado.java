package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Empleado extends Usuario implements Serializable {
	
	private static final long serialVersionUID = -7351564284248335810L;
	private String user;
	private String pass;
	
	public Empleado(String nombre_apellido, List<String> emails, List<String> telefonos,String user, String pass) {
		super(nombre_apellido, emails, telefonos);
		this.user = user;
		this.pass = pass;
	}	

	public Empleado() {
		// TODO Auto-generated constructor stub
	}	
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
}
