package br.edu.ifpi.ads.dao;

import java.util.List;
import java.util.Map;

import br.edu.ifpi.ads.dao.GenericJPADAO.QueryType;

public interface GenericDAO {
	
	public Object save(Object entity);
	public void delete(Object entity);
	public Object find(Class entityClass, Object id);
	
	public List find(Class entityClass);
	
	public List find(Class entityClass, int firstResult, int maxResults);
	public List find(String queryName);
	
	public List find(String queryName, Map<String, Object> namedParams);
	public List find(String queryName, Map<String, Object> namedParams, int firstResult, int maxResults);
	public List find(QueryType type, String query, Map<String,Object> namedParams, int firstResult, int maxResults);
	
	
	public int execute(String comando);
	public int execute(String namedQuery, Map namedParams);
	public int execute(QueryType type, String comando);
	
	public int aggregateFunction(String queryName, Map<String, Object> namedParams);
	
	public Object findSingleResult(QueryType type, String query);
	public Object findSingleResult(QueryType type, String query, Map<String, Object> namedParams);
	
}
