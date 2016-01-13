package usuario.modelo;

import java.util.List;

public class Usuario {

	public Usuario(long id, String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol) {
		super();
		this.id = id;
		this.nombre_apellido = nombre_apellido;
		this.emails = emails;
		this.telefonos = telefonos;
		this.rol = rol;
	}
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private String nombre_apellido;
	private List<String> emails;
	private List<String> telefonos;
	private Rol rol;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre_apellido() {
		return nombre_apellido;
	}
	public void setNombre_apellido(String nombre_apellido) {
		this.nombre_apellido = nombre_apellido;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public List<String> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}

}
