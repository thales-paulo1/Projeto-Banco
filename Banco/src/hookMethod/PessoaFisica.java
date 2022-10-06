package hookMethod;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String name, double rendaMensal) {
		super(name, rendaMensal);
	}

	@Override
	protected double calcularImpostoMensal() {
		return (this.getRendaMensal() * 7.5)  / 100 ;
	}
}
