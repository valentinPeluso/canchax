package usuario.rol.modelo;

public class RolAdministrador extends Rol {
	
	public RolAdministrador(String descripcion, String user, String pass) {
		super(descripcion);
		this.user = user;
		this.pass = pass;
	}

	private String user;
	private String pass;	

	public RolAdministrador() {
		// TODO Auto-generated constructor stub
	}

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
