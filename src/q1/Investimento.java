package q1;

public class Investimento implements Comparable<Investimento>{
	private String cpf;
	private String tipoInvestimento;
	private Double taxaAoAno;
	private Integer tempoEmDias;
	private Double capitalInicial;
	private static final double CDI = 4.9 / 100.0;

	public Investimento(String cpf, String tipoInvestimento, Double taxaAoAno, Integer tempoEmDias,
			Double capitalInicial) {
		this.cpf = cpf;
		this.tipoInvestimento = tipoInvestimento;
		this.taxaAoAno = taxaAoAno;
		this.tempoEmDias = tempoEmDias;
		this.capitalInicial = capitalInicial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTipoInvestimento() {
		return tipoInvestimento;
	}

	public void setTipoInvestimento(String tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}

	public Double getTaxaAoAno() {
		return taxaAoAno;
	}

	public void setTaxaAoAno(Double taxaAoAno) {
		this.taxaAoAno = taxaAoAno;
	}

	public Integer getTempoEmDias() {
		return tempoEmDias;
	}

	public void setTempoEmDias(Integer tempoEmDias) {
		this.tempoEmDias = tempoEmDias;
	}

	public Double getCapitalInicial() {
		return capitalInicial;
	}

	public void setCapitalInicial(Double capitalInicial) {
		this.capitalInicial = capitalInicial;
	}

	public double valorBruto() {
		double taxaReal = taxaAoAno / 100.0 * CDI;
		return capitalInicial * Math.pow((1 + taxaReal), tempoEmDias / 360.0);
	}

	public double juros() {
		return valorBruto() - capitalInicial;
	}

	public Double valorLiquido() {
		if (tipoInvestimento.compareToIgnoreCase("CDB") == 0) {
			double valorIR = 22.5 / 100.0;
			if(tempoEmDias <= 360)
				valorIR = 20.0 / 100.0;
			else if(tempoEmDias <= 720)
				valorIR = 17.0 / 100.0;
			else if(tempoEmDias > 720)
				valorIR = 15.0 / 100.0;
			return valorBruto() - juros() * valorIR;
		}

		return valorBruto();
	}

	@Override
	public String toString() {
		String fmt = "%.2f";
		return cpf + " " + tipoInvestimento + " " + 
		String.format(fmt, taxaAoAno) + " " +
		tempoEmDias + " " +
		String.format(fmt, capitalInicial) + " " +
		String.format(fmt, valorBruto()) + " " +
		String.format(fmt, juros()) + " " +
		String.format(fmt, valorLiquido());
	}

	@Override
	public int compareTo(Investimento o) {
		return -this.valorLiquido().compareTo(o.valorLiquido());
	}

}
