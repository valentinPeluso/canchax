package factorys;

import java.util.Date;

import modelo.Predio;
import modelo.Senia;
import modelo.Turno;

public class TurnoConcreteFactory extends TurnoFactory {

	public TurnoConcreteFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Turno create(String descripcion, Date horario, Senia senia){		
		Predio predio = Predio.getInstance();
		return new Turno(descripcion,predio,horario,senia);
	}

}
