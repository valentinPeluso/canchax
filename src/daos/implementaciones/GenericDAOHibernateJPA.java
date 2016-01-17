package daos.implementaciones;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import daos.GenericDAO;
import persistencia.PersistenceManager;


public class GenericDAOHibernateJPA<T> implements GenericDAO<T> {
	protected Class <T> persistentClass;
	private EntityManager entityManager;
	
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager; 
	}
	public EntityManager getEntityManager(){
		return entityManager; 
	}
	
	public GenericDAOHibernateJPA() {
		super();
		this.setEntityManager(PersistenceManager.getInstance());
	}
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}
	public String getClassName() {
		return this.getPersistentClass().getName();
	}
	@Override
	public T delete(Serializable id) {
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		if(entity!=null){
			this.delete(entity);
		}
		return entity;
	}
	@Override
	public void save(T entity) {
		EntityTransaction etx = this.getEntityManager().getTransaction();
		etx.begin();
		this.getEntityManager().persist(entity);
		etx.commit();
	}
	@Override
	public void delete(T entity) {
		EntityTransaction etx = this.getEntityManager().getTransaction();
		etx.begin();
		this.getEntityManager().remove(this.getEntityManager().contains(entity) ? entity : this.getEntityManager().merge(entity));
		etx.commit();	
	}
	@Override
	public void update(T entity) {
		EntityTransaction etx = this.getEntityManager().getTransaction();
		etx.begin();
		this.getEntityManager().merge(entity);
		etx.commit();
	}
	@Override
	public Object find(Serializable id) {
		EntityTransaction etx = this.getEntityManager().getTransaction();
		etx.begin();
		T entity = this.getEntityManager().find(this.getPersistentClass(), id);
		etx.commit();
		return entity;
	}
	@Override
	public List<T> list() {
		EntityTransaction etx = this.getEntityManager().getTransaction();
		etx.begin();
		List<T> items=(List<T>)((this.getEntityManager().createQuery(String.format("FROM %s", this.getClassName()))).getResultList());
		etx.commit();
		return items;
	}
	@Override
	public List<T> get(String where, Hashtable<String, Object> parameters) {
		EntityTransaction etx = this.getEntityManager().getTransaction();
		etx.begin();
		
		// Se crea la query 
		String queryStatement = String.format("FROM %s WHERE %s", this.getClassName(), where);

		Query query = this.getEntityManager().createQuery(queryStatement);
		
		/* 
		 * Recorremos el hashtable de parametros para setear los
		 * Prepared Statements
		 */
		
		Iterator it = parameters.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			query.setParameter((String) entry.getKey(), entry.getValue());
		}
		
		/*
		 * Ya tenemos todos los parametros generados
		 */
		
		List<T> items=(List<T>)(query).getResultList();
		etx.commit();
		return items;
	}
	@Override
	public List<T> list(int limit, int offset) {
		 EntityTransaction etx = this.getEntityManager().getTransaction();
		 etx.begin();
		 List<T> items = (List<T>) ((this.getEntityManager().createQuery(String.format("FROM %s", this.getClassName()))).setFirstResult(offset).setMaxResults(limit).getResultList());
		 etx.commit();
		 return items;
	}
	

}