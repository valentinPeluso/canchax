package services;

import modelo.Empleado;
import modelo.Usuario;
import utils.ValidationUtils;

import java.util.Hashtable;
import java.util.List;

import daos.implementaciones.*;

public class EmpleadoService extends GenericService<Empleado, EmpleadoDAOHibernateJPA> {

    public EmpleadoService() throws Exception {
        super();
    }

    
    synchronized public Empleado update(Empleado empleado) throws ServiceException {
        ServiceException exception;
        exception = new ServiceException();

        this.validateRequiredFields(empleado);
        
        if (this.checkDuplicatedField("user", empleado.getUser(), empleado, true))
            exception.addErrorMessage("Nombre de usuario ya registrado");
        
        if (exception.isError()) {
            throw exception;
        }

        ValidationUtils.initializeNullStrings(empleado);
        return super.update(empleado,empleado.getId());
    }

    @Override
    synchronized public void create(Empleado empleado) throws ServiceException {
        this.validateRequiredFields(empleado);
        
        ServiceException exception;
        exception = new ServiceException();
        
        if (this.checkDuplicatedField("user", empleado.getUser(), empleado, true))
            exception.addErrorMessage("Nombre de usuario ya registrado");

        if (exception.isError()) {
            throw exception;
        }

        ValidationUtils.initializeNullStrings(empleado);
        super.create(empleado);
    }

    private void validateRequiredFields(Empleado empleado) throws ServiceException {
        ServiceException exception;
        exception = new ServiceException();
        if (empleado == null) {
            exception.addErrorMessage("Usuario inválido");
            throw exception;
        }

        if (ValidationUtils.isNullOrEmpty(empleado.getUser())) {
            exception.addErrorMessage("Nombre de usuario vacío.");
        }
        if (ValidationUtils.isNullOrEmpty(empleado.getNombre_apellido())) {
            exception.addErrorMessage("Nombre y apellido del usuario vacío.");
        }
        if (ValidationUtils.isNullOrEmpty(empleado.getPass())) {
            exception.addErrorMessage("Contraseña vacia.");
        }

        if (exception.isError()) {
            exception.setErrorCode(1);
            throw exception;
        }
    }
    

    public boolean checkDuplicatedField(String field, Object value, Empleado empleado, boolean excludeSameObject) {
        
        if (field == null || value == null) {
            return false;
        }
        Hashtable parameters = new Hashtable<String, Object>();
        parameters.put(field, value);
        String query = String.format("%s = :%s", field, field);
        if (excludeSameObject) {
            query = query.concat(" AND id != :id");
            parameters.put("id", empleado.getId());
        }
        List<Empleado> empleados = dao.get(query, parameters);
        return (empleados.size() > 0);
    }
}
