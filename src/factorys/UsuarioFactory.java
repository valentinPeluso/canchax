package factorys;

import java.util.List;

import modelo.Administrador;
import modelo.Empleado;
import modelo.Provedor;

public abstract class UsuarioFactory {

	public UsuarioFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Empleado createEmpleado(String nombre_apellido, List<String> emails, List<String> telefonos, String user, String pass);
	public abstract Administrador createAdministrador(String nombre_apellido, List<String> emails, List<String> telefonos, String user, String pass);
	public abstract Provedor createProvedor(String nombre_apellido, List<String> emails, List<String> telefonos);

}
