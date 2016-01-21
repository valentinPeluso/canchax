package factorys;

import java.util.Date;
import modelo.Senia;
import modelo.Turno;

public class TurnoConcreteFactory extends TurnoFactory {

	public TurnoConcreteFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Turno create(String descripcion, Date horario, Senia senia){			
		return new Turno(descripcion,horario,senia);
	}

}
