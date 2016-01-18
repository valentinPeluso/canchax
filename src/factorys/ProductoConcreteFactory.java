package factorys;

import java.util.List;

import modelo.Predio;
import modelo.Producto;
import modelo.Provedor;

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
	public Producto create(String codigo, String descripcion, List<Provedor> usuarios_venden_producto, int cantidad, float precio_compra,
			float precio_venta, String foto,List<Predio> predios_venden_producto) {
		// TODO Auto-generated method stub
		return new Producto(codigo,descripcion,cantidad,usuarios_venden_producto,precio_compra,precio_venta,foto,predios_venden_producto);
	}

}
