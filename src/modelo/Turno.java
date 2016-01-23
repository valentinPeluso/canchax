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


@Entity
public class Turno implements Serializable{	
	
	private static final long serialVersionUID = -8160124978538221149L;
	
	private long id;
	private String descripcion;	
	private Date horario;
	private Senia senia;	
	
	public Turno() {
		// TODO Auto-generated constructor stub
	}
	
	public Turno(String descripcion,Date horario, Senia senia) {
		// TODO Auto-generated constructor stub
		super();
		this.descripcion = descripcion;	
		this.horario = horario;
		this.senia = senia;
	}		
	
	@Id
	@GeneratedValue
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
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ID_SENIA")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public Senia getSenia() {
		return senia;
	}
	public void setSenia(Senia senia) {
		this.senia = senia;
	}

}
