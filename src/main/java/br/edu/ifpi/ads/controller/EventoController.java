package br.edu.ifpi.ads.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.edu.ifpi.ads.entidade.Evento;
import br.edu.ifpi.ads.entidade.Instituicao;
import br.edu.ifpi.ads.entidade.TipoEvento;
import br.edu.ifpi.ads.repositorio.EventoRepositorio;
import br.edu.ifpi.ads.repositorio.InstituicaoRepositorio;
import br.edu.ifpi.ads.repositorio.Repositorio;
import br.edu.ifpi.ads.repositorio.TipoEventoRepositorio;


@Controller
public class EventoController {
	
	@Inject
	private EventoRepositorio eventos; // = new EventoRepositorio();
	
	@Inject
	private InstituicaoRepositorio instituicoes;
	
	@Inject
	private TipoEventoRepositorio tiposEvento;
	
	@Inject
	private Result result;
	
	public EventoController() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(){
		
		result.include("instituicoes", instituicoes.all());
		result.include("tipos", tiposEvento.all());
		
	}
	
	public List<Evento> list(){
		return eventos.all();
	}
	
	public void save(Evento evento){
		
		eventos.adicionar(evento);
		
		result.redirectTo(this).list();
		
	}
	
	public void listJSON(){
		result.use(Results.json()).from(eventos.all(), "eventos").serialize();
	}
	
	public void showJSON(int id){
		result.use(Results.json()).from(eventos.getByID(id)).recursive().serialize();
	}

	
}
