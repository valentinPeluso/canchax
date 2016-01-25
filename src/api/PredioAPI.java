package api;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import json.JsonManager;
import modelo.Administrador;
import modelo.Cancha;
import modelo.Empleado;
import modelo.Predio;
import modelo.Producto;
import modelo.Provedor;
import modelo.Turno;
import services.PredioService;
import services.ServiceException;
import utils.ValidationUtils;

@Path("/predios")
@Produces("application/json")
public class PredioAPI extends GenericAPI<Predio,PredioService> {

	public PredioAPI() throws Exception {
        super();
    }
	
	@GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        Predio predio;
        //verifico si ya esta guardado el predio como singleton
        try {
        	predio = Predio.getInstance();
        	if(predio == null){        		
        		predio = (Predio) this.service.get(Integer.parseInt(id));
        		Predio.setInstance(predio);
        	}        	
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(predio);
        //remuevo todos los pass de los usuarios
        if (node.has("empleados") && node.get("empleados").isArray()) {
        	for(final JsonNode obj : node.get("empleados")){
        		 ((ObjectNode) obj).remove("pass");
        	}
        }
        if (node.has("administradores") && node.get("administradores").isArray()) {
        	for(final JsonNode obj : node.get("administradores")){
        		 ((ObjectNode) obj).remove("pass");
        	}
        }
        return Response.status(200).entity(node.toString()).build();
    }
	
	@GET
    @Path("/{id}/productos")
    @Produces("application/json")
    public Response getProductos(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        ArrayList<Producto> productos;
        try {        	     		
        	productos = this.service.getProductos(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(productos);
              
        return Response.status(200).entity(node.toString()).build();
    }
	
	@GET
    @Path("/{id}/empleados")
    @Produces("application/json")
    public Response getEmpleados(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        ArrayList<Empleado> empleados;
        try {        	     		
        	empleados = this.service.getEmpleados(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(empleados);
              
        return Response.status(200).entity(node.toString()).build();
    }
	
	@GET
    @Path("/{id}/administradores")
    @Produces("application/json")
    public Response getAdministradores(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        ArrayList<Administrador> administradores;
        try {        	     		
        	administradores = this.service.getAdministradores(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(administradores);
              
        return Response.status(200).entity(node.toString()).build();
    }
	
	@GET
    @Path("/{id}/provedores")
    @Produces("application/json")
    public Response getProvedores(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        ArrayList<Provedor> provedores;
        try {        	     		
        	provedores = this.service.getProvedores(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(provedores);
              
        return Response.status(200).entity(node.toString()).build();
    }
	
	@GET
    @Path("/{id}/canchas")
    @Produces("application/json")
    public Response getCanchas(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        ArrayList<Cancha> canchas;
        try {        	     		
        	canchas = this.service.getCanchas(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(canchas);
              
        return Response.status(200).entity(node.toString()).build();
    }
	
	@GET
    @Path("/{id}/turnos")
    @Produces("application/json")
    public Response getTurnos(@PathParam("id") String id,@QueryParam("desde") String desde, @QueryParam("hasta") String hasta) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        if (ValidationUtils.isNullOrEmpty(desde) || ValidationUtils.isNullOrEmpty(hasta) ) {
        	return Response.serverError().entity("Los atributos desde - hasta son obligatorios").build();            
        } 
        ArrayList<Turno> turnos;
        try {        	     		
        	turnos = this.service.getTurnos(Integer.parseInt(id), desde, hasta);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(turnos);
              
        return Response.status(200).entity(node.toString()).build();
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response list(@QueryParam("limit") String limit, @QueryParam("offset") String offset) {
        List<Predio> predios;
        try {
            if (!ValidationUtils.isNullOrEmpty(limit)) {
                if (ValidationUtils.isNullOrEmpty(offset)) {
                    offset = "0";
                }
                predios = this.service.list(Integer.parseInt(limit.trim()), Integer.parseInt(offset.trim()));
            } else {
            	predios = this.service.list();
            }
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode arrNode = JsonManager.toJsonTree(predios);
        //remuevo todos los pass de los usuarios
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {
                if (objNode.has("empleados") && objNode.get("empleados").isArray()) {
                	for(final JsonNode obj : objNode.get("empleados")){
                		 ((ObjectNode) obj).remove("pass");
                	}
                }
                if (objNode.has("administradores") && objNode.get("administradores").isArray()) {
                	for(final JsonNode obj : objNode.get("administradores")){
                		 ((ObjectNode) obj).remove("pass");
                	}
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
        Predio predio = (Predio) JsonManager.toObject(data, Predio.class);
        predio.setId(Long.parseLong(id));
        try {
        	predio = this.service.update(predio);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }        
        JsonNode node = JsonManager.toJsonTree(predio);
        //remuevo todos los pass de los usuarios
        if (node.has("empleados") && node.get("empleados").isArray()) {
        	for(final JsonNode obj : node.get("empleados")){
        		 ((ObjectNode) obj).remove("pass");
        	}
        }
        if (node.has("administradores") && node.get("administradores").isArray()) {
        	for(final JsonNode obj : node.get("administradores")){
        		 ((ObjectNode) obj).remove("pass");
        	}
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
        Predio predio = null;
        predio = (Predio) JsonManager.toObject(data, Predio.class);        
        try {
            this.service.create(predio);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(predio);        
        return Response.status(200).entity(node.toString()).build();
    }
    

}
