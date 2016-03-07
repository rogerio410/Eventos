package br.edu.ifpi.ads.zprincipal;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.TipoAtividadeEvento;

public class NovoTipoAtividadeEvento {
	
	public static void main(String[] args) {
		
		
		GenericDAO dao = new GenericJPADAO();
		
		TipoAtividadeEvento tae = new  TipoAtividadeEvento();
		
		tae.setNome("Minicurso");
		dao.save(tae);
		
		tae.setNome("Palestra");
		dao.save(tae);
		
		tae.setNome("MesaRedonda");
		dao.save(tae);
		
		
	}

}
