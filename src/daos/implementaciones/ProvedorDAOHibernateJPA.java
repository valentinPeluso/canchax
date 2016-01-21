package daos.implementaciones;

import daos.ProvedorDAO;
import modelo.Provedor;

public class ProvedorDAOHibernateJPA extends GenericDAOHibernateJPA<Provedor> implements ProvedorDAO{

	public ProvedorDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Provedor.class);
	}

}