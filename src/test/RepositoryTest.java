package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;

import daos.PredioDAO;
import daos.implementaciones.PredioDAOHibernateJPA;
import modelo.Administrador;
import modelo.Cancha;
import modelo.Empleado;
import modelo.Predio;
import modelo.Provedor;
import modelo.Turno;

public class RepositoryTest {

	public static void main(String[] args) {
		long id = 1l;		
		PredioDAO predio_dao = new PredioDAOHibernateJPA();
		Predio predio = (Predio) predio_dao.find(id);
		ArrayList<Empleado> emplados = (ArrayList<Empleado>) predio_dao.getEmpleados(id);
		ArrayList<Administrador> administradores = (ArrayList<Administrador>) predio_dao.getAdministradores(id);
		ArrayList<Provedor> provedores = (ArrayList<Provedor>) predio_dao.getProvedores(id);
		ArrayList<Cancha> canchas = (ArrayList<Cancha>) predio_dao.getCanchas(id);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		ArrayList<Turno> turnos = new ArrayList<Turno>();
		try {
			turnos = (ArrayList<Turno>) predio_dao.getTurnos(id, sdf.parse("19/12/2014"), sdf.parse("24/12/2014"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("-----------------");
		System.out.println(predio.getId() + "---------" + predio.getDireccion());
		System.out.println("-----------------");
		
		Iterator<Empleado> iterator_empleados = emplados.iterator();
		while(iterator_empleados.hasNext()){
			System.out.println("Empleado: " +iterator_empleados.next().getNombre_apellido());
		}
		
		Iterator<Administrador> iterator_administradores = administradores.iterator();
		while(iterator_administradores.hasNext()){
			System.out.println("Administrador: " +iterator_administradores.next().getNombre_apellido());
		}	
		
		Iterator<Provedor> iterator_provedores = provedores.iterator();
		while(iterator_provedores.hasNext()){
			System.out.println("Provedor: " +iterator_provedores.next().getNombre_apellido());
		}	
		
		Iterator<Cancha> iterator_canchas = canchas.iterator();
		while(iterator_canchas.hasNext()){
			System.out.println("Cancha: " +iterator_canchas.next().getDescripcion());
		}	
		
		Iterator<Turno> iterator_turnos = turnos.iterator();
		while(iterator_turnos.hasNext()){
			System.out.println("Turno: " +iterator_turnos.next().getId());
		}	
	}

}
