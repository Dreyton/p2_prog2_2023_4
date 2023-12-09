package q2.application;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import q2.model.Contrato;
import q2.model.ContratoTempoDeterminado;
import q2.model.ContratoTrabalhoAutonomo;
import q2.services.C20BankPagamentoService;
import q2.services.ContratoService;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre com dados básicos do contrato: ");
		System.out.print("Numero: ");
		int numero = sc.nextInt(); sc.nextLine();
		System.out.print("Data (dd/MM/yyyy) assinatura: ");
		LocalDate dataAssinatura = LocalDate.parse(sc.nextLine(), dtf);
		System.out.print("Remuneração total do contrato (sem adicional/INSS): ");
		double remuneracaoTotal = sc.nextDouble();
		
		System.out.println("Qual o tipo do contrato?");
		System.out.print("1 - Contrato por tempo determinado; 2 - Contrato de trabalho autônomo: ");
		int op = sc.nextInt(); sc.nextLine();
		
		ContratoService cs = new ContratoService(new C20BankPagamentoService());
		Contrato contrato = null;
		
		if(op == 1) {
			System.out.print("Data (dd/MM/yyyy) fim da vigência: ");
			LocalDate dataFimVigencia = LocalDate.parse(sc.nextLine(), dtf);
			var ctd = new ContratoTempoDeterminado(numero, dataAssinatura, remuneracaoTotal, dataFimVigencia);
			int n = Period.between(dataAssinatura, dataFimVigencia).getMonths();
			cs.processaContrato(ctd, n);
			contrato = ctd;
		}else {
			System.out.print("Porcentagem de Contribuicao INSS: ");
			double porcentagemContribuicaoINSS = sc.nextDouble();
			var cta = new ContratoTrabalhoAutonomo(numero, dataAssinatura, remuneracaoTotal, porcentagemContribuicaoINSS);
			System.out.print("Entre com o numero de ordens de pagamento: ");
			int n = sc.nextInt();
			cs.processaContrato(cta, n);
			contrato = cta;
		}
		
		System.out.println("\n" + "Ordens de pagamento: ");
		for (var ordem : contrato.getOrdensPagamento()) {
			System.out.println(ordem);
		}
		
		sc.close();

	}

}
