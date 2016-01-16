package daos.implementaciones;

import daos.ProductoDAO;
import modelo.Producto;

public class ProductoDAOHibernateJPA extends GenericDAOHibernateJPA<Producto> implements ProductoDAO {

	public ProductoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Producto.class);
	}

}
