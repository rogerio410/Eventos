package br.edu.ifpi.ads.repositorio;

import br.edu.ifpi.ads.dao.GenericJPADAO.QueryType;
import br.edu.ifpi.ads.entidade.TipoUsuario;

public class TipoUsuarioRepositorio extends Repositorio<TipoUsuario> {
	
	@Override
	protected Class<TipoUsuario> getTipo() {
		// TODO Auto-generated method stub
		return TipoUsuario.class;
	}
	
	public TipoUsuario getByNome(String str){
		return (TipoUsuario)dao.findSingleResult(QueryType.JPQL, "from TipoUsuario u where nome = '"+str+"'");
	}
	
	public TipoUsuario LOCAL(){
		return getByNome("local");
	}; 

}
