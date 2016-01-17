package modelo;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class RolAdministrador extends Rol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6897211563051964041L;

	public RolAdministrador(String descripcion, String user, String pass) {
		super(descripcion);
		this.user = user;
		this.pass = pass;
	}

	private String user;
	private String pass;	

	public RolAdministrador() {
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
