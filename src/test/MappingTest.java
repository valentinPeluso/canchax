package test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import daos.*;
import daos.implementaciones.*;
import factorys.*;
import modelo.*;

public class MappingTest {

	public MappingTest() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		PredioDAO predio_dao = new PredioDAOHibernateJPA();
		PredioFactory predio_factory = new PredioConcreteFactory();
		Predio predio = predio_factory.create("Calle 63 nro 550 dpto 12 C");			
	
		CanchaFactory cancha_factory = new CanchaConcreteFactory();
		Cancha cancha_1 = cancha_factory.create("Cancha 1");
		Cancha cancha_2 = cancha_factory.create("Cancha 2");
		List<Cancha> canchas = new ArrayList<Cancha>();
		canchas.add(cancha_2);
		canchas.add(cancha_1);
		predio.setCanchas(canchas);		
			
		UsuarioFactory usuario_factory = new UsuarioConcreteFactory();
		
		Empleado empleado_1 = usuario_factory.createEmpleado("Empleado 1", new ArrayList<String>(), new ArrayList<String>(), "Valen", "1234");
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado_1);
		
		Administrador administrador_1 = usuario_factory.createAdministrador("Administrador 1", new ArrayList<String>(), new ArrayList<String>(), "Admin", "1234");
		List<Administrador> administradores = new ArrayList<Administrador>();
		administradores.add(administrador_1);
		
		Provedor provedor_1 = usuario_factory.createProvedor("Provedor 1", new ArrayList<String>(), new ArrayList<String>());
		Provedor provedor_2 = usuario_factory.createProvedor("Provedor 2", new ArrayList<String>(), new ArrayList<String>());
		List<Producto> productos = new ArrayList<Producto>();
		List<Producto> productos_2 = new ArrayList<Producto>();
		List<Producto> productos_3 = new ArrayList<Producto>();
		
		ProductoFactory producto_factory = new ProductoConcreteFactory();
		Producto producto = producto_factory.create("1234", "Pelota penalty", 12, 50f, 65f, "foto");
		productos.add(producto);
		producto = producto_factory.create("1123", "Gatorade", 43, 50.23f, 65.10f, "foto");
		productos.add(producto);
		producto = producto_factory.create("3212", "Pelota umbro", 2, 32.34f, 45.30f, "foto");
		productos.add(producto);
		producto = producto_factory.create("2341", "Cerveza Quilmes", 100, 32.45f, 12.32f, "foto");
		productos.add(producto);
		producto = producto_factory.create("1234", "Cerveza brahama", 100, 21.34f, 25.00f, "foto");
		productos.add(producto);
		
		provedor_1.setProductos(productos);
		
		producto = producto_factory.create("32123", "Papas fritas", 43, 50f, 65f, "foto");
		productos_2.add(producto);
		producto = producto_factory.create("412321", "Mani pharo", 32, 50.23f, 65.10f, "foto");
		productos_2.add(producto);
		producto = producto_factory.create("41231", "Palitos pharo", 232, 32.34f, 45.30f, "foto");
		productos_2.add(producto);
		producto = producto_factory.create("7634", "Caramelos masticables", 321, 32.45f, 12.32f, "foto");
		productos_2.add(producto);
		producto = producto_factory.create("823423", "Mani cervezero", 42, 21.34f, 25.00f, "foto");
		productos_2.add(producto);
		
		provedor_2.setProductos(productos_2);
		
		producto = producto_factory.create("32123", "Papas fritas", 43, 50f, 65f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("412321", "Mani pharo", 32, 50.23f, 65.10f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("41231", "Palitos pharo", 232, 32.34f, 45.30f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("7634", "Caramelos masticables", 321, 32.45f, 12.32f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("823423", "Mani cervezero", 42, 21.34f, 25.00f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("1234", "Pelota penalty", 12, 50f, 65f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("1123", "Gatorade", 43, 50.23f, 65.10f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("3212", "Pelota umbro", 2, 32.34f, 45.30f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("2341", "Cerveza Quilmes", 100, 32.45f, 12.32f, "foto");
		productos_3.add(producto);
		producto = producto_factory.create("1234", "Cerveza brahama", 100, 21.34f, 25.00f, "foto");
		productos_3.add(producto);			
		
		List<Provedor> provedores = new ArrayList<Provedor>();
		provedores.add(provedor_1);
		provedores.add(provedor_2);
		
		SeniaFactory senia_factory = new SeniaConcreteFactory();		
		
		TurnoFactory turno_factory = new TurnoConcreteFactory();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Senia senia_1 =  senia_factory.create(50.00f, "Peluso valentin", "221-2334433");
		Senia senia_2 = senia_factory.create(50.00f, "Daiel Osvalndo", "221-7653212");
		Senia senia_3 = senia_factory.create(50.00f, "Chavez", "221-5533222");
		Senia senia_4 =  senia_factory.create(50.00f, "Agustin Orion", "221-6543453");
		Senia senia_5 = senia_factory.create(50.00f, "Federico cristaldo", "221-815432");
		Senia senia_6 = senia_factory.create(50.00f, "Carlos ruben", "221-322313");
		
		Turno turno_1 = turno_factory.create(sdf.parse("20/12/2014 12:20:00"),senia_1);
		senia_1.setTurno(turno_1);
		Turno turno_6 = turno_factory.create(sdf.parse("27/12/2014 12:20:00"), senia_2);
		senia_2.setTurno(turno_6);
		Turno turno_4 = turno_factory.create(sdf.parse("22/12/2014 12:20:00"), senia_3);
		senia_3.setTurno(turno_4);
		Turno turno_5 = turno_factory.create(sdf.parse("23/12/2014 12:20:00"),senia_4);	
		senia_4.setTurno(turno_5);
		Turno turno_3 = turno_factory.create(sdf.parse("21/12/2014 12:20:00"), senia_5);
		senia_5.setTurno(turno_3);
		Turno turno_2 = turno_factory.create(sdf.parse("15/12/2014 12:20:00"), senia_6);		
		senia_6.setTurno(turno_2);
		
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		turnos.add(turno_6);
		turnos.add(turno_5);
		turnos.add(turno_4);
		turnos.add(turno_3);
		turnos.add(turno_2);
		turnos.add(turno_1);
		
		predio.setTurnos(turnos);		
		predio.setEmpleados(empleados);
		predio.setAdministradores(administradores);
		predio.setProvedores(provedores);
		predio.setProductos(productos_3);		
		
		predio_dao.save(predio);

	}

}
