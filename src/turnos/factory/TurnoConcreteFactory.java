package turnos.factory;

import java.util.Date;

import cancha.modelo.Cancha;
import predio.modelo.Predio;
import turnos.modelo.Senia;
import turnos.modelo.Turno;

public class TurnoConcreteFactory extends TurnoFactory {

	public TurnoConcreteFactory() {
		// TODO Auto-generated constructor stub
	}
	
	public Turno create(String descripcion, Date horario, Senia senia){		
		Predio predio = Predio.getInstance();
		return new Turno(descripcion,predio,horario,senia);
	}

}
