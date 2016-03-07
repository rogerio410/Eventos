package br.edu.ifpi.ads.entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Evento	{
	
	//Oportunidade Composite..Eventos Compostos
	
	@Id
	@GeneratedValue
	private int id;
	private String nome;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataInicio;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataFim;
	
	@ManyToOne
	private TipoEvento tipoEvento;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AtividadeEvento> atividades;
	
	@ManyToOne
	private Instituicao instituicao; //E, se for um evento de mais de uma instituicao?
	
	@ManyToOne
	private FaseEvento faseEvento;
	
	public Evento() {
		// TODO Auto-generated constructor stub
	}
	
	public void addAtividade(AtividadeEvento ae){
		if (this.getAtividades() == null)
			this.atividades = new ArrayList<AtividadeEvento>();
		
		this.atividades.add(ae);
		ae.setEvento(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id + " - " +this.nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoEvento getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEvento tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public List<AtividadeEvento> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<AtividadeEvento> atividades) {
		this.atividades = atividades;
	}

	public Instituicao getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(Instituicao instituicao) {
		this.instituicao = instituicao;
	}

	public FaseEvento getFaseEvento() {
		return faseEvento;
	}

	public void setFaseEvento(FaseEvento faseEvento) {
		this.faseEvento = faseEvento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Calendar dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Calendar getDataFim() {
		return dataFim;
	}

	public void setDataFim(Calendar dataFim) {
		this.dataFim = dataFim;
	}

	
}

