package modelo;

import java.util.List;

public class RolProvedor extends Rol {

	public RolProvedor(String descripcion, List<Producto> productos) {
		super(descripcion);
		this.productos = productos;
	}

	public RolProvedor() {
		// TODO Auto-generated constructor stub
	}

	private List<Producto> productos;

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

}
