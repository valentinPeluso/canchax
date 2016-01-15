package cancha.factory;

import cancha.modelo.Cancha;

public abstract class CanchaFactory {	
	
	public CanchaFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract Cancha create(String descripcion);	

}
