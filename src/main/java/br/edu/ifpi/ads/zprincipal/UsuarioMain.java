package br.edu.ifpi.ads.zprincipal;

import br.edu.ifpi.ads.dao.GenericDAO;
import br.edu.ifpi.ads.dao.GenericJPADAO;
import br.edu.ifpi.ads.entidade.Usuario;

public class UsuarioMain {
	
	public static void main(String[] args) {
		
		GenericDAO dao = new GenericJPADAO();
		
		Usuario usuario = (Usuario)dao.find(Usuario.class, 8);
		
		System.out.println(usuario.getTipoUsuario().getClass().getSimpleName()); 
		
		
	}

}
