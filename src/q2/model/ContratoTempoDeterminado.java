package q2.model;

import java.time.LocalDate;

public class ContratoTempoDeterminado extends Contrato {
	private LocalDate dataFimVigencia;

	public ContratoTempoDeterminado(Integer numero, LocalDate dataAssinatura, Double remuneracaoTotal,
			LocalDate dataFimVigencia) {
		super(numero, dataAssinatura, remuneracaoTotal);
		this.dataFimVigencia = dataFimVigencia;
	}

	public LocalDate getDataFimVigencia() {
		return dataFimVigencia;
	}

	public void setDataFimVigencia(LocalDate dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

}
