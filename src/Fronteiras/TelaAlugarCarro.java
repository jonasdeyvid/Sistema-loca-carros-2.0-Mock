package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCliente;

public class TelaAlugarCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro que você deseja alugar:\n");
		String placa = input.nextLine();
		
		if(ControladorCliente.getInstance().alugarCarro(placa)) {
			System.out.println("Carro alugado com sucesso");
		}else {
			System.out.println("erro ao alugar carro");
		}
	}
}
