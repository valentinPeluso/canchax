package modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class RolProvedor extends Rol implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5881039694380016458L;

	public RolProvedor(String descripcion, List<Producto> productos) {
		super(descripcion);
		this.productos = productos;
	}

	public RolProvedor() {
		// TODO Auto-generated constructor stub
	}

	@OneToMany()
	@JoinColumn(name="ID_ROL")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Producto> productos;

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
