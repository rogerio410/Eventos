package br.edu.ifpi.ads.zprincipal;

import java.util.Calendar;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.AtividadeEvento;
import br.edu.ifpi.ads.entidade.AtividadeEventoSimples;
import br.edu.ifpi.ads.entidade.TipoAtividadeEvento;
import br.edu.ifpi.ads.repositorio.EventoRepositorio;

public class NovaAtividadeEvento {
	
	public static void main(String[] args) {
		
		GenericDAO dao = new GenericJPADAO();
		EventoRepositorio eventos = new EventoRepositorio();
		
		AtividadeEvento ae = new AtividadeEventoSimples();
		ae.setHorario(Calendar.getInstance());
		eventos.getByID(1).addAtividade(ae); ;
		
		ae.setNome("Android X: Lá vem Ele!!");
		ae.setTipoAtividadeEvento((TipoAtividadeEvento)dao.find(TipoAtividadeEvento.class, 1));
		
		dao.save(ae);
		
		
	}

}
