package factorys;

import java.util.ArrayList;

import modelo.Cancha;
import modelo.Predio;
import modelo.Producto;
import modelo.Turno;
import modelo.Usuario;

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
