package factorys;

import java.util.List;

import modelo.Predio;
import modelo.Producto;
import modelo.Usuario;

public abstract class ProductoFactory {

	public ProductoFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Producto create(String codigo, String descripcion);
	public abstract Producto create(String codigo, String descripcion,List<Usuario> usuarios_venden_producto, int cantidad, float precio_compra,float precio_venta,String foto,List<Predio> predios_venden_producto);

}
