package factorys;

import java.util.ArrayList;

import modelo.Administrador;
import modelo.Cancha;
import modelo.Empleado;
import modelo.Predio;
import modelo.Producto;
import modelo.Provedor;
import modelo.Turno;

public class PredioConcreteFactory extends PredioFactory {

	public PredioConcreteFactory() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Predio create(String direccion) {
		// TODO Auto-generated method stub
		ArrayList<Empleado> empleados = new ArrayList<Empleado>();
		ArrayList<Administrador> administradores = new ArrayList<Administrador>();
		ArrayList<Provedor> provedores = new ArrayList<Provedor>();
		ArrayList<Cancha> canchas = new ArrayList<Cancha>();
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		ArrayList<Producto> productos = new ArrayList<Producto>();
		return new Predio(direccion,empleados,administradores,provedores,canchas,turnos,productos);
	}

}
