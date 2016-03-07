package br.edu.ifpi.ads.zprincipal;

import java.util.List;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.Instituicao;

public class ListarInstituicoes {
	
	public static void main(String[] args) {
		
		GenericDAO dao = new GenericJPADAO();
		
		List<Instituicao> instituicoes = dao.find(Instituicao.class);
		
		for (Instituicao instituicao : instituicoes) {
			System.out.println(instituicao.getNome());
		}
		
		
	}

}
