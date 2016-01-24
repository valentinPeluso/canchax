package daos.implementaciones;

import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Query;

import daos.PredioDAO;
import modelo.Administrador;
import modelo.Cancha;
import modelo.Compra;
import modelo.Empleado;
import modelo.Predio;
import modelo.Producto;
import modelo.Provedor;
import modelo.Turno;
import modelo.Venta;

public class PredioDAOHibernateJPA extends GenericDAOHibernateJPA<Predio> implements PredioDAO{

	public PredioDAOHibernateJPA() {
		// TODO Auto-generated constructor stub
		super();
		this.setPersistentClass(Predio.class);
	}
	
	public Predio find(long id){
		try{
			Query consulta = this.getEntityManager().createQuery("SELECT e.id,e.direccion FROM Predio e WHERE e.id = :id",Predio.class);
			consulta.setParameter("id", id);
			return (Predio) consulta.getSingleResult();
		}catch(Exception e){
			return null;
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> getEmpleados(long id) {
		try{
			Query consulta = this.getEntityManager().createQuery("SELECT e.empleados FROM Predio e WHERE e.id = :id");
			consulta.setParameter("id", id);
			return (ArrayList<Empleado>) consulta.getResultList();
		}catch(Exception e){
			return null;
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Administrador> getAdministradores(long id) {
		try{
			Query consulta = this.getEntityManager().createQuery("SELECT e.administradores FROM Predio e WHERE e.id = :id");
			consulta.setParameter("id", id);
			return (ArrayList<Administrador>) consulta.getResultList();
		}catch(Exception e){
			return null;
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Provedor> getProvedores(long id) {
		try{
			Query consulta = this.getEntityManager().createQuery("SELECT e.provedores FROM Predio e WHERE e.id = :id");
			consulta.setParameter("id", id);
			return (ArrayList<Provedor>) consulta.getResultList();
		}catch(Exception e){
			return null;
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cancha> getCanchas(long id) {
		try{
			Query consulta = this.getEntityManager().createQuery("SELECT e.canchas FROM Predio e WHERE e.id = :id");
			consulta.setParameter("id", id);
			return (ArrayList<Cancha>) consulta.getResultList();
		}catch(Exception e){
			return null;
		}	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Turno> getTurnos(long id,Date desde, Date hasta) {
		// TODO Auto-generated method stub
		try{
			Query consulta = this.getEntityManager().createQuery("SELECT e.turnos FROM Predio e WHERE e.id = :id");
			consulta.setParameter("id", id);
			ArrayList <Turno> turnos = (ArrayList<Turno>) ((ArrayList<Turno>) consulta.getResultList()).stream().filter(t -> t.getHorario().after(desde) && t.getHorario().before(hasta)).collect(Collectors.toList());			
			return turnos;
		}catch(Exception e){
			return null;
		}	
	}

	@Override
	public List<Producto> getProductos(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Compra> getCompras(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> getVentas(long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
