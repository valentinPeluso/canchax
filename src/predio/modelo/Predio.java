package predio.modelo;

import java.util.List;

import cancha.modelo.Cancha;
import producto.modelo.Producto;
import turnos.modelo.Turno;
import usuario.modelo.Usuario;

public class Predio {

	public Predio(long id, String direccion, List<Usuario> empleados, List<Cancha> canchas, List<Turno> turnos,
			List<Producto> productos) {
		super();
		this.id = id;
		this.direccion = direccion;
		this.empleados = empleados;
		this.canchas = canchas;
		this.turnos = turnos;
		this.productos = productos;
	}
	
	public Predio() {
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private String direccion;
	private List<Usuario> empleados;
	private List<Cancha> canchas;
	private List<Turno> turnos;
	private List<Producto> productos;
	
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
