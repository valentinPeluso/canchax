package daos.implementaciones;

import daos.EmpleadoDAO;
import modelo.Empleado;

public class EmpleadoDAOHibernateJPA extends GenericDAOHibernateJPA<Empleado> implements EmpleadoDAO{

	public EmpleadoDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Empleado.class);
	}

}
