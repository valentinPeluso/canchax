package factorys;

import modelo.Producto;
import modelo.Usuario;

public class ProductoConcreteFactory extends ProductoFactory{

	public ProductoConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Producto create(String codigo, String descripcion) {
		// TODO Auto-generated method stub
		return new Producto(codigo,descripcion);
	}

	@Override
	public Producto create(String codigo, String descripcion, Usuario provedor, int cantidad, float precio_compra,
			float precio_venta, String foto) {
		// TODO Auto-generated method stub
		return new Producto(codigo,descripcion,provedor,cantidad,precio_compra,precio_venta,foto);
	}

}
