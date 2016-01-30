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
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;


@Entity
public class Turno implements Serializable{	
	
	private static final long serialVersionUID = -8160124978538221149L;
	
	private long id;
	private Date horario;
	private Senia senia;	
	
	public Turno() {
		// TODO Auto-generated constructor stub
	}
	
	public Turno(Date horario, Senia senia) {
		// TODO Auto-generated constructor stub
		super();
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
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	@OneToOne(fetch=FetchType.LAZY,mappedBy = "turno")
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	public Senia getSenia() {
		return senia;
	}
	public void setSenia(Senia senia) {
		this.senia = senia;
	}

}
