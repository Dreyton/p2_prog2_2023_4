package q2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrdemPagamento {
	private LocalDate dataPagamento;
	private Double remuneracao;

	public OrdemPagamento(LocalDate dataPagamento, Double remuneracao) {
		this.dataPagamento = dataPagamento;
		this.remuneracao = remuneracao;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(Double remuneracao) {
		this.remuneracao = remuneracao;
	}

	@Override
	public String toString() {
		return dataPagamento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " - " +
	           String.format("%.2f", remuneracao);
	}

	
	
}
