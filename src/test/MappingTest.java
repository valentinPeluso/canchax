package test;
import java.util.ArrayList;
import java.util.List;

import daos.PredioDAO;
import daos.implementaciones.PredioDAOHibernateJPA;
import factorys.CanchaConcreteFactory;
import factorys.CanchaFactory;
import factorys.PredioConcreteFactory;
import factorys.PredioFactory;
import factorys.UsuarioConcreteFactory;
import factorys.UsuarioFactory;
import modelo.Administrador;
import modelo.Cancha;
import modelo.Empleado;
import modelo.Predio;
import modelo.Provedor;

public class MappingTest {

	public MappingTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PredioDAO predio_dao = new PredioDAOHibernateJPA();
		PredioFactory predio_factory = new PredioConcreteFactory();
		Predio predio = predio_factory.create("Calle 63 nro 550 dpto 12 C");			
	
		CanchaFactory cancha_factory = new CanchaConcreteFactory();
		Cancha cancha_1 = cancha_factory.create("Cancha 1",predio);
		Cancha cancha_2 = cancha_factory.create("Cancha 2",predio);
		List<Cancha> canchas = new ArrayList<Cancha>();
		canchas.add(cancha_2);
		canchas.add(cancha_1);
		predio.setCanchas(canchas);		
			
		UsuarioFactory usuario_factory = new UsuarioConcreteFactory();
		
		Empleado empleado_1 = usuario_factory.createEmpleado("Valentin", new ArrayList<String>(), new ArrayList<String>(), "Valen", "1234");
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado_1);
		
		Administrador administrador_1 = usuario_factory.createAdministrador("Admin", new ArrayList<String>(), new ArrayList<String>(), "Admin", "1234");
		List<Administrador> administradores = new ArrayList<Administrador>();
		administradores.add(administrador_1);
		
		Provedor provedor_1 = usuario_factory.createProvedor("Juan Perez", new ArrayList<String>(), new ArrayList<String>());
		List<Provedor> provedores = new ArrayList<Provedor>();
		provedores.add(provedor_1);
		
		predio.setEmpleados(empleados);
		predio.setAdministradores(administradores);
		predio.setProvedores(provedores);
		
		predio_dao.save(predio);

	}

}
