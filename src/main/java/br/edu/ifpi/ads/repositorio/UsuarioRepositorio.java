package br.edu.ifpi.ads.repositorio;

import br.edu.ifpi.ads.entidade.Usuario;

public class UsuarioRepositorio extends Repositorio<Usuario>{
	
	@Override
	protected Class<Usuario> getTipo() {
		// TODO Auto-generated method stub
		return Usuario.class;
	}

}
