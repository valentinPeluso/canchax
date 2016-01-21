package factorys;

import modelo.Producto;

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
	public Producto create(String codigo, String descripcion, int cantidad, float precio_compra,float precio_venta, String foto) {
		// TODO Auto-generated method stub
		return new Producto(codigo,descripcion,cantidad,precio_compra,precio_venta,foto);
	}

}
