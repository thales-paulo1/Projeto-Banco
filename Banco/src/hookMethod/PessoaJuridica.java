package hookMethod;

public class PessoaJuridica extends Pessoa {
	
	public PessoaJuridica(String name, double rendaMensal) {
		super(name, rendaMensal);
	}

	@Override
	protected double calcularImpostoMensal() {
		return (this.getRendaMensal() * 15) /100;
	}
}
