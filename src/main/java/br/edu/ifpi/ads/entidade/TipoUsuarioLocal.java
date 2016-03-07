package br.edu.ifpi.ads.entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("UsuarioLocal")
public class TipoUsuarioLocal extends TipoUsuario{
	
	public TipoUsuarioLocal() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean autenticar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
