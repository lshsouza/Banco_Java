package main;

public class Conta {
	float saldo;
	Banco banco;
	
	public Conta (float saldo) {
		this.saldo = saldo;
		this.banco = Main.banco;
	}
	
	// Confere se a conta tem saldo o suficiente
	public boolean temSaldo(float saldo) {
		return this.saldo >= saldo;
	}
}
