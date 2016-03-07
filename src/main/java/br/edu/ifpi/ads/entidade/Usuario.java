package br.edu.ifpi.ads.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	
	@Id @GeneratedValue
	private int id;
	private String login;
	private String senha;
	
	@ManyToOne
	private PerfilUsuario perfilUsuario; //Participante | Organizador | ResponsavelAtividade
	
	@ManyToOne
	private SegmentoUsuario segmentoUsuario; //Aluno | Professor | Profissional
	
	@ManyToOne(cascade=CascadeType.ALL)
	private TipoUsuario tipoUsuario; //Local | Social | Remoto
	
	@OneToMany(mappedBy="usuario")
	private List<Inscricao> inscricoes;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public PerfilUsuario getPerfilUsuario() {
		return perfilUsuario;
	}

	public void setPerfilUsuario(PerfilUsuario perfilUsuario) {
		this.perfilUsuario = perfilUsuario;
	}

	public SegmentoUsuario getSegmentoUsuario() {
		return segmentoUsuario;
	}

	public void setSegmentoUsuario(SegmentoUsuario segmentoUsuario) {
		this.segmentoUsuario = segmentoUsuario;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(List<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
