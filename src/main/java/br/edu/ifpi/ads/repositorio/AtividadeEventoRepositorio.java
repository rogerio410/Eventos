package br.edu.ifpi.ads.repositorio;

import javax.enterprise.context.SessionScoped;

import br.edu.ifpi.ads.entidade.AtividadeEvento;

@SessionScoped
public class AtividadeEventoRepositorio extends Repositorio<AtividadeEvento>{
	
	@Override
	protected Class<AtividadeEvento> getTipo() {
		// TODO Auto-generated method stub
		return AtividadeEvento.class;
	}

}
