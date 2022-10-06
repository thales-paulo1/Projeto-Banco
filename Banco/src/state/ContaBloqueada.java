package state;

public class ContaBloqueada extends ContaEstado {

	public ContaBloqueada(Conta conta) {
		super(conta);
	}

	@Override
	public String toString() {
		return "Conta Bloqueada";
	}
	
	protected void doSaque(double valor) throws Exception {
		
		throw new Exception("Conta bloqueada, não é possível fazer saque");

	}

}
