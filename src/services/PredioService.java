package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import daos.PredioDAO;
import daos.implementaciones.PredioDAOHibernateJPA;
import modelo.Administrador;
import modelo.Cancha;
import modelo.Empleado;
import modelo.Predio;
import modelo.Producto;
import modelo.Provedor;
import modelo.Turno;
import utils.ValidationUtils;

public class PredioService extends GenericService<Predio,PredioDAOHibernateJPA>{

	PredioDAO predio_dao = new PredioDAOHibernateJPA();
	
	public PredioService() throws Exception {
        super();
    }

	synchronized public Predio update(Predio predio) throws ServiceException {
        ServiceException exception;
        exception = new ServiceException();

        this.validateRequiredFields(predio);
        
//        if (this.checkDuplicatedField("user", predio.getUser(), empleado, true))
//            exception.addErrorMessage("Nombre de usuario ya registrado");
        
        if (exception.isError()) {
            throw exception;
        }

        ValidationUtils.initializeNullStrings(predio);
        return super.update(predio,predio.getId());
    }
	
	synchronized public ArrayList<Producto> getProductos(int id) throws ServiceException{		
        return (ArrayList<Producto>) predio_dao.getProductos(id);
	}
	
	synchronized public ArrayList<Empleado> getEmpleados(int id) throws ServiceException{		
        return (ArrayList<Empleado>) predio_dao.getEmpleados(id);
	}
	
	synchronized public ArrayList<Administrador> getAdministradores(int id) throws ServiceException{		
        return (ArrayList<Administrador>) predio_dao.getAdministradores(id);
	}
	
	synchronized public ArrayList<Provedor> getProvedores(int id) throws ServiceException{		
        return (ArrayList<Provedor>) predio_dao.getProvedores(id);
	}
	
	synchronized public ArrayList<Cancha> getCanchas(int id) throws ServiceException{		
        return (ArrayList<Cancha>) predio_dao.getCanchas(id);
	}
	
	synchronized public ArrayList<Turno> getTurnos(int id,String desde, String hasta) throws ServiceException{		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		ArrayList<Turno> turnos = new ArrayList<Turno>();
        try {
			turnos = (ArrayList<Turno>) predio_dao.getTurnos(id, sdf.parse(desde), sdf.parse(hasta));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return turnos;
	}

    @Override
    synchronized public void create(Predio predio) throws ServiceException {
        this.validateRequiredFields(predio);
        
        ServiceException exception;
        exception = new ServiceException();
        
//        if (this.checkDuplicatedField("user", empleado.getUser(), empleado, true))
//            exception.addErrorMessage("Nombre de usuario ya registrado");

        if (exception.isError()) {
            throw exception;
        }

        ValidationUtils.initializeNullStrings(predio);
        super.create(predio);
    }

    private void validateRequiredFields(Predio predio) throws ServiceException {
        ServiceException exception;
        exception = new ServiceException();
        if (predio == null) {
            exception.addErrorMessage("Usuario inválido");
            throw exception;
        }

//        if (ValidationUtils.isNullOrEmpty(empleado.getUser())) {
//            exception.addErrorMessage("Nombre de usuario vacío.");
//        }
//        if (ValidationUtils.isNullOrEmpty(empleado.getNombre_apellido())) {
//            exception.addErrorMessage("Nombre y apellido del usuario vacío.");
//        }
//        if (ValidationUtils.isNullOrEmpty(empleado.getPass())) {
//            exception.addErrorMessage("Contraseña vacia.");
//        }

        if (exception.isError()) {
            exception.setErrorCode(1);
            throw exception;
        }
    }    

    @SuppressWarnings("unchecked")
	public boolean checkDuplicatedField(String field, Object value, Predio predio, boolean excludeSameObject) {
        
        if (field == null || value == null) {
            return false;
        }
        Hashtable<String, Object> parameters = new Hashtable<String, Object>();
        parameters.put(field, value);
        String query = String.format("%s = :%s", field, field);
        if (excludeSameObject) {
            query = query.concat(" AND id != :id");
            parameters.put("id", predio.getId());
        }
        List<Predio> predios = super.dao.get(query, parameters);
        return (predios.size() > 0);
    }
}
