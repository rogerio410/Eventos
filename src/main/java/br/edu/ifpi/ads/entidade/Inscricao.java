package br.edu.ifpi.ads.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Inscricao {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String numero;
	
	@ManyToOne
	private StatusInscricao statusInscricao; //Se for virar State, essa classe poder ser Abstrata
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany
	private List<AtividadeEvento> atividades;
	
	@ManyToOne
	private Evento evento;
	
	@ManyToOne
	private CupomPromocional cupomPromocional;
	
	public Inscricao() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public StatusInscricao getStatusInscricao() {
		return statusInscricao;
	}

	public void setStatusInscricao(StatusInscricao statusInscricao) {
		this.statusInscricao = statusInscricao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AtividadeEvento> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<AtividadeEvento> atividades) {
		this.atividades = atividades;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public CupomPromocional getCupomPromocional() {
		return cupomPromocional;
	}

	public void setCupomPromocional(CupomPromocional cupomPromocional) {
		this.cupomPromocional = cupomPromocional;
	}

}
