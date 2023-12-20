package q1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = null;
		PrintWriter pw = null;
		
		try {
			sc = new Scanner(new File("entradaInvest.txt"));
			String linha = "";
			String[] campos = null;
			Investimento investimento = null;
			var investimentos = new ArrayList<Investimento>();
			do {
				linha = sc.nextLine();
				campos = linha.split(" ");
				String cpf = campos[0];
				InvestType tipoInvestimento = InvestType.valueOf(campos[1]); 
				Double taxaAoAno = Double.parseDouble(campos[2]);
				Integer tempoEmDias = Integer.parseInt(campos[3]);
				Double capitalInicial = Double.parseDouble(campos[4]);
				investimento = new Investimento(cpf, tipoInvestimento, taxaAoAno, tempoEmDias, capitalInicial);
				investimentos.add(investimento);
			}while(sc.hasNext());
			
			Collections.sort(investimentos);
			
			pw = new PrintWriter(new File("saidaInvest.txt"));
			for (Investimento invest : investimentos) {
				//System.out.println(invest);
				pw.println(invest);
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERRO: Arquivo não encontrado!");
		} finally {
			sc.close();
			pw.close();
		}
	}

}
