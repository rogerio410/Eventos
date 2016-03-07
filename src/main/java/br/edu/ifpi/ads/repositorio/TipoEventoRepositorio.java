package br.edu.ifpi.ads.repositorio;

import br.edu.ifpi.ads.entidade.TipoEvento;

public class TipoEventoRepositorio extends Repositorio<TipoEvento>{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected Class<TipoEvento> getTipo() {
		// TODO Auto-generated method stub
		return TipoEvento.class;
	}

}
