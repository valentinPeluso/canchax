package services;

import java.util.Hashtable;
import java.util.List;

import daos.implementaciones.PredioDAOHibernateJPA;
import modelo.Empleado;
import modelo.Predio;
import utils.ValidationUtils;

public class PredioService extends GenericService<Predio,PredioDAOHibernateJPA>{

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
    

    public boolean checkDuplicatedField(String field, Object value, Predio predio, boolean excludeSameObject) {
        
        if (field == null || value == null) {
            return false;
        }
        Hashtable parameters = new Hashtable<String, Object>();
        parameters.put(field, value);
        String query = String.format("%s = :%s", field, field);
        if (excludeSameObject) {
            query = query.concat(" AND id != :id");
            parameters.put("id", predio.getId());
        }
        List<Empleado> empleados = dao.get(query, parameters);
        return (empleados.size() > 0);
    }
}
