package state;

public class ContaNegativa extends ContaEstado{

	public ContaNegativa(Conta conta) {
		super(conta);
	}

	@Override
	public String toString() {
		return "Conta Negativa";
	}
	
	
}
