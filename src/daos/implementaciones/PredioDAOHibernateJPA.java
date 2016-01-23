package daos.implementaciones;

import daos.PredioDAO;
import modelo.Predio;

public class PredioDAOHibernateJPA extends GenericDAOHibernateJPA<Predio> implements PredioDAO{

	public PredioDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Predio.class);
	}
}
