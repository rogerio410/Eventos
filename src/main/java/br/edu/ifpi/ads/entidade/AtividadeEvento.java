package br.edu.ifpi.ads.entidade;

import java.util.Calendar;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="simples_ou_composto")
public abstract class AtividadeEvento {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	@ManyToOne
	private TipoAtividadeEvento tipoAtividadeEvento; // MiniCurso | MesaRedonda | Palestra | Kit(Palestras..)
	
	@ManyToOne
	private Evento evento;
	
	public AtividadeEvento() {
		// TODO Auto-generated constructor stub
	}
	
	public abstract Calendar getHorario();
	public abstract void setHorario(Calendar horario);
	
	public abstract Double getValor();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAtividadeEvento getTipoAtividadeEvento() {
		return tipoAtividadeEvento;
	}

	public void setTipoAtividadeEvento(TipoAtividadeEvento tipoAtividadeEvento) {
		this.tipoAtividadeEvento = tipoAtividadeEvento;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
