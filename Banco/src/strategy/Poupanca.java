package strategy;

public class Poupanca implements CalculoJuroRendaFixa {
	
	public double calcularJuro(double dinheiro) {
		return (dinheiro * 6.5) /100;
	}


}
