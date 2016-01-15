package modelo;

public abstract class Rol {

	public Rol(String descripcion) {
		super();
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
