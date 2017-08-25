package com.sam.db.dao.impl;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sam.db.dao.IRepository;

/**
 * @author aboucheritte
 * 2 d�c. 2015
 */

public class Repository implements IRepository{
	
	Logger logger = LogManager.getLogger("CDILogger");
	
	private static EntityManagerFactory emf;

    private EntityManager entityManager;
    
    /***************************************************************************/
	/***************************************************************************/
	public Repository() {
		entityManager = createEntityManager(); // Persistence.createEntityManagerFactory("XExtranetUnit").createEntityManager();
	}
	/***************************************************************************/
	/***************************************************************************/
	public Object create(Object obj) {
		
		try{
			entityManager.getTransaction().begin();
			
			//if(obj instanceof Aog)
			//	System.err.println( ((Aog)obj).getId() );
			
			//obj = entityManager.merge(obj);
			entityManager.persist(obj);
			
			//if(obj instanceof Aog)
			//	System.err.println( ((Aog)obj).getId() );
			
			entityManager.getTransaction().commit();
		}catch(Exception e){
			logger.catching(e);
			
			try{
				entityManager.getTransaction().rollback();
			}catch(Exception e1){
				logger.catching(e1);	
			}	
				
		}	
		
		return obj;
		
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public Object read(String id, Class<?> cls) {
		return entityManager.find(cls, id);
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public Object read(int id, Class<?> cls) {
		return entityManager.find(cls, id);
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public void update(Object obj) {
		try{
			entityManager.getTransaction().begin();
			entityManager.merge(obj);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
		}	
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public void delete(Object obj) {
		
		try{
			entityManager.getTransaction().begin();
			entityManager.remove(obj);
			entityManager.getTransaction().commit();
		}catch(Exception e){
			entityManager.getTransaction().rollback();
		}	
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public Object queryObject(String nameQuery, Map<String, Object> prop) {
		Object obj = null;
		try{ 
			Query query = entityManager.createNamedQuery(nameQuery);
			if(prop!=null)
			for (String mapKey : prop.keySet())
				query.setParameter(mapKey,prop.get(mapKey));
			obj = query.getSingleResult();
		}catch(NoResultException e) {
			//logger.catching(e);
		}catch(Exception r){
			//logger.catching(r);
		}
		return obj;
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public int query(String nameQuery, Map<String, Object> prop) {
		int obj =-1;
		try{ 
			
			logger.info("debut");
			
			entityManager.getTransaction().begin();
			Query query = entityManager.createNamedQuery(nameQuery);
			
			if(prop!=null && prop.size()>0)
			for (String mapKey : prop.keySet())
				query.setParameter(mapKey,prop.get(mapKey));
			
			logger.info("avant");
			
			logger.info(query.toString());
			
			obj = query.executeUpdate();
			
			entityManager.getTransaction().commit();
			logger.info("fin");
		}catch(Exception e) {
			entityManager.getTransaction().rollback();
			logger.catching(e);
		}
		return obj;
	}
	
	
	/***************************************************************************************************/
	/***************************************************************************************************/
	public List<?> queryList(String nameQuery, Map<String, Object> prop) {
		List<?> items = null;
		try{ 
			Query query = entityManager.createNamedQuery(nameQuery);
			if(prop!=null)
			for (String mapKey : prop.keySet())
				query.setParameter(mapKey,prop.get(mapKey));
			items = query.getResultList();
		}catch(Exception e) {
			logger.catching(e);
		}
		return items;
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	public  List<?> readAll(Class<?> cls){ 
		return entityManager.createQuery("SELECT e FROM " + cls.getName() + " e").getResultList();
	}
	/***************************************************************************************************/
	/***************************************************************************************************/
	
	 public static EntityManager createEntityManager() {
	        if (emf == null) {
	        	emf = Persistence.createEntityManagerFactory("StudentLink");
	            //throw new IllegalStateException("Context is not initialized yet.");
	        }

	        return emf.createEntityManager();
	    }
	
}
