package main;

public class Funcionario extends Thread {
	String nome;
	Loja loja;

	Conta contaSalario;
	Conta contaInvestimento;

	public Funcionario(String nome, Loja loja) {
		this.nome = nome;
		this.loja = loja;

		contaSalario = new Conta(0f);
		contaInvestimento = new Conta(0f);
	}

	// Chamada quando o funcionário recebe seu salário
	public void notificar(float salario) {
		this.investir(salario, 20f);
	}

	public void investir(float valor, float porcento) {
		float valorFinal = (porcento * valor) / 100;
		contaSalario.banco.transferir(valorFinal, contaSalario, contaInvestimento);
		System.out.println(this.nome + " da loja " + this.loja.nome + " investiu R$" +
				valorFinal + " na sua conta de investimentos");
	}
}
