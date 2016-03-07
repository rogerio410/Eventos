package br.edu.ifpi.ads.repositorio;

import br.edu.ifpi.ads.entidade.SegmentoUsuario;

public class SegmentoUsuarioRepositorio extends Repositorio<SegmentoUsuario>{
	
	@Override
	protected Class<SegmentoUsuario> getTipo() {
		// TODO Auto-generated method stub
		return SegmentoUsuario.class;
	}

}
