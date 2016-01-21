package modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Provedor extends Usuario implements Serializable{
	
	public Provedor(String nombre_apellido, List<String> emails, List<String> telefonos,List<Producto> productos) {
		super(nombre_apellido, emails, telefonos);
		this.productos = productos;
	}
	public Provedor() {
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = -5881039694380016458L;
	
	private List<Producto> productos;
	
	@OneToMany()
	@JoinColumn(name="ID_PROVEDOR")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
