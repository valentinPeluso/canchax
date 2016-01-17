package test;
import java.util.ArrayList;
import java.util.List;

import daos.CanchaDAO;
import daos.PredioDAO;
import daos.implementaciones.CanchaDAOHibernateJPA;
import daos.implementaciones.PredioDAOHibernateJPA;
import factorys.CanchaConcreteFactory;
import factorys.CanchaFactory;
import factorys.PredioConcreteFactory;
import factorys.PredioFactory;
import factorys.RolConcreteFactory;
import factorys.RolFactory;
import factorys.UsuarioConcreteFactory;
import factorys.UsuarioFactory;
import modelo.Cancha;
import modelo.Predio;
import modelo.Usuario;

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
		
		RolFactory rol_factory = new RolConcreteFactory();		
		UsuarioFactory usuario_factory = new UsuarioConcreteFactory();
		
		Usuario empleado_1 = usuario_factory.create("Juan Perez", rol_factory.createRolEmpleado("Empleado", "user", "1234"));
		List<Usuario> empleados = new ArrayList<Usuario>();
		empleados.add(empleado_1);
		
		predio.setEmpleados(empleados);
		
		predio_dao.save(predio);

	}

}
