/**
 * 
 */
package turnos.modelo;

import java.util.Date;

import predio.modelo.Predio;

/**
 * @author Valenn
 *
 */
public class Turno {

	public Turno(long id, String description, Predio predio, Date horario, Senia senia) {
		super();
		this.id = id;
		this.description = description;
		this.predio = predio;
		this.horario = horario;
		this.senia = senia;
	}

	public Turno() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	private long id;
	private String description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
