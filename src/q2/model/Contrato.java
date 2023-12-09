package q2.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import q2.enums.Status;

public abstract class Contrato {
	private Integer numero;
	private LocalDate dataAssinatura;
	private Double remuneracaoTotal;
	private Status status;
	private List<OrdemPagamento> ordensPagamento = new ArrayList<>();
	
	public Contrato(Integer numero, LocalDate dataAssinatura, Double remuneracaoTotal) {
		this.numero = numero;
		this.dataAssinatura = dataAssinatura;
		this.remuneracaoTotal = remuneracaoTotal;
		this.status = Status.PENDENTE;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(LocalDate dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public Double getRemuneracaoTotal() {
		return remuneracaoTotal;
	}

	public void setRemuneracaoTotal(Double remuneracaoTotal) {
		this.remuneracaoTotal = remuneracaoTotal;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<OrdemPagamento> getOrdensPagamento() {
		return ordensPagamento;
	}
	
	
}
