/**
 * 
 */
package modelo;

import java.util.Date;

/**
 * @author Valenn
 *
 */
public class Turno {

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
	private long id;
	private String descripcion;
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
