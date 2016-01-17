/**
 * 
 */
package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;

/**
 * @author Valenn
 *
 */
@Entity
public class Turno implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8160124978538221149L;

	public Turno() {
		// TODO Auto-generated constructor stub
	}
	
	public Turno(String descripcion, Predio predio, Date horario, Senia senia) {
		// TODO Auto-generated constructor stub
		super();
		this.descripcion = descripcion;
		this.predio = predio;
		this.horario = horario;
		this.senia = senia;
	}

	/**
	 * @param args
	 */
	@Id
	@GeneratedValue
	private long id;
	private String descripcion;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_PREDIO")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Predio predio;
	private Date horario;
	private Senia senia;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

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

	public Predio getPredio() {
		return predio;
	}

	public void setPredio(Predio predio) {
		this.predio = predio;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public Senia getSenia() {
		return senia;
	}

	public void setSenia(Senia senia) {
		this.senia = senia;
	}

	


}
