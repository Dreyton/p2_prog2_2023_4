package q2.services;

public class C20BankPagamentoService implements PagamentoService {
	private static final double PORCENTAGEM_ADICIONAL = 0.02;

	@Override
	public double calculaContribuicao(double quantia, double porcentagemContribuicaoINSS) {
		return quantia * porcentagemContribuicaoINSS / 100.0;
	}

	@Override
	public double calculaAdicional(double quantia, int numeroDaOrdem) {
		return quantia * PORCENTAGEM_ADICIONAL * numeroDaOrdem;
	}

}
