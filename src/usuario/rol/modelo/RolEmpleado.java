package usuario.rol.modelo;

public class RolEmpleado extends Rol {
	

	public RolEmpleado(String descripcion, String user, String pass) {
		super(descripcion);
		this.user = user;
		this.pass = pass;
	}
	
	public RolEmpleado() {
		// TODO Auto-generated constructor stub
	}
	
	private String user;
	private String pass;
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
