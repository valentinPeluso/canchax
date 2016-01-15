/**
 * 
 */
package services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import modelo.Turno;

/**
 * @author Valenn
 *
 */
@Path("/")
public class TurnoService {

	/**
	 * 
	 */
	public TurnoService() {
		// TODO Auto-generated constructor stub
	}
	
	@GET
	@Path("/turnos")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getTurnos(){	
		
		ArrayList<Turno> list = new ArrayList<Turno>();
//		list.add(new Turno(1,"Descripcion turno 1"));
//		list.add(new Turno(2,"Descripcion turno 2"));
//		list.add(new Turno(3,"Descripcion turno 3"));
		String json = new Gson().toJson(list);
		// return HTTP response 200 in case of success
		return Response.status(200).entity(json).build();		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
