package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Provedor extends Usuario implements Serializable{
	
	public Provedor(String nombre_apellido, List<String> emails, List<String> telefonos,List<Producto> productos) {
		super(nombre_apellido, emails, telefonos);
		this.productos = productos;
	}

	private static final long serialVersionUID = -5881039694380016458L;
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_producto", joinColumns = { 
			@JoinColumn(name = "ID_USUARIO", nullable = false, updatable = false) }, 
			inverseJoinColumns = { 
					@JoinColumn(name = "ID_PRODUCTO", nullable = false, updatable = false) })
	@Column(nullable = true)
	private List<Producto> productos;
	
	public Provedor() {
		// TODO Auto-generated constructor stub
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
