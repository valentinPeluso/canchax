/**
 * 
 */
package turnos;

/**
 * @author Valenn
 *
 */
public class Turno {

	public Turno(long id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	/**
	 * 
	 */
	public Turno() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	private long id;
	private String description;
	
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

}
