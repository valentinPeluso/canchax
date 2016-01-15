package factorys;

import java.util.List;

import modelo.Rol;
import modelo.Usuario;

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
