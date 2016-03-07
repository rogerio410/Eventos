package br.edu.ifpi.ads.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.edu.ifpi.ads.entidade.TipoUsuario;
import br.edu.ifpi.ads.entidade.TipoUsuarioLocal;
import br.edu.ifpi.ads.entidade.Usuario;
import br.edu.ifpi.ads.repositorio.PerfilUsuarioRepositorio;
import br.edu.ifpi.ads.repositorio.SegmentoUsuarioRepositorio;
import br.edu.ifpi.ads.repositorio.TipoUsuarioRepositorio;
import br.edu.ifpi.ads.repositorio.UsuarioRepositorio;

@Controller
public class UsuarioController {
	
	@Inject
	private Result result;
	
	@Inject
	private Usuario usuario;
	
	@Inject	private UsuarioRepositorio usuarios;
	@Inject private SegmentoUsuarioRepositorio segmentos;
	@Inject private PerfilUsuarioRepositorio perfis;
	@Inject private TipoUsuarioRepositorio tipos;
	
	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}
	
	public void add(){
		result.include("perfis", perfis.all());
		result.include("segmentos", segmentos.all());
		
	}
	
	public void save(Usuario usuario){
		
		//Settando usuario local
		usuario.setTipoUsuario(tipos.LOCAL());
		
		usuarios.adicionar(usuario);
		result.redirectTo(this).list();
	}
	
	public List<Usuario> list(){
		return usuarios.all();
	}

}
