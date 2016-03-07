package br.edu.ifpi.ads.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.Instituicao;
import br.edu.ifpi.ads.repositorio.InstituicaoRepositorio;


@Controller
public class InstituicaoController {
	
	GenericDAO dao = new GenericJPADAO();
	
	@Inject
	private InstituicaoRepositorio instituicoes;
	
	@Inject
	private Result result;
	
	public InstituicaoController() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(){ //chamar form
		
	}
	
	public List<Instituicao> list(){
		
		return  instituicoes.all();
	}
	
	public void save(Instituicao instituicao){
		
		instituicoes.adicionar(instituicao);
		
		result.redirectTo(this).list();
		
	}
	

}
