package api;
import api.GenericAPI;
import java.util.HashMap;
import java.util.List;

import javax.websocket.server.PathParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import json.JsonManager;
import modelo.Usuario;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;
import services.ServiceException;
import services.UsuarioService;
import utils.ValidationUtils;

@Path("/usuarios")
@Produces("application/json")
public class UsuariosAPI extends GenericAPI<Usuario, UsuarioService> {

    public UsuariosAPI() throws Exception {
        super();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response get(@PathParam("id") String id) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID no puede estar en blanco").build();
        }
        Usuario usuario;
        try {
            usuario = (Usuario) this.service.get(Integer.parseInt(id));
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode node = JsonManager.toJsonTree(usuario);
        if (node.has("clave")) {
            ((ObjectNode) node).remove("clave");
        }
        return Response.status(200).entity(node.toString()).build();
    }

    @GET
    @Path("/")
    @Produces("application/json")
    public Response list(@QueryParam("limit") String limit, @QueryParam("offset") String offset) {
        List<Usuario> usuarios;
        try {
            if (!ValidationUtils.isNullOrEmpty(limit)) {
                if (ValidationUtils.isNullOrEmpty(offset)) {
                    offset = "0";
                }
                usuarios = this.service.list(Integer.parseInt(limit.trim()), Integer.parseInt(offset.trim()));
            } else {
                usuarios = this.service.list();
            }
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        JsonNode arrNode = JsonManager.toJsonTree(usuarios);
        if (arrNode.isArray()) {
            for (final JsonNode objNode : arrNode) {
                if (objNode.has("clave")) {
                    ((ObjectNode) objNode).remove("clave");
                }
            }
        }
        return Response.status(200).entity(arrNode.toString()).build();
    }

    @POST
    @Path("/{id}")
    @Produces("application/json")
    public Response update(@PathParam("id") String id, @FormParam("data") String data) {
        if ((id == null) || id.trim().length() == 0) {
            return Response.serverError().entity("ID incorrecto").build();
        }
        Usuario usuario = (Usuario) JsonManager.toObject(data, Usuario.class);
        usuario.setId(Long.parseLong(id));
        try {
            usuario = this.service.update(usuario);
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
    public Response create(@FormParam("data") String data) {
        if (data == null || data.trim().length() == 0) {
            return Response.status(200).entity(JsonManager.toJsonString(new Usuario())).build();
        }
        Usuario usuario = null;
        usuario = (Usuario) JsonManager.toObject(data, Usuario.class);
        try {
            this.service.create(usuario);
        } catch (ServiceException ex) {
            return this.handleException(ex);
        }
        return Response.status(200).entity(JsonManager.toJsonString(usuario)).build();
    }
}
