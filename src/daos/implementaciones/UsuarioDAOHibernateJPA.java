package daos.implementaciones;

import daos.UsuarioDAO;
import modelo.Usuario;

public class UsuarioDAOHibernateJPA extends GenericDAOHibernateJPA<Usuario> implements UsuarioDAO{

	public UsuarioDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Usuario.class);
	}

}
