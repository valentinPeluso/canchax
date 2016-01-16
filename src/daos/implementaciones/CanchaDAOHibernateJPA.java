package daos.implementaciones;

import daos.CanchaDAO;
import modelo.Cancha;

public class CanchaDAOHibernateJPA extends GenericDAOHibernateJPA<Cancha> implements CanchaDAO{

	public CanchaDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Cancha.class);
	}

}
