package factorys;

import modelo.Senia;

public abstract class SeniaFactory {
	public SeniaFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract Senia create(float cantidad, String descripcion, String telefono);	
}
