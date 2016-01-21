package daos.implementaciones;

import daos.AdministradorDAO;
import modelo.Administrador;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO{

	public AdministradorDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Administrador.class);
	}

}