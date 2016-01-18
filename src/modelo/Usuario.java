package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1356997851258670941L;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nombre_apellido, List<String> emails, List<String> telefonos) {
		// TODO Auto-generated constructor stub
		super();		
		this.nombre_apellido = nombre_apellido;
		this.emails = emails;
		this.telefonos = telefonos;		
	}
	

	@Id
	@GeneratedValue
	private long id;
	private String nombre_apellido;
	
	@ElementCollection
    @CollectionTable(name="emails", joinColumns=@JoinColumn(name="ID_USUARIO"))
	@Column(name="email")
	private List<String> emails;
	
	@ElementCollection
    @CollectionTable(name="telefonos", joinColumns=@JoinColumn(name="ID_USUARIO"))
	@Column(name="telefono")
	private List<String> telefonos;		
	
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
}
