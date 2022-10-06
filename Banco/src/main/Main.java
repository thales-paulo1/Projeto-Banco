package main;

import java.util.Scanner;

import hookMethod.*;
import nullObject.ClienteAbstrato;
import nullObject.ClienteDAO;
import observer.Bancos;
import observer_nullObject.Cliente;
import state.Conta;

import strategy.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Conta conta = new Conta();

		boolean loop = true;
		Scanner ler = new Scanner(System.in);

		while (loop == true) {
			System.out.println("\n----------------------------");
			System.out.println("BANCO EXPERIMENTAL" + "\n0 - Sair do banco." + "\n1 - Fazer depósito."
					+ "\n2 - Fazer saque." + "\n3 - Consultar saldo." + "\n4 - Simular renda fixa."
					+ "\n5 - Ofertas dos bancos para você." + "\n6 - Valor de impostos para pessoa física."
					+ "\n7 - Valor de impostos para pessoa jurídica.");
			int n = ler.nextInt();
			switch (n) {
			case 0: {
				loop = false;
				System.out.println("\nObrigado por usar!\n");
				break;
			}

			case 1: {
				System.out.println("Quanto de depósito você quer fazer?");
				System.out.println("Saldo atual: " + conta);
				Scanner depositoConta = new Scanner(System.in);
				double valorDeposito = depositoConta.nextDouble();
				conta.deposito(valorDeposito);
				System.out.println("Depósito de: " + valorDeposito);
				System.out.println("Saldo atual: " + conta);
				break;
			}

			case 2: {
				System.out.println("Quanto você quer sacar?");
				System.out.println("Saldo atual: " + conta);
				Scanner saqueConta = new Scanner(System.in);
				double valorSaque = saqueConta.nextDouble();
				conta.saque(valorSaque);
				System.out.println("Saque de: " + valorSaque);
				System.out.println("Saldo atual: " + conta);
				break;
			}

			case 3: {
				System.out.println("Saldo atual: " + conta);
				break;
			}

			case 4: {
				Scanner entrada = new Scanner(System.in);
				System.out.println("Informe o valor: ");
				double dinheiro = entrada.nextDouble();
				System.out.println("Com qual tipo de juro você deseja saber?" + "\n1 - CDI 100%. \n2 - Poupança."
						+ "\n3 - Digitar valor do juro.");
				int opcaoTipoJuro = entrada.nextInt();

				TipoJuro tipoJuro = TipoJuro.values()[opcaoTipoJuro - 1];

				CalculoJuroRendaFixa calculoJuroRendaFixa = tipoJuro.obterTipoJuro();
				double valorJuro = calculoJuroRendaFixa.calcularJuro(dinheiro);
				double valorTotal = valorJuro + dinheiro;
				System.out.printf("Em um ano você terá R$%.2f.\n", valorTotal);
				break;
			}

			case 5: {

				System.out.println("\nDigite seu nome.");
				Scanner input = new Scanner(System.in);
				String nome = input.next();
				Bancos nuBank = new Bancos("NuBank");
				Bancos inter = new Bancos("Inter");

				Cliente c1 = new Cliente(nome);
				ClienteAbstrato c11 = ClienteDAO.getCliente(nome);

				System.out.println(c11.getName() + "\n");

				nuBank.addObserver(c1);
				inter.addObserver(c1);

				nuBank.notify("Faça um empréstimo de até 25 mil.");
				inter.notify("Abra uma conta agora mesmo com direito a cartão sem anuídade.");

				break;
			}

			case 6: {
				System.out.println("\nDigite o seu nome.");
				Scanner input = new Scanner(System.in);
				String nome = input.next();
				System.out.println("Digite a renda Mensal.");
				double rendaMensal = input.nextDouble();

				Pessoa pf1 = new PessoaFisica(nome, rendaMensal);

				System.out.println("O imposto mensal será: R$" + pf1.calcularImpostoAnual() / 12
						+ "\nO imposto anual será: R$" + pf1.calcularImpostoAnual());
				break;
			}

			case 7: {
				System.out.println("\nDigite o nome da empresa.");
				Scanner input = new Scanner(System.in);
				String nome = input.next();
				System.out.println("Digite a renda Mensal.");
				double rendaMensal = input.nextDouble();

				Pessoa pj1 = new PessoaJuridica(nome, rendaMensal);

				System.out.println("O imposto mensal será: R$" + pj1.calcularImpostoAnual() / 12
						+ "\nO imposto anual será: R$" + pj1.calcularImpostoAnual());
				break;
			}
			default:
				throw new IllegalArgumentException(
						"Não há o valor: " + n + " nas opções, por favor, insira um valor válido!");
			}

		}

	}

}
