package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	
	public Usuario(String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol,List<Predio> predios_en_donde_trabaja) {
		// TODO Auto-generated constructor stub
		super();		
		this.nombre_apellido = nombre_apellido;
		this.emails = emails;
		this.telefonos = telefonos;
		this.rol = rol;
		this.predios_trabaja = predios_en_donde_trabaja;
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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_ROL")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Rol rol;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "empleados")
	@Column(nullable = true)
	private List<Predio> predios_trabaja;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_producto", joinColumns = { 
			@JoinColumn(name = "ID_USUARIO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { 
					@JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) })
	@Column(nullable = true)
	private List<Producto> productos;
	
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

	public List<Predio> getPredios_en_donde_trabaja() {
		return predios_trabaja;
	}

	public void setPredios_en_donde_trabaja(List<Predio> predios_en_donde_trabaja) {
		this.predios_trabaja = predios_en_donde_trabaja;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
