package factorys;

import java.util.Date;

import modelo.Senia;
import modelo.Turno;

public abstract class TurnoFactory {
	
	public TurnoFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public abstract Turno create(String descripcion, Date horario, Senia senia);	

}
