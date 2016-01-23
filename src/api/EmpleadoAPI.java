package api;
import api.GenericAPI;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import json.JsonManager;
import modelo.Empleado;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import services.ServiceException;
import services.EmpleadoService;
import utils.ValidationUtils;

@Path("/empleados")
@Produces("application/json")
public class EmpleadoAPI extends GenericAPI<Empleado, EmpleadoService> {

    public EmpleadoAPI() throws Exception {
        super();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        Empleado usuario;
        try {
            usuario = (Empleado) this.service.get(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(usuario);
        if (node.has("pass")) {
            ((ObjectNode) node).remove("pass");
        }
        return Response.status(200).entity(node.toString()).build();
    }    
    
    @GET
    @Path("/")
    @Produces("application/json")
    public Response list(@QueryParam("limit") String limit, @QueryParam("offset") String offset) {
        List<Empleado> empleados;
        try {
            if (!ValidationUtils.isNullOrEmpty(limit)) {
                if (ValidationUtils.isNullOrEmpty(offset)) {
                    offset = "0";
                }
                empleados = this.service.list(Integer.parseInt(limit.trim()), Integer.parseInt(offset.trim()));
            } else {
                empleados = this.service.list();
            }
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode arrNode = JsonManager.toJsonTree(empleados);
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {
                if (objNode.has("pass")) {
                    ((ObjectNode) objNode).remove("pass");
                }
            }
        }
        return Response.status(200).entity(arrNode.toString()).build();
    }

    @POST
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response update(@PathParam("id") String id, String data) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID incorrecto").build();
        }
        Empleado empleado = (Empleado) JsonManager.toObject(data, Empleado.class);
        empleado.setId(Long.parseLong(id));
        try {
        	empleado = this.service.update(empleado);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }        
        JsonNode node = JsonManager.toJsonTree(empleado);
        if (node.has("pass")) {
            ((ObjectNode) node).remove("pass");
        }
        return Response.status(200).entity(node.toString()).build();
    }

    @POST
    @Path("/")
    @Produces("application/json")
    @Consumes("application/json")
    public Response create(String data) {
        if (data == null || data.trim().length() == 0) {
            return Response.serverError().entity("Información invalida").build();
        }
        Empleado empleado = null;
        empleado = (Empleado) JsonManager.toObject(data, Empleado.class);        
        try {
            this.service.create(empleado);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(empleado);        
        return Response.status(200).entity(node.toString()).build();
    }
    
   
}
