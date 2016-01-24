package daos;

import java.util.Date;
import java.util.List;

import modelo.Administrador;
import modelo.Cancha;
import modelo.Compra;
import modelo.Empleado;
import modelo.Predio;
import modelo.Producto;
import modelo.Provedor;
import modelo.Turno;
import modelo.Venta;

public interface PredioDAO extends GenericDAO<Predio>{	
	
	public List<Empleado> getEmpleados(long id);
	public List<Administrador> getAdministradores(long id);
	public List<Provedor> getProvedores(long id);
	public List<Cancha> getCanchas(long id);
	public List<Turno> getTurnos(long id,Date desde, Date hasta);
	public List<Producto> getProductos(long id);
	public List<Compra> getCompras(long id);
	public List<Venta> getVentas(long id);
}
