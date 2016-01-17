package factorys;

import modelo.Cancha;
import modelo.Predio;

public class CanchaConcreteFactory extends CanchaFactory{

	public CanchaConcreteFactory() {
		// TODO Auto-generated constructor stub
	}	
		
	public Cancha create(String descripcion, Predio predio){		
		return new Cancha(descripcion,predio);
	}
}
