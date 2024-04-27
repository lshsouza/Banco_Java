package main;

public class Banco {
	String nome;
	
	public Banco(String nome) {
		this.nome = nome;
	}
	
	// "transferir" é síncrona, pois só uma thread pode fazer uma transferência de cada vez
	public synchronized void transferir(float valor, Conta remetente, Conta destinatario) {
		
		remetente.saldo -= valor;
		destinatario.saldo += valor;
		
		/* Não é conferido se o remetente realmente tem saldo o suficiente
		 * para a transferência pois ele pode ficar com saldo negativo, 
		 * Devendo ao banco. É mais prático deixar que o próprio remetente
		 * confira antes de fazer tal tranferência (que é o nosso caso). */
	}
}
