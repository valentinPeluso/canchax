package factorys;

import modelo.Producto;

public abstract class ProductoFactory {

	public ProductoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Producto create(String codigo, String descripcion);
	public abstract Producto create(String codigo, String descripcion, int cantidad, float precio_compra,float precio_venta,String foto);

}
