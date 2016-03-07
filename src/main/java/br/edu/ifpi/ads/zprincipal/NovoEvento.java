package br.edu.ifpi.ads.zprincipal;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.dao.GenericJPADAO.QueryType;
import br.edu.ifpi.ads.entidade.AtividadeEvento;
import br.edu.ifpi.ads.entidade.Evento;
import br.edu.ifpi.ads.entidade.FaseEvento;
import br.edu.ifpi.ads.entidade.TipoEvento;
import br.edu.ifpi.ads.repositorio.EventoRepositorio;
import br.edu.ifpi.ads.repositorio.InstituicaoRepositorio;

public class NovoEvento {
	
	public static void main(String[] args) {
		
		EventoRepositorio eventos = new EventoRepositorio();
		InstituicaoRepositorio instituicoes = new InstituicaoRepositorio();
		
		GenericDAO dao = new GenericJPADAO();
		
		Evento evento = new Evento();
		
		evento.setNome("SEQUIM");
		
		evento.setTipoEvento((TipoEvento)dao.find(TipoEvento.class, 1));
		
		evento.setInstituicao(instituicoes.getBySigla("UFPI") );
		
		evento.setFaseEvento((FaseEvento)dao.findSingleResult(QueryType.JPQL, "from FaseEvento f where f.id = 1"));
		
		//eventos.adicionar(evento);
		
		for (Evento e : eventos.all()) {
			System.out.println(e.getTipoEvento().getNome() + " - "  + e.getNome() + " - " +e.getInstituicao().getSigla() + " - " + e.getFaseEvento().getNome());
			System.out.println("Qtd atv.: " + e.getAtividades().size());
			
			//Depois de ter adicionado atividades no BD.
			for (AtividadeEvento ae: e.getAtividades()) {
				System.out.println("\t - "+ae.getTipoAtividadeEvento().getNome() + " - " + ae.getNome());
			}
		}
		
		
	}

}
