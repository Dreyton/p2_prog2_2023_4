package q2.model;

import java.time.LocalDate;

public class ContratoTrabalhoAutonomo extends Contrato {

	private Double porcentagemContribuicaoINSS;

	public ContratoTrabalhoAutonomo(Integer numero, LocalDate dataAssinatura, Double remuneracaoTotal,
			Double porcentagemContribuicaoINSS) {
		super(numero, dataAssinatura, remuneracaoTotal);
		this.porcentagemContribuicaoINSS = porcentagemContribuicaoINSS;
	}

	public Double getPorcentagemContribuicaoINSS() {
		return porcentagemContribuicaoINSS;
	}

	public void setPorcentagemContribuicaoINSS(Double porcentagemContribuicaoINSS) {
		this.porcentagemContribuicaoINSS = porcentagemContribuicaoINSS;
	}

}
