package daos.implementaciones;

import daos.LogDAO;
import logs.Log;

public class LogDAOHibernateJPA extends GenericDAOHibernateJPA<Log> implements LogDAO {

	public LogDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Log.class);
	}

}
