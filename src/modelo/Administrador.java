package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;

@Entity
public class Administrador extends Usuario implements Serializable{	
	
	private static final long serialVersionUID = 6897211563051964041L;

	private String user;
	private String pass;	

	public Administrador(String nombre_apellido, List<String> emails, List<String> telefonos,String user, String pass) {
		super(nombre_apellido, emails, telefonos);
		this.user = user;
		this.pass = pass;
	}

	public Administrador() {
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
