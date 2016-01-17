package services;

import aspectos.DataRow;
import daos.GenericDAO;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import services.ServiceException;

public abstract class GenericService<T, DaoT> {

    protected GenericDAO dao = null;

    public GenericService() throws ServiceException {
        try {
            this.dao = (GenericDAO) ((Class) ((ParameterizedType) this.getClass().
                    getGenericSuperclass()).getActualTypeArguments()[1]).newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GenericDAO getDAO() throws ServiceException {
        return this.dao;
    }

    public Object get(long id) throws ServiceException {
        return this.dao.find(id);
    }

    public T update(T object) throws ServiceException {
        T persistedObject = (T) this.get(((DataRow) object).getId());
        if (persistedObject == null) {
            ServiceException exception = new ServiceException();
            exception.setErrorCode(1);
            exception.addErrorMessage("Objeto inexistente");
            throw exception;
        }
        LinkedList<Field> fields = new LinkedList<Field>();

        fields.addAll(Arrays.asList(object.getClass().getDeclaredFields()));
        Class<?> superClass = object.getClass().getSuperclass();
        while (superClass != null) {
            fields.addAll(Arrays.asList(superClass.getDeclaredFields()));
            superClass = superClass.getSuperclass();
        }
        for (Field field : fields) {
            try {   
                if ((field.getModifiers() & java.lang.reflect.Modifier.FINAL) == java.lang.reflect.Modifier.FINAL) {
                    continue;
                }
                field.setAccessible(true);
                //System.out.println("Checking: " + field.getName() + ": " + field.get(object));
                
                if (field.getName().equals("id")) {
                    continue;
                }

                if (field.get(object) == null) {
                    continue;
                }
                //System.out.println("IT is NULL: " + field.get(object));

                if (!(field.get(object).equals(field.get(persistedObject)))) {
                    //System.out.println("SETTING");
                    field.set(persistedObject, field.get(object));
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.dao.update(persistedObject);
        
        return object;
    }

    public List<T> list() throws ServiceException {
        List<T> result = this.dao.list();

        return result;
    }

    public List<T> list(int limit, int offset) throws ServiceException {
        List<T> result = this.dao.list(limit, offset);
        return result;
    }

    public void delete(T object) throws ServiceException {
        this.dao.delete(((DataRow) object).getId());
    }

    public void delete(long id) throws ServiceException {
        this.dao.delete(id);
    }

    public void create(T object) throws ServiceException {
        this.dao.save(object);
    }
}
