package usuario.factory;

import java.util.List;

import usuario.modelo.Usuario;
import usuario.rol.modelo.Rol;

public abstract class UsuarioFactory {

	public UsuarioFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Usuario create(String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol);

}
