package br.edu.ifpi.ads.entidade;

import java.util.Calendar;

public class DescontoProgramado {
	
	private int id;
	private Evento evento;
	private SegmentoUsuario segmentoUsuario;
	private double percentual;
	private Calendar validade;
	
	public DescontoProgramado() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public SegmentoUsuario getSegmentoUsuario() {
		return segmentoUsuario;
	}

	public void setSegmentoUsuario(SegmentoUsuario segmentoUsuario) {
		this.segmentoUsuario = segmentoUsuario;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public Calendar getValidade() {
		return validade;
	}

	public void setValidade(Calendar validade) {
		this.validade = validade;
	}
	
	
	

}
