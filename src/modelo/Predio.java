package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Predio implements Serializable{
	
	private static final long serialVersionUID = 749601173011916634L;

	//singleton
	private static Predio instance = null;

	@Id
	@GeneratedValue
	private long id;
	private String direccion;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "predio_usuario", joinColumns = { 
			@JoinColumn(name = "ID_PREDIO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { 
					@JoinColumn(name = "ID_USUARIO", nullable = false, updatable = false) })
	@Column(nullable = true)
	private List<Usuario> empleados;
	
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	private List<Cancha> canchas;
	
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	private List<Turno> turnos;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "predio_producto", joinColumns = { 
			@JoinColumn(name = "ID_PREDIO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { 
					@JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) })
	@Column(nullable = true)
	private List<Producto> productos;
	
	public Predio() {
	    
	}	
	
	public Predio(String direccion, ArrayList<Usuario> empleados, ArrayList<Cancha> canchas,
			ArrayList<Turno> turnos, ArrayList<Producto> productos) {
		// TODO Auto-generated constructor stub
		super();		
		this.direccion = direccion;
		this.empleados = empleados;
		this.canchas = canchas;
		this.turnos = turnos;
		this.productos = productos;
	}

	public static Predio getInstance() {
	     if(instance == null) {
	         instance = new Predio();
	     }
	     return instance;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public List<Usuario> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Usuario> empleados) {
		this.empleados = empleados;
	}
	public List<Cancha> getCanchas() {
		return canchas;
	}
	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}
	public List<Turno> getTurnos() {
		return turnos;
	}
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	

}
