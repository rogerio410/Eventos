package br.edu.ifpi.ads.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CupomPromocional {
	
	@Id
	@GeneratedValue
	private int id;
	private String numero;
	
	@ManyToOne
	private TipoCupomPromocional tipoCupomPromocional; // Desconto Percentual | Almoco Gratis | Camisa Gratis
	
	public CupomPromocional() {
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

	public TipoCupomPromocional getTipoCupomPromocional() {
		return tipoCupomPromocional;
	}

	public void setTipoCupomPromocional(TipoCupomPromocional tipoCupomPromocional) {
		this.tipoCupomPromocional = tipoCupomPromocional;
	}
	
	
}
