package factorys;

import modelo.Predio;

public abstract class PredioFactory {

	public PredioFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract Predio create(String direccion);	

}
