package br.edu.ifpi.ads.repositorio;

import br.edu.ifpi.ads.dao.GenericJPADAO.QueryType;
import br.edu.ifpi.ads.entidade.Instituicao;

public class InstituicaoRepositorio extends Repositorio<Instituicao>{

	private static final long serialVersionUID = 1L;

	protected Class<Instituicao> getTipo() {
		return Instituicao.class;
	}
	
	public Instituicao getBySigla(String str){
		return (Instituicao)dao.findSingleResult(QueryType.JPQL, "select i from Instituicao i where i.sigla ='"+str+"'");
	}
	
}
