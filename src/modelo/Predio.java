package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Predio implements Serializable{
	
	private static final long serialVersionUID = 749601173011916634L;
	
	private static Predio instance = null;
	
	private long id;
	private String direccion;	
	private List<Empleado> empleados;	
	private List<Administrador> administradores;	
	private List<Provedor> provedores;	
	private List<Cancha> canchas;	
	private List<Turno> turnos;	
	private List<Producto> productos;	
	private List<Compra> compras_realizadas;	
	private List<Venta> ventas_realizadas;	
	
	public Predio() {
	    
	}	
	
	public Predio(String direccion, List<Empleado> empleados, List<Administrador> administradores,
			List<Provedor> provedores, List<Cancha> canchas, List<Turno> turnos, List<Producto> productos,
			List<Compra> compras, List<Venta> ventas) {
		super();
		this.direccion = direccion;
		this.empleados = empleados;
		this.administradores = administradores;
		this.provedores = provedores;
		this.canchas = canchas;
		this.turnos = turnos;
		this.productos = productos;
		this.ventas_realizadas = ventas;
		this.compras_realizadas = compras;
	}
	
	public static void setInstance(Predio instance) {
		Predio.instance = instance;
	}
	
	public static Predio getInstance() {	    
	     return instance;
	}	
	@Id
	@GeneratedValue
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
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	public List<Cancha> getCanchas() {
		return canchas;
	}
	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	public List<Turno> getTurnos() {
		return turnos;
	}
	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public List<Administrador> getAdministradores() {
		return administradores;
	}
	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public List<Provedor> getProvedores() {
		return provedores;
	}
	public void setProvedores(List<Provedor> provedores) {
		this.provedores = provedores;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	public List<Compra> getCompras_realizadas() {
		return compras_realizadas;
	}

	public void setCompras_realizadas(List<Compra> compras_realizadas) {
		this.compras_realizadas = compras_realizadas;
	}
	@OneToMany()
	@JoinColumn(name="ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@Column(nullable = true)
	public List<Venta> getVentas_realizadas() {
		return ventas_realizadas;
	}

	public void setVentas_realizadas(List<Venta> ventas_realizadas) {
		this.ventas_realizadas = ventas_realizadas;
	}
	
	public boolean checkIfTheUserExistInTheAdministradores(Usuario usuario){
		//verifico si dentro de la colleción de administradores existe el usuarios repetidos
		return true;
	}
	
	public boolean checkIfTheUserExistInTheEmpleados(Usuario usuario){
		//verifico si dentro de la colleción de empelados existe el usuarios repetidos
		return true;
	}
	
	public boolean checkIfTheUserExistInTheProvedores(Usuario usuario){
		//verifico si dentro de la colleción de provedores existe el usuarios repetidos
		return true;
	}
}
