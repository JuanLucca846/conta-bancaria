package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		ContaController contas = new ContaController();

		Scanner scanner = new Scanner(System.in);
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		System.out.println("\nCriar Contas\n");

		ContaCorrente contaCorrente1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "Joao da Silva", 1000f, 100f);
		contas.cadastrar(contaCorrente1);

		ContaCorrente contaCorrente2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 2000f, 100f);
		contas.cadastrar(contaCorrente2);

		ContaPoupanca contaPoupanca1 = new ContaPoupanca(contas.gerarNumero(), 125, 2, "Mariana dos Santos", 4000f, 12);
		contas.cadastrar(contaPoupanca1);

		ContaPoupanca contaPoupanca2 = new ContaPoupanca(contas.gerarNumero(), 126, 2, "Juliana Ramos", 8000f, 15);
		contas.cadastrar(contaPoupanca2);

		contas.listarTodas();

		while (true) {
			System.out.println(Cores.TEXT_BLUE_BOLD_BRIGHT + "********************************************");
			System.out.println("                             				");
			System.out.println("		BANCO DO BRAZIL COM Z	 			");
			System.out.println("                             				");
			System.out.println("********************************************");
			System.out.println("                             				");
			System.out.println("		1 - Criar Conta	 	 				");
			System.out.println("		2 - Listar todas as contas			");
			System.out.println("		3 - Buscar conta por numero			");
			System.out.println("		4 - Atualizar dados da conta		");
			System.out.println("		5 - Apagar conta					");
			System.out.println("		6 - Sacar							");
			System.out.println("		7 - Depositar						");
			System.out.println("		8 - Transferir valores entre contas	");
			System.out.println("		9 - Sair							");
			System.out.println("                             				");
			System.out.println("********************************************");
			System.out.println("Entre com a opção desejada:  				");
			System.out.println("                             				");

			try {
				opcao = scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao = 0;
			}

			if (opcao == 9) {
				System.out.println(Cores.TEXT_BLACK_BOLD + "\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
				;
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Criar Conta\n\n");
				System.out.println("Digite o numero da agência: ");
				agencia = scanner.nextInt();
				System.out.println("Digite o nome do titular: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();

				do {
					System.out.println("Digite o tipo da conta (1-CC ou 2-CP): ");
					tipo = scanner.nextInt();
				} while (tipo < 1 && tipo > 2);

				System.out.println("Digite o saldo da conta (R$:) ");
				saldo = scanner.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite de crédito (R$:) ");
					limite = scanner.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversario da conta: ");
					aniversario = scanner.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Listar todas as contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Buscar conta por numero\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				contas.procurarPorNumero(numero);
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Atualizar dados da conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				var buscarConta = contas.buscarNaCollection(numero);

				if (buscarConta != null) {
					tipo = buscarConta.getTipo();

					System.out.println("Digite o número da agencia: ");
					agencia = scanner.nextInt();
					System.out.println("Digite o nome do titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();

					System.out.println("Digite o saldo da conta: ");
					saldo = scanner.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Digite o limite de credito (R$): ");
						limite = scanner.nextFloat();

						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> {
						System.out.println("Digite o dia de aniversario da conta: ");
						aniversario = scanner.nextInt();

						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
					}
				} else {
					System.out.println("A conta não foi encontrada!");
				}
				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Apagar conta\n\n");
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();

				contas.deletar(numero);
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Sacar\n\n");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Depositar\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Transferir valores entre contas\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida!\n");

				keyPress();
				break;
			}

		}

	}

	public static void sobre() {
		System.out.println("\n********************************************");
		System.out.println("Projeto desenvolvido por: Juan Lucca		  ");
		System.out.println("lucca470@gmail.com	 						  ");
		System.out.println("https://github.com/JuanLucca846          	  ");
		System.out.println("**********************************************");
	}

	public static void keyPress() {
		try {
			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla diferente de enter!");
		}
	}

}
