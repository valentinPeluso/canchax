package aspectos;
import java.io.Serializable;
import java.util.Date;

import aspectos.DataRow;
import logs.Log;
import daos.implementaciones.*;

public aspect AspectoDAOSImpl {
	pointcut pointcutAlta(DataRow data):(execution (* GenericDAOHibernateJPA.save(Object))&&args(data));
	pointcut pointcutModificacion(DataRow data):(execution (* GenericDAOHibernateJPA.update(Object))&&args(data));
	pointcut pointcutBaja(DataRow data):(execution (* GenericDAOHibernateJPA.delete(Object))&&(!execution (* GenericDAOHibernateJPA.delete(Serializable)))&&args(data));  
	
	
	after() : pointcutAlta(DataRow){
		LogDAOHibernateJPA dao = new LogDAOHibernateJPA();
    	Log l = new Log();
    	String[] entidad = thisJoinPoint.getArgs()[0].getClass().toString().split("\\.");
    	l.setOperacion(Log.TIPO_OPERACION.ALTA);
    	l.setEntidad(entidad[entidad.length-1]);
    	l.setFecha(new Date());
    	l.setIdEntidad(((DataRow )thisJoinPoint.getArgs()[0]).getId());
    	dao.save(l);
    };
    
    after() : pointcutModificacion(DataRow){
		LogDAOHibernateJPA dao = new LogDAOHibernateJPA();
    	Log l = new Log();
    	String[] entidad = thisJoinPoint.getArgs()[0].getClass().toString().split("\\.");
    	l.setOperacion(Log.TIPO_OPERACION.MODIFICACION);
    	l.setEntidad(entidad[entidad.length-1]);
    	l.setFecha(new Date());
    	l.setIdEntidad(((DataRow )thisJoinPoint.getArgs()[0]).getId());
    	dao.save(l);
    };
    
    after() : pointcutBaja(DataRow){
		LogDAOHibernateJPA dao = new LogDAOHibernateJPA();
    	Log l = new Log();
    	String[] entidad = thisJoinPoint.getArgs()[0].getClass().toString().split("\\.");
    	l.setOperacion(Log.TIPO_OPERACION.BAJA);
    	l.setEntidad(entidad[entidad.length-1]);
    	l.setFecha(new Date());
    	l.setIdEntidad(((DataRow )thisJoinPoint.getArgs()[0]).getId());
    	dao.save(l);
    };
}
