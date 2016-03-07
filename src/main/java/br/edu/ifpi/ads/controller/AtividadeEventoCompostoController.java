package br.edu.ifpi.ads.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.AtividadeEvento;
import br.edu.ifpi.ads.entidade.AtividadeEventoComposto;
import br.edu.ifpi.ads.repositorio.AtividadeEventoRepositorio;
import br.edu.ifpi.ads.repositorio.EventoRepositorio;
import br.edu.ifpi.ads.repositorio.TipoAtividadeEventoRespositorio;
import br.edu.ifpi.ads.util.JPAUtil;

@Controller
public class AtividadeEventoCompostoController {
	
	@Inject private Result result;
	
	@Inject private AtividadeEventoRepositorio atividades;
	@Inject	private EventoRepositorio eventos;
	@Inject	private TipoAtividadeEventoRespositorio tiposAtividadeEvento;

	
	public AtividadeEventoCompostoController() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(){
		
		result.include("atividades", atividades.all());
		result.include("tipos", tiposAtividadeEvento.all());
		result.include("eventos", eventos.all());
		
	}
	
	public void save(AtividadeEventoComposto atividadeEvento, int []selecionados) {
		
		for (int i : selecionados) {
			AtividadeEvento item = atividades.getByID(i);
			atividadeEvento.addItemNoKit(item);
		}
		
		atividades.adicionar(atividadeEvento);
		
		result.redirectTo(AtividadeEventoSimplesController.class).list();
		
	}

}
