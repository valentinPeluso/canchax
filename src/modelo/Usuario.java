package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

import javax.persistence.Id;


@Entity
public class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1356997851258670941L;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol) {
		// TODO Auto-generated constructor stub
		super();		
		this.nombre_apellido = nombre_apellido;
		this.emails = emails;
		this.telefonos = telefonos;
		this.rol = rol;
	}
	@Id
	@GeneratedValue
	private long id;
	private String nombre_apellido;
	
	@ElementCollection
    @CollectionTable(name="emails", joinColumns=@JoinColumn(name="usuario_id"))
	@Column(name="email")
	private List<String> emails;
	
	@ElementCollection
    @CollectionTable(name="telefonos", joinColumns=@JoinColumn(name="usuario_id"))
	@Column(name="telefono")
	private List<String> telefonos;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_USUARIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
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
