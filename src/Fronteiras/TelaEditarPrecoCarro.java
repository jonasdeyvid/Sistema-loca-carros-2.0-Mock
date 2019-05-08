package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCarro;

public class TelaEditarPrecoCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro:\n");
		String placa = input.nextLine();
		System.out.println("Digite o novo preco do carro");
		int preco = input.nextInt();
		
		if(ControladorCarro.getInstance().editarPrecoCarro(placa, preco)) {
			System.out.println("Preco alterado com sucesso");
		}else {
			System.out.println("Erro ao alterar preco");
		}
	}
}
