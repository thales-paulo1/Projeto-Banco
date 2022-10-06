package strategy;

public class Cdi implements CalculoJuroRendaFixa {

	public double calcularJuro(double dinheiro) {
		return (dinheiro * 13.75) /100;
	}

}
