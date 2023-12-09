package q2.services;

import java.time.LocalDate;

import q2.model.Contrato;
import q2.model.ContratoTrabalhoAutonomo;
import q2.model.OrdemPagamento;

public class ContratoService {
	private PagamentoService pagamentoService;

	public ContratoService(PagamentoService pagamentoService) {
		this.pagamentoService = pagamentoService;
	}

	public void processaContrato(Contrato contrato, int numeroOrdens) {
		double valorBase = contrato.getRemuneracaoTotal() / numeroOrdens;

		for (int i = 1; i <= numeroOrdens; i++) {
			LocalDate dataPagamento = contrato.getDataAssinatura().plusMonths(i);

			double contribuicao = 0.0;
			double adicional = pagamentoService.calculaAdicional(valorBase, i);
			
			if(contrato instanceof ContratoTrabalhoAutonomo) {
				ContratoTrabalhoAutonomo cta = (ContratoTrabalhoAutonomo) contrato;
				double porcentagemContribucao = cta.getPorcentagemContribuicaoINSS();
				contribuicao = pagamentoService.calculaContribuicao(valorBase + adicional, porcentagemContribucao);
			}
			
			double remuneracao = valorBase + adicional - contribuicao;

			contrato.getOrdensPagamento().add(new OrdemPagamento(dataPagamento, remuneracao));
		}
	}
}
