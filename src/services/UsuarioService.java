package services;

import modelo.Usuario;
import utils.ValidationUtils;

import java.util.Hashtable;
import java.util.List;

import daos.implementaciones.*;

public class UsuarioService extends GenericService<Usuario, UsuarioDAOHibernateJPA> {

    public UsuarioService() throws Exception {
        super();
    }

    @Override
    synchronized public Usuario update(Usuario usuario) throws ServiceException {
        ServiceException exception;
        exception = new ServiceException();

        //this.validateRequiredFields(usuario);
        
//        if (this.checkDuplicatedField("nombreUsuario", usuario.getNombreUsuario(), usuario, true))
//            exception.addErrorMessage("Nombre de usuario ya registrado");
//        if (this.checkDuplicatedField("email", usuario.getEmail(), usuario, true)) {
//            exception.addErrorMessage("Email ya registrado");
//        }
        
        if (exception.isError()) {
            throw exception;
        }

        ValidationUtils.initializeNullStrings(usuario);
        return super.update(usuario);
    }

    @Override
    synchronized public void create(Usuario usuario) throws ServiceException {
        this.validateRequiredFields(usuario);
        
        ServiceException exception;
        exception = new ServiceException();
        
//        if (this.checkDuplicatedField("nombreUsuario", usuario.getNombreUsuario(), usuario, false))
//            exception.addErrorMessage("Nombre de usuario ya registrado");
//        if (this.checkDuplicatedField("email", usuario.getEmail(), usuario, false)) {
//            exception.addErrorMessage("Email ya registrado");
//        }

        if (exception.isError()) {
            throw exception;
        }

        ValidationUtils.initializeNullStrings(usuario);
        super.create(usuario);
    }

    private void validateRequiredFields(Usuario usuario) throws ServiceException {
        ServiceException exception;
        exception = new ServiceException();
        if (usuario == null) {
            exception.addErrorMessage("Usuario inválido");
            throw exception;
        }

//        if (ValidationUtils.isNullOrEmpty(usuario.getNombreUsuario())) {
//            exception.addErrorMessage("Nombre de usuario vacío.");
//        }
//
//        if (ValidationUtils.isNullOrEmpty(usuario.getEmail())) {
//            exception.addErrorMessage("Email vacio.");
//        }
//
//        if (ValidationUtils.isNullOrEmpty(usuario.getClave())) {
//            exception.addErrorMessage("Contraseña vacia.");
//        }
//
//        if (usuario.getTipo() == null) {
//            exception.addErrorMessage("Tipo de usuario inválido.");
//        }

        if (exception.isError()) {
            exception.setErrorCode(1);
            throw exception;
        }
    }
    

    public boolean checkDuplicatedField(String field, Object value, Usuario usuario, boolean excludeSameObject) {
        
        if (field == null || value == null) {
            return false;
        }
        Hashtable parameters = new Hashtable<String, Object>();
        parameters.put(field, value);
        String query = String.format("%s = :%s", field, field);
        if (excludeSameObject) {
            query = query.concat(" AND PERSONA_ID != :id");
            parameters.put("id", usuario.getId());
        }
        List<Usuario> usuarios = dao.get(query, parameters);
        return (usuarios.size() > 0);
    }
}
