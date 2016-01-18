package factorys;

import java.util.ArrayList;
import java.util.List;

import modelo.Administrador;
import modelo.Empleado;
import modelo.Producto;
import modelo.Provedor;

public class UsuarioConcreteFactory extends UsuarioFactory {

	public UsuarioConcreteFactory() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Empleado createEmpleado(String nombre_apellido, List<String> emails, List<String> telefonos, String user,
			String pass) {
		return new Empleado(nombre_apellido,emails,telefonos,user,pass);
	}

	@Override
	public Administrador createAdministrador(String nombre_apellido, List<String> emails, List<String> telefonos,
			String user, String pass) {
		// TODO Auto-generated method stub
		return new Administrador(nombre_apellido,emails,telefonos,user,pass);
	}

	@Override
	public Provedor createProvedor(String nombre_apellido, List<String> emails, List<String> telefonos) {
		// TODO Auto-generated method stub
		List <Producto> productos = new ArrayList<Producto>();
		return new Provedor(nombre_apellido,emails,telefonos,productos);
	}

}
