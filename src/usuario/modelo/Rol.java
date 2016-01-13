package usuario.modelo;

public class Rol {

	public Rol(long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public Rol() {
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private String descripcion;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
