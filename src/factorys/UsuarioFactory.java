package factorys;

import java.util.List;

import modelo.Rol;
import modelo.Usuario;

public abstract class UsuarioFactory {

	public UsuarioFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Usuario create(String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol);

}
