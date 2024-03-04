package conta;

import java.util.Scanner;

import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcao;

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

			opcao = scanner.nextInt();

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
				break;
			case 2:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Listar todas as contas\n\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Buscar conta por numero\n\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Atualizar dados da conta\n\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Apagar conta\n\n");
				break;
			case 6:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Sacar\n\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Depositar\n\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_BLACK_BOLD + "Transferir valores entre contas\n\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "Opção inválida!\n");
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

}
