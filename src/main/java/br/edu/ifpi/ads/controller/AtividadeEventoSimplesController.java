package br.edu.ifpi.ads.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.edu.ifpi.ads.entidade.AtividadeEvento;
import br.edu.ifpi.ads.entidade.AtividadeEventoSimples;
import br.edu.ifpi.ads.repositorio.AtividadeEventoRepositorio;
import br.edu.ifpi.ads.repositorio.EventoRepositorio;
import br.edu.ifpi.ads.repositorio.TipoAtividadeEventoRespositorio;
import br.edu.ifpi.ads.util.DataUtil;

@Controller
public class AtividadeEventoSimplesController {
	
	@Inject
	private Result result;
	
	@Inject	private EventoRepositorio eventos;
	@Inject	private TipoAtividadeEventoRespositorio tiposAtividadeEvento;
	@Inject	private AtividadeEventoRepositorio atividades;
	
	public AtividadeEventoSimplesController() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(){
		result.include("tipos", tiposAtividadeEvento.all());
		result.include("eventos", eventos.all());
	}
	
	public void save(AtividadeEventoSimples atividadeEvento, String horario){
		
		atividadeEvento.setHorario(DataUtil.normalizeDataHora(horario));
		
		atividades.adicionar(atividadeEvento);
		
		result.redirectTo(this).list();
	}
	
	public List<AtividadeEvento> list(){
		return atividades.all();
	}
	

}
