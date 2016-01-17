package factorys;

import java.util.ArrayList;
import java.util.List;

import modelo.Predio;
import modelo.Rol;
import modelo.Usuario;

public class UsuarioConcreteFactory extends UsuarioFactory {

	public UsuarioConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario create(String nombre_apellido, List<String> emails, List<String> telefonos, Rol rol) {
		// TODO Auto-generated method stub
		List <Predio> predios_trabaja = new ArrayList<Predio>();
		predios_trabaja.add(Predio.getInstance());
		return new Usuario(nombre_apellido,emails,telefonos,rol,predios_trabaja);
	}

	@Override
	public Usuario create(String nombre_apellido, Rol rol) {
		// TODO Auto-generated method stub
		List<String> emails = new ArrayList<String>();
		List<String> telefonos = new ArrayList<String>();
		List <Predio> predios_trabaja = new ArrayList<Predio>();
		predios_trabaja.add(Predio.getInstance());
		return new Usuario(nombre_apellido,emails,telefonos,rol,predios_trabaja);
	}

}
