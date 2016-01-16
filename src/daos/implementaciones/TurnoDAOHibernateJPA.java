package daos.implementaciones;

import daos.TurnoDAO;
import modelo.Turno;

public class TurnoDAOHibernateJPA extends GenericDAOHibernateJPA<Turno> implements TurnoDAO{

	public TurnoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Turno.class);
	}

}
