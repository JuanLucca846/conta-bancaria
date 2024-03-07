package conta.model;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numeroConta, int agencia, int tipo, String titular, float saldo, float limite) {

		// Método Construtor da Super Classe
		super(numeroConta, agencia, tipo, titular, saldo);
		// TODO Auto-generated constructor stub

		// atributo da classe
		this.limite = limite;
	}

	// Métodos de acesso
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	// Métodos Especificos
	@Override
	public boolean sacar(float valor) {
		if (this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\n Saldo Insuficiente!");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	@Override
	public void visualizar() {
		super.visualizar();
		System.out.println("Limite de crédito: " + this.limite);
	}

}
