package api;

import aspectos.DataRow;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import utils.ValidationUtils;
import json.JsonManager;

import services.GenericService;
import services.ServiceException;

public class GenericAPI <T, Service> {

    protected Service service = null;

    public GenericAPI() throws Exception {
        super();
        try {
            this.service = (Service)this.getObjectParameterClass(1).newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GenericService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        T entity;
        try {
            entity = (T) ((GenericService) this.service).get(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        return Response.status(Response.Status.OK).entity(JsonManager.toJsonString(entity)).build();
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response list(@QueryParam("limit") String limit, @QueryParam("offset") String offset) {
        List<T> entities;
        try {
            if (!ValidationUtils.isNullOrEmpty(limit)) {
                if (ValidationUtils.isNullOrEmpty(offset)) {
                    offset = "0";
                }
                entities = (List<T>) ((GenericService) this.service).list(Integer.parseInt(limit.trim()), Integer.parseInt(offset.trim()));
            } else {
                entities = (List<T>) ((GenericService) this.service).list();
            }
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        return Response.status(Response.Status.OK).entity(JsonManager.toJsonString(entities)).build();
    }

    @POST
    @Path("/{id}")
    @Produces("application/json")
    public Response update(@PathParam("id") String id, @FormParam("data") String data) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID incorrecto").build();
        }
        T entity = (T) JsonManager.toObject(data, this.getObjectParameterClass(0));
        this.setEntityId(Long.parseLong(id), entity);
        try {
            entity = (T)((GenericService)this.service).update(entity);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("error", "0");
        result.put("error_msg", null);
        return Response.status(200).entity(JsonManager.toJsonString(result)).build();
    }
        
    @POST
    @Path("/")
    @Produces("application/json")
    public Response create(@FormParam("data") String data) throws InstantiationException {
        if (data == null || data.trim().length() == 0) {
            try {
                Object instance = this.initializeEntity(this.getObjectParameterClass(0).newInstance());
                return Response.status(200).entity(JsonManager.toJsonString(instance)).build();
            } catch (InstantiationException ex) {
                Logger.getLogger(GenericAPI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(GenericAPI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        T entity = (T) JsonManager.toObject(data, this.getObjectParameterClass(0));
        try {
            ((GenericService)this.service).create(entity);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("error", "0");
        result.put("error_msg", null);
        return Response.status(200).entity(JsonManager.toJsonString(result)).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") String id) {
        try {
            ((GenericService)this.service).delete(Long.parseLong(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("error", "0");
        result.put("error_msg", null);
        return Response.status(200).entity(JsonManager.toJsonString(result)).build();
    }

    protected Response handleException(ServiceException ex) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("error", ex.getErrorCode());
        result.put("error_msg", ex.getErrorMessages());
        return Response.status(200).entity(JsonManager.toJsonString(result)).build();
    }

    protected Class getObjectParameterClass(int i) {
        return ((Class) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[i]);
    }
    
    protected T setEntityId(long id, T object) {
        //System.out.println(object.getClass().getDeclaredFields().toString());
        for(Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.getName().equals("id")) {
                try {
                    field.setLong(object, id);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(GenericAPI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(GenericAPI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        return object;
    }
    
    protected Object initializeEntity(Object entity) {
        return entity;
    }
}
