package br.edu.ifpi.ads.entidade;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class EspacoFisico {
	
	@Id @GeneratedValue
	private int id;
	private String nome;
	
	@OneToMany
	private List<EspacoFisico> espacosFilhos;
	
	@ManyToOne
	private EspacoFisico espacoPai;
	
	
	public EspacoFisico() {
		// TODO Auto-generated constructor stub
	}


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


	public List<EspacoFisico> getEspacosFilhos() {
		return espacosFilhos;
	}


	public void setEspacosFilhos(List<EspacoFisico> espacosFilhos) {
		this.espacosFilhos = espacosFilhos;
	}


	public EspacoFisico getEspacoPai() {
		return espacoPai;
	}


	public void setEspacoPai(EspacoFisico espacoPai) {
		this.espacoPai = espacoPai;
	}
	
	

}
