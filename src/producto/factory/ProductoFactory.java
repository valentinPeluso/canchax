package producto.factory;

import producto.modelo.Producto;
import usuario.modelo.Usuario;

public abstract class ProductoFactory {

	public ProductoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Producto create(String codigo, String descripcion);
	public abstract Producto create(String codigo, String descripcion,Usuario provedor, int cantidad, float precio_compra,float precio_venta,String foto);

}
