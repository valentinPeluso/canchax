package cancha.factory;

import cancha.modelo.Cancha;

public class CanchaConcreteFactory extends CanchaFactory{

	public CanchaConcreteFactory() {
		// TODO Auto-generated constructor stub
	}	
		
	public Cancha create(String descripcion){		
		return new Cancha(descripcion);
	}
}
