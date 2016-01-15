package usuario.factory;

import java.util.List;

import usuario.modelo.Usuario;
import usuario.rol.modelo.Rol;

public class UsuarioConcreteFactory extends UsuarioFactory {

	public UsuarioConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario create(String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol) {
		// TODO Auto-generated method stub
		return new Usuario(nombre_apellido,emails,telefonos,rol);
	}

}
