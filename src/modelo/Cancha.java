package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Cancha implements Serializable {
	
	public Cancha(String descripcion, Predio predio) {
		super();
		this.descripcion = descripcion;
		this.predio = predio;
	}

	private static final long serialVersionUID = -8741863440005330443L;

	public Cancha() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	@Id
	@GeneratedValue
	private long id;
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Predio predio;

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


	public Predio getPredio() {
		return predio;
	}


	public void setPredio(Predio predio) {
		this.predio = predio;
	}

}
