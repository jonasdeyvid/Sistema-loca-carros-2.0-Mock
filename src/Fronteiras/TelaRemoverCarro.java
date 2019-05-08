package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCarro;

public class TelaRemoverCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro:\n");
		String placa = input.nextLine();
		
		if(ControladorCarro.getInstance().removerCarro(placa)) {
			System.out.println("Carro removido com sucesso");
		}else {
			System.out.println("Erro ao remover carro");
		}
	}
}
