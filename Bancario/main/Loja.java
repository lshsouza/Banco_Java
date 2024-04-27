package main;

public class Loja {
	String nome;
	Conta conta;
	float salario;

	Funcionario funcionario1;
	Funcionario funcionario2;

	boolean qualPagar = true;

	public Loja(String nome, float salario) {
		this.nome = nome;
		this.salario = salario;

		this.conta = new Conta(0f);
		
		this.funcionario1 = new Funcionario("Funcionário 1", this);
		this.funcionario2 = new Funcionario("Funcionário 2", this);
	}

	// Será chamada toda vez que realizar uma venda. Para conferir se deve pagar os salários
	public void notificar() {
		if (this.conta.saldo >= this.salario) {
			
			// Confere quem irá pagar dessa vez
			if (this.qualPagar) { 
				this.pagar(funcionario1); 
				this.qualPagar = false; // Alterna a vez
			}
			else {
				this.pagar(funcionario2); 
				this.qualPagar = true; // Alterna a vez
			}
		}
		
		/* Seria o ideal pagar todos os funcionários de uma vez só toda vez que a conta
		 * da loja tivesse o valor suficiente para pagar todos (R$2800,00), mas o enunciado
		 * da questão diz R$1400,00. Então, toda vez que a loja alcança R$1400,00 ela paga
		 * um funcionário.*/
	}

	public void pagar(Funcionario funcionario) {
		this.conta.banco.transferir(this.salario, this.conta, funcionario.contaSalario);
		System.out.println(funcionario.nome + " da loja " 
				+ this.nome + " recebeu R$" + this.salario + " de salário");
		funcionario.notificar(this.salario);
	}
}
