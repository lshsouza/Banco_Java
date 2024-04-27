package main;

import java.util.Random;

public class Cliente extends Thread{
	Conta conta;
	String nome;
	int atividade; // Com quanta frequência ele faz compras
	
	Random random;
	
	public Cliente(String nome, int atividade) {
		this.conta = new Conta(Main.contaClientesGeral);
	    this.nome = nome;
	    this.atividade = atividade;

		this.random = new Random();
		
		// A thread iniciará assim que instânciada
		this.start();
	}
	
	@Override
	public void run() {
		
		Loja qualLoja; // Em qual loja o cliente comprará?
		float qualValor = 100.00f; // Quanto o cliente gastará? Vamos começar com R$100
		
		while (conta.temSaldo(qualValor)) {
			
			/* Não foi claro se a alternância entre as lojas
			 * era aleatória ou não. Então prossegui na ideia
			 * da aleatoriedade */
			if (random.nextBoolean()) { qualLoja = Main.americanas; }
			else { qualLoja = Main.casasBahia; }
			
			// O cliente gasta R$100 ou R$200 na loja sorteada
			this.comprar(qualLoja, qualValor);
			
			// Esperamos um tempo (var atividade) para tentar comprar novamente
			try {
				Thread.sleep(atividade);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Sorteia o próximo valor que gastará
			if (random.nextBoolean()) { qualValor = 100.00f; }
			else { 
				qualValor = 200.00f;
				
				// Impedindo as compras de parar caso ele ainda tenha 100 sobrando
				if (!conta.temSaldo(qualValor)) { qualValor = 100.00f;}
			}
		}
	}
	
	// Função para efetuar as compras do cliente
	public void comprar(Loja loja, float preco) {
		if (conta.temSaldo(preco)) {
			this.conta.banco.transferir(preco, this.conta, loja.conta);
			loja.notificar();
			System.out.println(this.nome + " gastou R$" + preco + " em " + loja.nome);
		}
	}
}
