package turnos.modelo;

public class Senia {

	public Senia(long id, float cantidad, String descripcion, String telefono) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.telefono = telefono;
	}
	
	public Senia() {
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private float cantidad;
	private String descripcion;
	private String telefono;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
