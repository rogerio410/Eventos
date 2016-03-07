package br.edu.ifpi.ads.repositorio;

import br.edu.ifpi.ads.entidade.Evento;

public class EventoRepositorio extends Repositorio<Evento>{

	private static final long serialVersionUID = 1L;

	@Override
	protected Class getTipo() {
		// TODO Auto-generated method stub
		return Evento.class;
	}
	
	
}
