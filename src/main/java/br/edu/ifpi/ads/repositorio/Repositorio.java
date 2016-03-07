package br.edu.ifpi.ads.repositorio;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;

@SessionScoped
public abstract class Repositorio<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	protected List<T> objetos;
	
	protected GenericDAO dao = new GenericJPADAO(); //Instanciação inadequada, usar @Inject
	
	/*
	 * Factory Method, delegando para subclasse informar qual tipo será lidado
	 * Permitindo assim.. que mais operações fiquem genericas..
	 */
	protected abstract Class<T> getTipo();
	
	public T adicionar(T entidade){
		return (T) dao.save(entidade);
	}
	
	public void remover(T entidade){
		dao.delete(entidade);
	}
	
	//Versão usando Generics.. sem necessidade de enviar à subclasse
	public List<T> all(){
		return dao.find(getTipo());
	}
	
	public T getByID(Integer id){
		return (T) dao.find(getTipo(), id);
	}
	
}
