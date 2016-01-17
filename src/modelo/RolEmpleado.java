package modelo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class RolEmpleado extends Rol implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7351564284248335810L;

	public RolEmpleado(String descripcion, String user, String pass) {
		super(descripcion);
		this.user = user;
		this.pass = pass;
	}
	
	public RolEmpleado() {
		// TODO Auto-generated constructor stub
	}
	
	private String user;
	private String pass;
	
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
