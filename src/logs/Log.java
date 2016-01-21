package logs;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="Log")
public class Log implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TIPO_OPERACION{
		ALTA,
		BAJA,
		MODIFICACION
	}
	@Id
	@GeneratedValue
	private long id;
	
	private Date fecha;
	private TIPO_OPERACION operacion;
	private String entidad;
	private long idEntidad;
	
	public Log() {
		super();
	}
	
	public Log(Date fecha, TIPO_OPERACION operacion, String entidad,long idEntidad) {
		super();
		this.fecha = fecha;
		this.operacion = operacion;
		this.entidad = entidad;
		this.idEntidad = idEntidad;
	}
	

	public long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(long idEntidad) {
		this.idEntidad = idEntidad;
	}


	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public TIPO_OPERACION getOperacion() {
		return operacion;
	}

	public void setOperacion(TIPO_OPERACION operacion) {
		this.operacion = operacion;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	

}
