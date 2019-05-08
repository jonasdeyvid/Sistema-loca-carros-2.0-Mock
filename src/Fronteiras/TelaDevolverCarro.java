package Fronteiras;

import java.util.Scanner;

import Controles.ControladorCliente;

public class TelaDevolverCarro {
	public static void mostrar() {
		Scanner input = new Scanner(System.in);
		System.out.println("Digite a placa do carro que você deseja devolver:\n");
		String placa = input.nextLine();
		if(ControladorCliente.getInstance().devolverCarro(placa)) {
			System.out.println("Carro devolvido com sucesso");
		}else {
			System.out.println("Erro ao devolver carro");
		}
	}
}
