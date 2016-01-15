package daos;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

public interface GenericDAO<T> {

	
	public void save(T entity);
	public void delete(T entity);
	public T delete(Serializable id);
	public void update(T entity);
	public Object find(Serializable id);
	public List<T> list();
	public List<T> get(String where, Hashtable<String, Object> parameters);
	
}