package factorys;

import modelo.RolAdministrador;
import modelo.RolEmpleado;
import modelo.RolProvedor;

public abstract class RolFactory {

	public RolFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract RolAdministrador createRolAdministrador(String descripcion, String user, String pass);
	public abstract RolEmpleado createRolEmpleado(String descripcion, String user, String pass);
	public abstract RolProvedor createRolProvedor(String descripcion);

}
