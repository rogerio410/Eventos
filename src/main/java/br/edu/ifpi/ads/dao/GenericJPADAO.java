package br.edu.ifpi.ads.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpi.ads.util.JPAUtil;

public class GenericJPADAO implements GenericDAO, Serializable {

	public enum QueryType { JPQL, NATIVE, NAMED }
	
	public Object save(Object entity) {
		EntityManager em = JPAUtil.getCurrentEntityManager();
		try {
			//em.getTransaction().begin(); //Se Usar AppWeb a Transacao será controlada pelo OpenSessionInView
			Object obj = em.merge(entity);
			//em.getTransaction().commit();
			return obj;
		} catch (Exception e) {
			//em.getTransaction().rollback();
			throw new DAOException("A operacao nao foi realizada.", e);
		} finally {
		}
	}

	public void delete(Object entity) {
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		try {
			//em.getTransaction().begin();
			em.remove(em.merge(entity));
			//em.getTransaction().commit();
		} catch (Exception e) {
			//em.getTransaction().rollback();
			throw new DAOException("A operacao nao foi realizada com sucesso.", e);
		} finally {
		}
	}

	public Object find(Class entityClass, Object id) {
		Object result = null;
		EntityManager em = JPAUtil.getCurrentEntityManager();
		result = em.find(entityClass, id);
		return result;
	}

	public List find(Class entityClass) {
		return find(entityClass, -1, -1);
	}
	
	public List<?> findT(Class entityClass) {
		return find(entityClass, -1, -1);
	}
	
	public List find(Class entityClass, int firstResult, int maxResults) {
		List result = null;
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		try {
			Query q = em.createQuery("select obj from " + entityClass.getSimpleName() + " obj");
			if (firstResult >= 0 && maxResults >= 0) {
				q = q.setFirstResult(firstResult).setMaxResults(maxResults);
			}
		    result = q.getResultList();   
		} finally {
			//em.close();
		}
		return result;
	}

	public List find(String queryName, Map<String,Object> namedParams) {
		return find(QueryType.NAMED, queryName, namedParams);
	}
	
	public List find(QueryType type, String query, Map<String,Object> namedParams) {
		return find(type, query, namedParams, -1, -1);
	}
	
	public List find(String queryName, Map<String,Object> namedParams, int firstResult, int maxResults) {
		return find(QueryType.NAMED, queryName, namedParams, firstResult, maxResults);
	}
	
	public List find(QueryType type, String query, Map<String,Object> namedParams, int firstResult, int maxResults) {
		
		List result = null;
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		try {
			Query q;
			if (type == QueryType.JPQL) {
				q = em.createQuery(query);
			} else if (type == QueryType.NATIVE) {
				q = em.createNativeQuery(query);
			} else if (type == QueryType.NAMED) {
				q = em.createNamedQuery(query); 
			} else {
				throw new IllegalArgumentException("Tipo de Query invalido: " + type);
			}
			
			// Define os parâmetros da consulta
			Set<String> keys = namedParams.keySet();
			for (String key : keys) {
				q.setParameter(key, namedParams.get(key));
			}
			
			// Define pagina��o ou nao
			if (firstResult >= 0 && maxResults >= 0) {
				q = q.setFirstResult(firstResult).setMaxResults(maxResults);
			}

			// Executa a consulta
		    result = q.getResultList();   
		} finally {
			//em.close();
		}
		return result;
	}

	public List find(String queryName) {
		// TODO Auto-generated method stub
		return find(queryName, new HashMap<String, Object>());
	}
	
	public int execute(String comando){
		
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		Query q = em.createQuery(comando);
		
		try {
			em.getTransaction().begin();
			int c = q.executeUpdate();
			em.getTransaction().commit();
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("A operacao nao foi realizada com sucesso.", e);
		}
		
	}
	
	public int execute(QueryType type, String comando){
		
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		Query q;
		if (type == QueryType.JPQL) {
			q = em.createQuery(comando);
		} else if (type == QueryType.NATIVE) {
			q = em.createNativeQuery(comando);
		} else if (type == QueryType.NAMED) {
			q = em.createNamedQuery(comando);
		} else {
			throw new IllegalArgumentException("Tipo de Query invalido: " + type);
		}
		
		
		try {
			em.getTransaction().begin();
			int c = q.executeUpdate();
			em.getTransaction().commit();
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("A operacao nao foi realizada com sucesso.", e);
		}
		
	}
	
	public int execute(String namedQuery, Map namedParams){
		
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		Query q = em.createNamedQuery(namedQuery);
		
		// Define os parâmetros da consulta
		Set<String> keys = namedParams.keySet();
		for (String key : keys) {
			q.setParameter(key, namedParams.get(key));
		}
		
		try {
			em.getTransaction().begin();
			int c = q.executeUpdate();
			em.getTransaction().commit();
			return c;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new DAOException("A operacao nao foi realizada com sucesso.", e);
		}
		
	}
	
	public int aggregateFunction(String queryName, Map<String, Object> namedParams) {
		
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
				
		Query q = em.createNamedQuery(queryName);
		
		// Define os parâmetros da consulta
		Set<String> keys = namedParams.keySet();
		for (String key : keys) {
			q.setParameter(key, namedParams.get(key));
		}
		
		int ret;
		
		try {
			ret = (Integer)q.getSingleResult();
		}catch (NullPointerException e) {
			// TODO: handle exception
			ret = 0;
		} 
		
		return ret;
	}
	
	
	public Object findSingleResult(QueryType type, String query){
		
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		Query q;
		if (type == QueryType.JPQL) {
			q = em.createQuery(query);
		} else if (type == QueryType.NATIVE) {
			q = em.createNativeQuery(query);
		} else if (type == QueryType.NAMED) {
			q = em.createNamedQuery(query);
		} else {
			throw new IllegalArgumentException("Tipo de Query invalido: " + type);
		}
		
		
		try {
			Object o = q.getSingleResult();
			return o;
		} catch (Exception e) {
			throw new DAOException("A operacao nao foi realizada com sucesso.", e);
		}
		
		
	}
	
	
	public Object findSingleResult(QueryType type, String query, Map<String, Object> namedParams){
		
		EntityManager em = JPAUtil.getCurrentEntityManager(); //emf.createEntityManager();
		Query q;
		if (type == QueryType.JPQL) {
			q = em.createQuery(query);
		} else if (type == QueryType.NATIVE) {
			q = em.createNativeQuery(query);
		} else if (type == QueryType.NAMED) {
			q = em.createNamedQuery(query);
		} else {
			throw new IllegalArgumentException("Tipo de Query invalido: " + type);
		}
		
		// Define os parâmetros da consulta
		Set<String> keys = namedParams.keySet();
		for (String key : keys) {
			q.setParameter(key, namedParams.get(key));
		}
		
		
		try {
			Object o = q.getSingleResult();
			return o;
		} catch (Exception e) {
			throw new DAOException("A operacao nao foi realizada com sucesso.", e);
		}
		
	}
	
	

}
