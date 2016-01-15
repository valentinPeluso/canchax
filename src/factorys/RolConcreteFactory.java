package factorys;

import java.util.ArrayList;
import java.util.List;

import modelo.Producto;
import modelo.RolAdministrador;
import modelo.RolEmpleado;
import modelo.RolProvedor;

public class RolConcreteFactory extends RolFactory {

	public RolConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public RolAdministrador createRolAdministrador(String descripcion, String user, String pass) {
		// TODO Auto-generated method stub
		return new RolAdministrador(descripcion,user,pass);
	}

	@Override
	public RolEmpleado createRolEmpleado(String descripcion, String user, String pass) {
		// TODO Auto-generated method stub
		return new RolEmpleado(descripcion,user,pass);
	}

	@Override
	public RolProvedor createRolProvedor(String descripcion) {
		// TODO Auto-generated method stub
		List<Producto> productos = new ArrayList<Producto>();
		return new RolProvedor(descripcion,productos);
	}

}
