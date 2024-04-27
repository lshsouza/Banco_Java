package main;

public class Main {
	static Banco banco;
	static Loja americanas;
	static Loja casasBahia;
	
	static float salarioGeral = 1400f;
	static float contaClientesGeral = 1000f;
	
	public static void main(String[] args) {
		banco = new Banco("Bradesco");
		
		americanas = new Loja("Americanas", salarioGeral);
		casasBahia = new Loja("Casas Bahia", salarioGeral);
		
		Cliente cliente1 = new Cliente("Cliente 1", 500);
		Cliente cliente2 = new Cliente("Cliente 2", 1000);
		Cliente cliente3 = new Cliente("Cliente 3", 1500);
		Cliente cliente4 = new Cliente("Cliente 4", 2000);
		Cliente cliente5 = new Cliente("Cliente 5", 2500);
		
		try {
			cliente1.join();
			cliente2.join();
			cliente3.join();
			cliente4.join();
			cliente5.join();
		} catch (Exception e) {}
		
		System.out.println("--------------------------------------------");
		System.out.println(
				americanas.nome + ": \n" +
				"(R$" + americanas.conta.saldo + ")\n" +
				"    " + americanas.funcionario1.nome + ": \n " +
				"        Conta: R$"
				+ americanas.funcionario1.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ americanas.funcionario1.contaInvestimento.saldo + "\n" +
				"    " + americanas.funcionario2.nome + ": \n " +
				"        Conta: R$"
				+ americanas.funcionario2.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ americanas.funcionario2.contaInvestimento.saldo + "\n\n" +
				
				casasBahia.nome + ": \n" +
				"(R$" + casasBahia.conta.saldo + ")\n" +
				"    " + casasBahia.funcionario1.nome + ": \n " +
				"        Conta: R$"
				+ casasBahia.funcionario1.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ casasBahia.funcionario1.contaInvestimento.saldo + "\n" +
				"    " + casasBahia.funcionario2.nome + ": \n " +
				"        Conta: R$"
				+ casasBahia.funcionario2.contaSalario.saldo + "\n " + 
				"        Investimento: R$"
				+ casasBahia.funcionario2.contaInvestimento.saldo + "\n");
	}
}
