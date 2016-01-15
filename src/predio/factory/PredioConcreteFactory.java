package predio.factory;

import java.util.ArrayList;

import cancha.modelo.Cancha;
import predio.modelo.Predio;
import producto.modelo.Producto;
import turnos.modelo.Turno;
import usuario.modelo.Usuario;

public class PredioConcreteFactory extends PredioFactory {

	public PredioConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Predio create(String direccion) {
		// TODO Auto-generated method stub
		ArrayList<Usuario> empleados = new ArrayList<Usuario>();
		ArrayList<Cancha> canchas = new ArrayList<Cancha>();
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		return new Predio(direccion,empleados,canchas,turnos,productos);
	}

}
