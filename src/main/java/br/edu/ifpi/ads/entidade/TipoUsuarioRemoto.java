package br.edu.ifpi.ads.entidade;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="UsuarioRemoto")
public class TipoUsuarioRemoto extends TipoUsuario{
	
	@Override
	public boolean autenticar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
