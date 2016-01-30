package modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class Senia implements Serializable{
	
	private static final long serialVersionUID = -7391394693390747530L;
	private long id;
	private float cantidad;
	private String descripcion;
	private String telefono;
	private Turno turno;
	
	public Senia(float cantidad, String descripcion, String telefono) {
		super();
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.telefono = telefono;
	}

	public Senia() {
		// TODO Auto-generated constructor stub
	}
	@GenericGenerator(
			name = "generator", 
			strategy = "foreign", 
			parameters = @Parameter(
					name = "property", 
					value = "turno")
			)
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ID_TURNO", unique = true, nullable = false)
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
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	public Turno getTurno() {
		return turno;
	}
	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
