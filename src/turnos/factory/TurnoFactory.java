package turnos.factory;

import java.util.Date;

import turnos.modelo.Senia;
import turnos.modelo.Turno;

public abstract class TurnoFactory {
	
	public TurnoFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract Turno create(String descripcion, Date horario, Senia senia);	

}
