package q2.services;

public interface PagamentoService {
	double calculaContribuicao(double quantia, double porcentagemContribuicaoINSS);
	double calculaAdicional(double quantia, int numeroDaOrdem);
}
