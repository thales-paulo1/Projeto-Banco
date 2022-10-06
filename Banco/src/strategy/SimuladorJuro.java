package strategy;

import java.util.Scanner;

public class SimuladorJuro implements CalculoJuroRendaFixa {

	@Override
	public double calcularJuro(double dinheiro) {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite o valor do juro: ");
		double juro = input.nextDouble();
		return (dinheiro * juro) / 100;
	}

}
