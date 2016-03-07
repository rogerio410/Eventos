package br.edu.ifpi.ads.entidade;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value="composto")
public class AtividadeEventoComposto extends AtividadeEvento{
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<AtividadeEvento> atividades;
	
	private double desconto; //10% = 0.1
	
	public void addItemNoKit(AtividadeEvento atividadeEvento){
		//TODO quais restrições no KitAtividadeEvento
		if (atividades == null){
			this.atividades = new ArrayList<AtividadeEvento>();
		}
		
		atividades.add(atividadeEvento);
		
	}

	@Override
	public Double getValor() {
		Double somatorio = 0.0;
		for (AtividadeEvento atividadeEvento : atividades) {
			somatorio += atividadeEvento.getValor();
		}
		return somatorio*desconto;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public Calendar getHorario() {
		// TODO Qual será o horário?? 
		return null;
	}
	
	@Override
	public void setHorario(Calendar horario) {
		// TODO Auto-generated method stub
	}

	public List<AtividadeEvento> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<AtividadeEvento> atividades) {
		this.atividades = atividades;
	}


}
