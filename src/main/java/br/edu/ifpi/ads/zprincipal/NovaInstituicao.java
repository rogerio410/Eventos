package br.edu.ifpi.ads.zprincipal;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.Instituicao;
import br.edu.ifpi.ads.util.JPAUtil;

public class NovaInstituicao {
	
	public static void main(String[] args) {
		
		GenericDAO dao = new GenericJPADAO();
		
		Instituicao instituicao = new Instituicao();
		instituicao.setNome("Instituto Federal do Piaui");
		instituicao.setSigla("IFPI");
		
		JPAUtil.getCurrentEntityManager().getTransaction().begin();
		dao.save(instituicao);
		JPAUtil.getCurrentEntityManager().getTransaction().commit();;
		
		System.out.println("Finalizado.");
		
		
	}

}
