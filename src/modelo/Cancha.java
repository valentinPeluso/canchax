package modelo;

public class Cancha {

	
	public Cancha() {
		// TODO Auto-generated constructor stub
		super();
	}
	

	public Cancha(String descripcion) {
		// TODO Auto-generated constructor stub
		super();
		this.descripcion = descripcion;
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
